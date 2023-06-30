package xyz.yingshaoxo.calling2email.ui.activity.settings

import android.os.Bundle
import xyz.yingshaoxo.calling2email.R
import xyz.yingshaoxo.calling2email.ui.activity.BaseActivity

class SettingsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        window.statusBarColor = resources.getColor(R.color.colorPrimary)
    }
}