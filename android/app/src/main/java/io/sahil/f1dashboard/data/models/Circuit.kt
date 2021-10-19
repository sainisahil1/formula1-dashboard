package io.sahil.f1dashboard.data.models

import com.google.gson.annotations.SerializedName

data class Circuit(
    @SerializedName("circuitId")
    val circuitId: String? = "",
    @SerializedName("circuitRef")
    val circuitRef: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("location")
    val location: String? = "",
    @SerializedName("country")
    val country: String? = "",
    @SerializedName("lat")
    val lat: String? = "",
    @SerializedName("lng")
    val lng: String? = ""
)