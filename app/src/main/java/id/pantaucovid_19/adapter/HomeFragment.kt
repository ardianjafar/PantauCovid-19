package id.pantaucovid_19.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.pantaucovid_19.R
import id.pantaucovid_19.api.InternasionalPandemiItem
import id.pantaucovid_19.data.InternasionalService
import id.pantaucovid_19.data.apiRequest
import id.pantaucovid_19.data.httpClient
import id.pantaucovid_19.util.dismissLoading
import id.pantaucovid_19.util.showLoading
import id.pantaucovid_19.util.tampilToast
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.swipeRefreshLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private fun callApiInterUser() {
        showLoading(context!!, swipeRefreshLayout)

        val httpClient = httpClient()
        val apiRequest = apiRequest<InternasionalService>(httpClient)

        val call = apiRequest.getDataItr()
        call.enqueue(object : Callback<List<InternasionalPandemiItem>> {
            override fun onFailure(call: Call<List<InternasionalPandemiItem>>, t: Throwable) {
                dismissLoading(swipeRefreshLayout)
            }

            override fun onResponse(
                call: Call<List<InternasionalPandemiItem>>,
                response: Response<List<InternasionalPandemiItem>>
            ) {
                dismissLoading(swipeRefreshLayout)
                when{
                    response.isSuccessful->when{
                        response.body()?.size != 0 ->tampilCovidInter(response.body()!!)
                        else-> tampilToast(context!!,"berhasil")
                    }else-> tampilToast(context!!,"gagal")
                }
            }

        })
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_home,
        container,false)
    }

    override fun onViewCreated
                (view: View,
                 @Nullable savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        callApiInterUser()
    }
    private fun tampilCovidInter(getDataItr : List<InternasionalPandemiItem>) {
        listGithub.layoutManager = LinearLayoutManager(context)
        listGithub.adapter =
            PantauIntrAdapter(context!!, getDataItr) {

                val kawalInter = it
                tampilToast(context!!, kawalInter.countryRegion)
            }
    }
}