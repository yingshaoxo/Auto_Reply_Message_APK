package xyz.yingshaoxo.calling2email.model.utils

import xyz.yingshaoxo.calling2email.model.App


object Constants {

    const val PERMISSION_DIALOG_TITLE = "permission_dialog_title"
    const val PERMISSION_DIALOG_MSG = "permission_dialog_msg"
    const val PERMISSION_DIALOG_DENIED_TITLE = "permission_dialog_denied_title"
    const val PERMISSION_DIALOG_DENIED_MSG = "permission_dialog_denied_msg"
    const val PERMISSION_DIALOG_DENIED = "permission_dialog_denied"
    const val LOGS_DB_NAME = "logs_messages_db"
    const val NOTIFICATION_CHANNEL_ID = "autoreply"
    const val NOTIFICATION_CHANNEL_NAME = "autoreply_channel"

    val SUPPORTED_APPS: List<App> = mutableListOf(
            App("WhatsApp", "com.whatsapp"),
            App("Facebook Messenger", "com.facebook.orca")
    )

    const val MIN_DAYS = 0
    const val MAX_DAYS = 7
}