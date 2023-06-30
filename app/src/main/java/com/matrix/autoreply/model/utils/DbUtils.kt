package xyz.yingshaoxo.calling2email.model.utils

import android.content.Context
import xyz.yingshaoxo.calling2email.model.CustomRepliesData
import xyz.yingshaoxo.calling2email.logs.database.MessageLogsDB
import android.service.notification.StatusBarNotification
import xyz.yingshaoxo.calling2email.logs.data.AppPackage
import xyz.yingshaoxo.calling2email.logs.data.MessageLog

class DbUtils(private val mContext: Context) {
    private var customRepliesData: CustomRepliesData? = null
    val nunReplies: Long
        get() {
            val messageLogsDB = MessageLogsDB.getInstance(mContext.applicationContext)
            return messageLogsDB!!.logsDao()!!.numReplies
        }

    fun purgeMessageLogs() {
        val messageLogsDB = MessageLogsDB.getInstance(mContext.applicationContext)
        messageLogsDB!!.logsDao()!!.purgeMessageLogs()
    }

    fun logReply(sbn: StatusBarNotification, title: String?) {
        customRepliesData = CustomRepliesData.getInstance(mContext)
        val messageLogsDB = MessageLogsDB.getInstance(mContext.applicationContext)
        var packageIndex = messageLogsDB!!.appPackageDao()!!.getPackageIndex(sbn.packageName)
        if (packageIndex <= 0) {
            val appPackage = AppPackage(sbn.packageName)
            messageLogsDB.appPackageDao()!!.insertAppPackage(appPackage)
            packageIndex = messageLogsDB.appPackageDao()!!.getPackageIndex(sbn.packageName)
        }
        val logs = MessageLog(
            packageIndex,
            title!!,
            sbn.notification.`when`,
            customRepliesData!!.getTextToSendOrElse(null),
            System.currentTimeMillis()
        )
        messageLogsDB.logsDao()!!.logReply(logs)
    }

    fun getLastRepliedTime(packageName: String?, title: String?): Long {
        val messageLogsDB = MessageLogsDB.getInstance(mContext.applicationContext)
        return messageLogsDB!!.logsDao()!!.getLastReplyTimeStamp(title, packageName)
    }

    val firstRepliedTime: Long
        get() {
            val messageLogsDB = MessageLogsDB.getInstance(mContext.applicationContext)
            return messageLogsDB!!.logsDao()!!.firstRepliedTime
        }
}