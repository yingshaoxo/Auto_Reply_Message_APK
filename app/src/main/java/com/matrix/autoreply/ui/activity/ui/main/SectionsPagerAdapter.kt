package xyz.yingshaoxo.calling2email.ui.activity.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import xyz.yingshaoxo.calling2email.R
import xyz.yingshaoxo.calling2email.ui.fragment.MainFragment
import xyz.yingshaoxo.calling2email.ui.fragment.SettingsFragment
import xyz.yingshaoxo.calling2email.ui.fragment.DeletedMessageFragment

private val TAB_TITLES = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2,
        R.string.tab_text_3
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null

        when (position) {
            0 -> fragment = MainFragment()
            1 -> fragment = DeletedMessageFragment()
            2 -> fragment = SettingsFragment()
        }

        return fragment!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 3
    }
}