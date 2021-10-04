package io.sahil.f1dashboard.data;

public class RaceInput {
    
    private String raceId, year, round, circuitId, name, date, time, url;

    // public RaceInput(String raceId, String year, String round, String circuitId, String name, String date, String time,
    //         String url) {
    //     this.raceId = raceId;
    //     this.year = year;
    //     this.round = round;
    //     this.circuitId = circuitId;
    //     this.name = name;
    //     this.date = date;
    //     this.time = time;
    //     this.url = url;
    // }

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getCircuitId() {
        return circuitId;
    }

    public void setCircuitId(String circuitId) {
        this.circuitId = circuitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    

}
