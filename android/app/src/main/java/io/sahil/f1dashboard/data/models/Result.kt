package io.sahil.f1dashboard.data.models

import com.google.gson.annotations.SerializedName

data class Result (

    @SerializedName("resultId")
    val resultId: String? = "",

    @SerializedName("raceId")
    val raceId: String? = "",

    @SerializedName("driverId")
    val driverId: String? = "",

    @SerializedName("driverName")
    val driverName: String? = "",

    @SerializedName("constructorId")
    val constructorId: String? = "",

    @SerializedName("constructorName")
    val constructorName: String? = "",

    @SerializedName("grid")
    val grid: Int? = 0,

    @SerializedName("positionText")
    val positionText: String? = "",

    @SerializedName("positionOrder")
    val positionOrder: Int? = 0,

    @SerializedName("points")
    val points: String? = "",

    @SerializedName("laps")
    val laps: Int?= 0,

    @SerializedName("fastestLap")
    val fastestLap: String? = "",

    @SerializedName("fastestLapTime")
    val fastestLapTime: String? = "",

    @SerializedName("fastestLapSpeed")
    val fastestLapSpeed: String? = "",

    @SerializedName("statusId")
    val status: String? = "",

    @SerializedName("absoluteTime")
    val absoluteTime: String? = ""
){
    override fun toString(): String {
        return "resultId: $resultId, raceId: $raceId, driverId: $driverId, driverName: $driverName, constructorId: $constructorId" +
                ",\n constructorName: $constructorName, grid: $grid, positionText: $positionText, positionOrder: $positionOrder, " +
                "\npoints: $points, laps: $laps, fastestLap: $fastestLap, fastestLapTime: $fastestLapTime, " +
                "\nfastestLapSpeed: $fastestLapSpeed, status: $status, absoluteTime: $absoluteTime \n\n"
    }
}