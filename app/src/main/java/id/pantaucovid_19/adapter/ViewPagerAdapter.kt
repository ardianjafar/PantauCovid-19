package id.pantaucovid_19.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.pantaucovid_19.fragment.NewsFragment
import id.pantaucovid_19.fragment.PendidikanFragment
import id.pantaucovid_19.fragment.ProtokolFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity){
    private val JUMLAH_MENU = 4
    override fun createFragment(position: Int): Fragment {

        when(position) {
            0 -> { return HomeFragment()
            }
            1 -> { return NewsFragment()
            }
            2 -> { return ProtokolFragment()
            }
            3 -> { return PendidikanFragment()
            }
            else -> {
                return NewsFragment()
            }
        }
    }
    override fun getItemCount(): Int {
        return JUMLAH_MENU
    }
}