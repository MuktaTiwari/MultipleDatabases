package com.pinnacle.bus_booking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.pinnacle.bus_booking.model.Fare;

@Service
public class FareService {

    @Autowired
    private MongoTemplate mongoTemplate;

    // Get all fares from MongoDB
    public List<Fare> getAllFares() {
        return mongoTemplate.findAll(Fare.class);
    }

    // Save fare to MongoDB
    public Fare saveFares(Fare fare) {
        mongoTemplate.save(fare);  // This will insert or update the fare
        return fare; 
    }

    // Update fare in MongoDB by ID
    public Fare updateFares(Fare fare, String id) {
        Query query = new Query(Criteria.where("id").is(id));  // Find the fare by ID
        
        // Create update operation
        Update update = new Update()
            .set("route", fare.getRoute())
            .set("from_location", fare.getFromLocation())
            .set("to_location", fare.getToLocation())
            .set("price", fare.getPrice());
        
        // Execute the update and return the updated fare
        return mongoTemplate.findAndModify(query, update, Fare.class);
    }

    // Delete fare by ID
    public void deleteFare(String id) {
        Query query = new Query(Criteria.where("id").is(id));  // Find the fare by ID
        mongoTemplate.remove(query, Fare.class);  // Delete the fare
    }
}
