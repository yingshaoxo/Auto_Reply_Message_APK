package xyz.yingshaoxo.calling2email.ui.activity

import android.content.Context
import xyz.yingshaoxo.calling2email.model.preferences.PreferencesManager.Companion.getPreferencesInstance
import xyz.yingshaoxo.calling2email.model.utils.ContextWrapper.Companion.wrap
import androidx.appcompat.app.AppCompatActivity
import android.os.Build

open class BaseActivity : AppCompatActivity() {
    override fun attachBaseContext(newBase: Context) {
        val prefs = getPreferencesInstance(newBase)
        val contextWrapper = wrap(newBase, prefs!!.selectedLocale)
        super.attachBaseContext(contextWrapper)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && Build.VERSION.SDK_INT
            <= Build.VERSION_CODES.N_MR1) applyOverrideConfiguration(
            contextWrapper.resources.configuration
        )
    }
}