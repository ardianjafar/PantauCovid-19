package id.pantaucovid_19.data

import id.pantaucovid_19.InternasionalPandemiItem
import retrofit2.Call
import retrofit2.http.GET

interface InternasionalService {
    @GET(".")
    fun getDataItr(): Call<List<InternasionalPandemiItem>>
}