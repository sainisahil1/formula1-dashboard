package io.sahil.f1dashboard.data.network

import io.sahil.f1dashboard.data.models.Circuit
import io.sahil.f1dashboard.data.models.Race
import io.sahil.f1dashboard.data.models.Result
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitInterface {

    @GET("standings/seasons")
    suspend fun getSeasons(): ResponseBody

    @GET("standings/races/{year}")
    suspend fun getRaces(@Path("year") year: String): List<Race>

    @GET("standings/circuits/{circuitId}")
    suspend fun getCircuit(@Path("circuitId") circuitId: String): Circuit

    @GET("standings/results/{raceId}")
    suspend fun getResult(@Path("raceId") raceId: String): List<Result>


}