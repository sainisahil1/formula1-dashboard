package io.sahil.f1dashboard.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Result {
    
    @Id
    private String resultId;
    private String raceId;
    private String driverId;
    private String constructorId;
    private int grid;
    private String positionText;
    private int positionOrder;
    private String points;
    private int laps;
    private String fastestLap;
    private String fastestLapTime;
    private String fastestLapSpeed;
    private String statusId;
    private String absoluteTime;


    public Result() {}
    
    
   
	public String getAbsoluteTime() {
        return absoluteTime;
    }
    public void setAbsoluteTime(String absoluteTime) {
        this.absoluteTime = absoluteTime;
    }
    public String getResultId() {
        return resultId;
    }
    public void setResultId(String resultId) {
        this.resultId = resultId;
    }
    public String getRaceId() {
        return raceId;
    }
    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }
    public String getDriverId() {
        return driverId;
    }
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }
    public String getConstructorId() {
        return constructorId;
    }
    public void setConstructorId(String constructorId) {
        this.constructorId = constructorId;
    }
    public int getGrid() {
        return grid;
    }
    public void setGrid(int grid) {
        this.grid = grid;
    }
    public String getPositionText() {
        return positionText;
    }
    public void setPositionText(String positionText) {
        this.positionText = positionText;
    }
    public int getPositionOrder() {
        return positionOrder;
    }
    public void setPositionOrder(int positionOrder) {
        this.positionOrder = positionOrder;
    }
    public String getPoints() {
        return points;
    }
    public void setPoints(String points) {
        this.points = points;
    }
    public int getLaps() {
        return laps;
    }
    public void setLaps(int laps) {
        this.laps = laps;
    }
    
    public String getFastestLap() {
        return fastestLap;
    }
    public void setFastestLap(String fastestLap) {
        this.fastestLap = fastestLap;
    }
    public String getFastestLapTime() {
        return fastestLapTime;
    }
    public void setFastestLapTime(String fastestLapTime) {
        this.fastestLapTime = fastestLapTime;
    }
    public String getFastestLapSpeed() {
        return fastestLapSpeed;
    }
    public void setFastestLapSpeed(String fastestLapSpeed) {
        this.fastestLapSpeed = fastestLapSpeed;
    }
    public String getStatusId() {
        return statusId;
    }
    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }


    

}
