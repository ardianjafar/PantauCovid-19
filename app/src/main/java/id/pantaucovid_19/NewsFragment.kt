package id.pantaucovid_19

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.pantaucovid_19.data.CovidService
import id.pantaucovid_19.data.apiRequest
import id.pantaucovid_19.data.httpClient
import id.pantaucovid_19.util.dismissLoading
import id.pantaucovid_19.util.showLoading
import id.pantaucovid_19.util.tampilToast
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_news.swipeRefreshLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun callApiGetGithubUser() {
        showLoading(context!!, swipeRefreshLayout)

        val httpClient = httpClient()
        val apiRequest = apiRequest<CovidService>(httpClient)

        val call = apiRequest.getUsers()
        call.enqueue(object : Callback<List<KawalCoronaItem>> {
            override fun onFailure(call: Call<List<KawalCoronaItem>>, t: Throwable) {
                dismissLoading(swipeRefreshLayout)
            }

            override fun onResponse(
                call: Call<List<KawalCoronaItem>>,
                response: Response<List<KawalCoronaItem>>
            ) {
                dismissLoading(swipeRefreshLayout)

                when{
                    response.isSuccessful ->
                        when{
                            response.body()?. size!=0 ->

                                tampilCovid(response.body()!!)

                            else -> {
                                tampilToast(context!!, "Berhasil")
                            }
                        }
                    else -> {
                        tampilToast(context!!, "Gagal")
                    }
                }
            }
        })
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news,
            container,false)
    }
    override fun onViewCreated(
        view: View,
        @Nullable savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        callApiGetGithubUser()
    }
    private fun tampilCovid(getUsers: List<KawalCoronaItem>) {
        listGithub.layoutManager = LinearLayoutManager(context)
        listGithub.adapter = PantauCovidAdapter(context!!, getUsers) {

            val kawal = it
            tampilToast(context!!, kawal.provinsi)
        }
    }
}