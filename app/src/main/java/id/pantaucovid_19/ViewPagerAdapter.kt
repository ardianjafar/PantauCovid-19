package id.pantaucovid_19

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter (fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private val JUMLAH_MENU = 3
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> { return HomeFragment() }
            1 -> { return HelpFeedbackFragment() }
            2 -> { return StatusFragment() }
            else -> {
                return HomeFragment()
            }
        }
    }

    override fun getItemCount(): Int {
        return JUMLAH_MENU
    }
}