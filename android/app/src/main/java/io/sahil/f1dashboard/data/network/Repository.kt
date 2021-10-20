package io.sahil.f1dashboard.data.network

import io.sahil.f1dashboard.data.models.Circuit
import io.sahil.f1dashboard.data.models.Race
import io.sahil.f1dashboard.data.models.Result
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Repository {

    @GET("standings/seasons")
    suspend fun getSeasons(): Call<List<String>>

    @GET("standings/races/{year}")
    suspend fun getRaces(@Path("year") year: String): Call<List<Race>>

    @GET("standings/circuits/{circuitId}")
    suspend fun getCircuit(@Path("circuitId") circuitId: String): Call<Circuit>

    @GET("standings/results/{raceId}")
    suspend fun getResult(@Path("raceId") raceId: String): Call<List<Result>>


}