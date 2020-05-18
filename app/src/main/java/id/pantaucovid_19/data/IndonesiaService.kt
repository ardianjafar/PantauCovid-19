package id.pantaucovid_19.data

import id.pantaucovid_19.IndonesiPandemiItem
import retrofit2.Call
import retrofit2.http.GET

interface IndonesiaService {
    @GET("indonesia")
    fun getDataInd(): Call<List<IndonesiPandemiItem>>
}