package io.sahil.f1dashboard.data.models

import com.google.gson.annotations.SerializedName

data class RaceResponse (
    @SerializedName("races")
    val races: List<Race>,
    @SerializedName("message")
    val message: String
        ){
    override fun toString(): String {
        return races.toString()
    }
}