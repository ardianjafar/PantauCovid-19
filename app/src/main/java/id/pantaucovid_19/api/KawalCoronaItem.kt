package id.pantaucovid_19.api


import com.google.gson.annotations.SerializedName
import id.pantaucovid_19.api.Attributes

data class KawalCoronaItem(
    @SerializedName("attributes")
    val attributes: Attributes
)