package id.pantaucovid_19.data

import id.pantaucovid_19.KawalCoronaItem
import retrofit2.Call
import retrofit2.http.GET

interface CovidService {
    @GET("indonesia/provinsi")
    fun getUsers(): retrofit2.Call<List<KawalCoronaItem>>
}