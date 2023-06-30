package xyz.yingshaoxo.calling2email.logs.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import kotlin.jvm.Synchronized
import androidx.room.Room
import xyz.yingshaoxo.calling2email.logs.data.AppPackage
import xyz.yingshaoxo.calling2email.logs.data.MessageLog
import xyz.yingshaoxo.calling2email.logs.repository.AppPackageDao
import xyz.yingshaoxo.calling2email.logs.repository.MessageLogsDao
import xyz.yingshaoxo.calling2email.model.utils.Constants

@Database(entities = [MessageLog::class, AppPackage::class], version = 2)
abstract class MessageLogsDB : RoomDatabase() {
    abstract fun logsDao(): MessageLogsDao?
    abstract fun appPackageDao(): AppPackageDao?

    companion object {
        private const val DB_NAME = Constants.LOGS_DB_NAME
        private var _instance: MessageLogsDB? = null
        @JvmStatic
        @Synchronized
        fun getInstance(context: Context): MessageLogsDB? {
            if (_instance == null) {
                _instance = Room.databaseBuilder(context.applicationContext, MessageLogsDB::class.java, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return _instance
        }
    }
}