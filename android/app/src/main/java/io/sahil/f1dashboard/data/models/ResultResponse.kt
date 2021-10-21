package io.sahil.f1dashboard.data.models

import com.google.gson.annotations.SerializedName

data class ResultResponse (
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("message")
    val message: String
        ){
    override fun toString(): String {
        return results.toString()
    }
}