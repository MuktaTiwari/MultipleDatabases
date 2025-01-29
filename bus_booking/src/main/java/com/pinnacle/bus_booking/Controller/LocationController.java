package com.pinnacle.bus_booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Locations> getAllLocation(){
        return locationService.getAllLocation();

    }

    @PostMapping
    public Locations saveLocations(@RequestBody Locations locations){
        return locationService.saveLocation(locations);
    }

    @PutMapping("/{id}")
    public Locations updateLocations(@PathVariable int id, @RequestBody Locations locations) {
        locations.setId(id); 
        return locationService.updateLocations(locations);
    }

    @DeleteMapping("/{id}")
    public void deleteLocations(@PathVariable int id) {
        locationService.deleteLocations(id);  
    }
}
