package io.sahil.f1dashboard.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Race {
    
    @Id
    private String raceId;
    private String year;
    private int round;
    private String circuitId;
    private String name;
    private LocalDate date;

    
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
    public int getRound() {
        return round;
    }
    public void setRound(int round) {
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
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    

    

}
