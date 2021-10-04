package io.sahil.f1dashboard.dto;

public class ResultDto {
	
	private String resultId;
    private String raceId;
    private String driverId;
    private String driverName;
    private String constructorId;
    private String constructorName;
    private int grid;
    private String positionText;
    private int positionOrder;
    private String points;
    private int laps;
    private String fastestLap;
    private String fastestLapTime;
    private String fastestLapSpeed;
    private String status;
    private String absoluteTime;
    
    
	public ResultDto(String resultId, String raceId, String driverId, String driverName, String constructorId,
			String constructorName, int grid, String positionText, int positionOrder, String points, int laps,
			String fastestLap, String fastestLapTime, String fastestLapSpeed, String statusId, String absoluteTime) {
		super();
		this.resultId = resultId;
		this.raceId = raceId;
		this.driverId = driverId;
		this.driverName = driverName;
		this.constructorId = constructorId;
		this.constructorName = constructorName;
		this.grid = grid;
		this.positionText = positionText;
		this.positionOrder = positionOrder;
		this.points = points;
		this.laps = laps;
		this.fastestLap = fastestLap;
		this.fastestLapTime = fastestLapTime;
		this.fastestLapSpeed = fastestLapSpeed;
		this.status = statusId;
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


	public String getDriverName() {
		return driverName;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	public String getConstructorId() {
		return constructorId;
	}


	public void setConstructorId(String constructorId) {
		this.constructorId = constructorId;
	}


	public String getConstructorName() {
		return constructorName;
	}


	public void setConstructorName(String constructorName) {
		this.constructorName = constructorName;
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
		return status;
	}


	public void setStatusId(String statusId) {
		this.status = statusId;
	}


	public String getAbsoluteTime() {
		return absoluteTime;
	}


	public void setAbsoluteTime(String absoluteTime) {
		this.absoluteTime = absoluteTime;
	}
	
	
    
    
    
    
    
    
    

}
