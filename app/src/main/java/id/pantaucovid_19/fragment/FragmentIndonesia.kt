package id.pantaucovid_19.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.pantaucovid_19.api.IndonesiPandemiItem
import id.pantaucovid_19.R
import id.pantaucovid_19.adapter.PantauIndAdapter
import id.pantaucovid_19.data.IndonesiaService
import id.pantaucovid_19.data.apiRequest
import id.pantaucovid_19.data.httpClient
import id.pantaucovid_19.util.dismissLoading
import id.pantaucovid_19.util.showLoading
import id.pantaucovid_19.util.tampilToast
import kotlinx.android.synthetic.main.fragment_global.swipeRefreshLayout
import kotlinx.android.synthetic.main.fragment_indonesia.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentIndonesia : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private fun callApiIndoUser() {
        showLoading(context!!, swipeRefreshLayout)

        val httpClient = httpClient()
        val apiRequest = apiRequest<IndonesiaService>(httpClient)

        val call = apiRequest.getDataInd()
        call.enqueue(object : Callback<List<IndonesiPandemiItem>> {
            override fun onFailure(call: Call<List<IndonesiPandemiItem>>, t: Throwable) {
                dismissLoading(swipeRefreshLayout)
            }

            override fun onResponse(
                call: Call<List<IndonesiPandemiItem>>,
                response: Response<List<IndonesiPandemiItem>>
            ) {
                dismissLoading(swipeRefreshLayout)
                when{
                    response.isSuccessful->when{
                        response.body()?.size != 0 ->tampilCovidIndo(response.body()!!)
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
            R.layout.fragment_indonesia,
            container,false)
    }

    override fun onViewCreated
                (view: View,
                 @Nullable savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        callApiIndoUser()
    }
    private fun tampilCovidIndo(getDataInd : List<IndonesiPandemiItem>) {
        listPandemiInd.layoutManager = LinearLayoutManager(context)
        listPandemiInd.adapter =
            PantauIndAdapter(context!!, getDataInd) {

                val kawalIndo = it
                tampilToast(context!!, kawalIndo.name)
            }
    }
}