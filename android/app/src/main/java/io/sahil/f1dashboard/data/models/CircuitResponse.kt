package io.sahil.f1dashboard.data.models

import com.google.gson.annotations.SerializedName

data class CircuitResponse (
    @SerializedName("circuit")
    val circuit: Circuit,
    @SerializedName("message")
    val message: String
        ){
    override fun toString(): String {
        return circuit.toString()
    }
}