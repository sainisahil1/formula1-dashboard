package io.sahil.f1dashboard.data.models

data class Race(
    val raceId: String? = "",
    val year: String? = "",
    val round: String? = "",
    val circuitId: String? = "",
    val name: String? = "",
    val date: String? = "",
){
    override fun toString(): String {
        return "raceID: $raceId, year: $year, round: $round, circuitId: $circuitId, name: $name, date: $date \n"
    }
}