package id.pantaucovid_19.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.pantaucovid_19.R
import id.pantaucovid_19.adapter.MyFriendAdapter
import id.pantaucovid_19.notesapp.MyFriend
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_other.*

class FragmentOther : Fragment() {
    lateinit var listTeman : ArrayList<MyFriend>
    private fun simulasiDataTeman() {
        listTeman = ArrayList()
        listTeman.add(MyFriend("Fakhry", "Laki-laki", "fakhry@smkcoding.id",
            "081123123123", "Malang"))
        listTeman.add(MyFriend("Ahmad", "Laki-laki", "ahmad@smkcoding.id",
            "085123123123", "Malang"))
    }
    private fun tampilTeman() {
        rv_listMyFriends.layoutManager = LinearLayoutManager(activity)
        rv_listMyFriends.adapter = MyFriendAdapter(activity!!, listTeman)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_other, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        /*getData()
        fab.setOnClickListener {
            val intent = Intent (getActivity(), MyFriendActivity::class.java)
            getActivity()?.startActivity(intent)
        }*/
    }
    private fun initView() {
        simulasiDataTeman()
        tampilTeman()
    }
    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }


}