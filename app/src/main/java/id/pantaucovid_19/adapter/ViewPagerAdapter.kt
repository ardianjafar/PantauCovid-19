package id.pantaucovid_19.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.pantaucovid_19.fragment.FragmentProvinsi
import id.pantaucovid_19.fragment.FragmentOther
import id.pantaucovid_19.fragment.FragmentIndonesia
import id.pantaucovid_19.fragment.FragmentGlobal

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity){
    private val JUMLAH_MENU = 4
    override fun createFragment(position: Int): Fragment {

        when(position) {
            0 -> { return FragmentGlobal()
            }
            1 -> { return FragmentProvinsi()
            }
            2 -> { return FragmentIndonesia()
            }
            3 -> { return FragmentOther()
            }
            else -> {
                return FragmentProvinsi()
            }
        }
    }
    override fun getItemCount(): Int {
        return JUMLAH_MENU
    }
}