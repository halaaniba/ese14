package com.example.ese14.controller;

import com.example.ese14.entities.Flight;
import com.example.ese14.entities.FlightStatus;
import com.example.ese14.sevice.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping("/createFlight")
    public void createFlight(@RequestParam(required = false, defaultValue = "100") int n) {
        flightService.createFlight(n);
    }

    @GetMapping("/allFlights")
    public Page<Flight> getAllFlights(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {
        return flightService.getAllFlights(page, size);
    }

    @GetMapping("/onTimeFlights")
    public List<Flight> getOnTimeFlights() {
        return flightService.getOnTimeFlight();
    }

    @GetMapping("/customQueryFlights")
    public List<Flight> getCustomQueryFlights(@RequestParam("p1") FlightStatus p1, @RequestParam("p2") FlightStatus p2) {
        return flightService.getCustomQueryFlight(p1, p2);
    }
}


