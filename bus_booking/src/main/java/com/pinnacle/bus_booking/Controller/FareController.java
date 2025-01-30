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

import com.pinnacle.bus_booking.Service.FareService;
import com.pinnacle.bus_booking.model.Fare;

@RestController
@RequestMapping("/fares")
public class FareController {

    @Autowired
    private FareService fareService;

    @GetMapping
    public ResponseEntity<List<Fare>> getAllFares() {
        List<Fare> fares = fareService.getAllFares();
        return new ResponseEntity<>(fares, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Fare> saveFares(@RequestBody Fare fare) {
        Fare savedFare = fareService.saveFares(fare);
        return new ResponseEntity<>(savedFare, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fare> updateFares(@RequestBody Fare fare, @PathVariable String id) {
        Fare updatedFare = fareService.updateFares(fare, id);
        return new ResponseEntity<>(updatedFare, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFare(@PathVariable String id) {
        fareService.deleteFare(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
