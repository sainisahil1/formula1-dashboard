package io.sahil.f1dashboard.data.models

data class Result (
    private val resultId: String? = null,

    private val raceId: String? = null,

    private val driverId: String? = null,

    private val driverName: String? = null,

    private val constructorId: String? = null,

    private val constructorName: String? = null,

    private val grid: Int? = 0,

    private val positionText: String? = null,

    private val positionOrder: Int? = 0,

    private val points: String? = null,

    private val laps: Int?= 0,

    private val fastestLap: String? = null,

    private val fastestLapTime: String? = null,

    private val fastestLapSpeed: String? = null,

    private val status: String? = null,

    private val absoluteTime: String? = null
)