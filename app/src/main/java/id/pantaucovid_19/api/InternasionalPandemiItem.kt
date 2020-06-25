package id.pantaucovid_19.api


import com.google.gson.annotations.SerializedName
import id.pantaucovid_19.api.AttributesX

data class InternasionalPandemiItem(
    @SerializedName("attributes")
    val attributes: AttributesX
)