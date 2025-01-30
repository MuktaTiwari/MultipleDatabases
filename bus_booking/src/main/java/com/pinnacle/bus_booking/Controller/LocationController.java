package com.pinnacle.bus_booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinnacle.bus_booking.Service.LocationService;
import com.pinnacle.bus_booking.model.Locations;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseEntity<List<Locations>> getAllLocation() {
        List<Locations> locations = locationService.getAllLocation();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Locations> saveLocations(@RequestBody Locations locations) {
        Locations savedLocation = locationService.saveLocation(locations);
        return new ResponseEntity<>(savedLocation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Locations> updateLocations(@PathVariable int id, @RequestBody Locations locations) {
        locations.setId(id);
        Locations updatedLocation = locationService.updateLocations(locations);
        return new ResponseEntity<>(updatedLocation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocations(@PathVariable int id) {
        locationService.deleteLocations(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
