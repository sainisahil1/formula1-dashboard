package io.sahil.f1dashboard.data;

public class CircuitInput {

    private String circuitRef, name, location, country, url, circuitId, alt, lat, lng;
    // private int circuitId, alt;
    // private double lat, lng;

    // public CircuitInput(int circuitId, String circuitRef, String name, String location, String country, double lat,
    //         double lng, int alt, String url) {
    //     this.circuitId = circuitId;
    //     this.circuitRef = circuitRef;
    //     this.name = name;
    //     this.location = location;
    //     this.country = country;
    //     this.lat = lat;
    //     this.lng = lng;
    //     this.alt = alt;
    //     this.url = url;
    // }

    public String getCircuitId() {
        return circuitId;
    }

    public void setCircuitId(String circuitId) {
        this.circuitId = circuitId;
    }

    public String getCircuitRef() {
        return circuitRef;
    }

    public void setCircuitRef(String circuitRef) {
        this.circuitRef = circuitRef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    
    
}
