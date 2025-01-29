package com.pinnacle.bus_booking.model;


public class Route {

   
    private int id; 
    private String source; 
    private String destination; 
    private double distance; 
    private String duration; 

    // Default constructor
    public Route() {
    }

    // Parameterized constructor
    public Route(int id, String source, String destination, double distance, String duration) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.duration = duration;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", distance=" + distance +
                ", duration='" + duration + '\'' +
                '}';
    }
}
