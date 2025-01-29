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

import com.pinnacle.bus_booking.Service.FareService;
import com.pinnacle.bus_booking.model.Fare;

@RestController
@RequestMapping("/fares")
public class FareController {

    @Autowired
    private FareService fareService;

    @GetMapping
    public List<Fare> getAllFares() {
        return fareService.getAllFares();
    }

    @PostMapping
    public Fare saveFares(@RequestBody Fare fare) {
        return fareService.saveFares(fare);
    }

    @PutMapping("/{id}")
    public Fare updateFares(@RequestBody Fare fare, @PathVariable String id) {
        return fareService.updateFares(fare, id);
    }

    @DeleteMapping("/{id}")
    public void deleteFare(@PathVariable String id) {
        fareService.deleteFare(id);
    }
}
