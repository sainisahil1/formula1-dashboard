package io.sahil.f1dashboard.data.models

import com.google.gson.annotations.SerializedName

data class Result (

    @SerializedName("resultId")
    private val resultId: String? = "",

    @SerializedName("raceId")
    private val raceId: String? = "",

    @SerializedName("driverId")
    private val driverId: String? = "",

    @SerializedName("driverName")
    private val driverName: String? = "",

    @SerializedName("constructorId")
    private val constructorId: String? = "",

    @SerializedName("constructorName")
    private val constructorName: String? = "",

    @SerializedName("grid")
    private val grid: Int? = 0,

    @SerializedName("positionText")
    private val positionText: String? = "",

    @SerializedName("positionOrder")
    private val positionOrder: Int? = 0,

    @SerializedName("points")
    private val points: String? = "",

    @SerializedName("laps")
    private val laps: Int?= 0,

    @SerializedName("fastestLap")
    private val fastestLap: String? = "",

    @SerializedName("fastestLapTime")
    private val fastestLapTime: String? = "",

    @SerializedName("fastestLapSpeed")
    private val fastestLapSpeed: String? = "",

    @SerializedName("absoluteTime")
    private val status: String? = "",

    @SerializedName("statusId")
    private val absoluteTime: String? = ""
)