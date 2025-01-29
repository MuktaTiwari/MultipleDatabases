package com.pinnacle.bus_booking.model;

import org.springframework.data.annotation.Id; 
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;  

@Document(collection = "fares")
public class Fare {

    @Id
    private String id;  

    @Field("route")
    private String route;

    @Field("from_location")
    private String fromLocation;

    @Field("to_location")
    private String toLocation;

    @Field("price")
    private double price;

    // Getter and Setter for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter and Setter for route
    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    // Getter and Setter for fromLocation
    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    // Getter and Setter for toLocation
    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    // Getter and Setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}