package io.sahil.f1dashboard.data.network

import io.sahil.f1dashboard.data.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Repository {

    @GET("standings/seasons")
     fun getSeasons(): Call<List<String>>

    @GET("standings/races/{year}")
     fun getRaces(@Path("year") year: String): Call<RaceResponse>

    @GET("standings/circuits/{circuitId}")
    suspend fun getCircuit(@Path("circuitId") circuitId: String): Call<CircuitResponse>

    @GET("standings/results/{raceId}")
    suspend fun getResult(@Path("raceId") raceId: String): Call<ResultResponse>


}