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

import com.pinnacle.bus_booking.Service.RouteService;
import com.pinnacle.bus_booking.model.Locations;
import com.pinnacle.bus_booking.model.Route;

@RestController
@RequestMapping("/routes")
public class RouteController {
    

    @Autowired
    private RouteService routeService;

    @GetMapping
    public List<Route> getAllRoutes(){
        return routeService.getAllRoutes();
    }

    @PostMapping
    public Route SaveRoutes(@RequestBody Route route){
        return routeService.SaveRoutes(route);
    }


    @PutMapping("/{id}")
    public Route updateLocations(@PathVariable int id, @RequestBody Route route) {
        route.setId(id); 
        return routeService.updateLocations(route);
    }

    @DeleteMapping("/{id}")
    public void deleteLocations(@PathVariable int id) {
        routeService.deleteLocations(id);  
    }


    
}
