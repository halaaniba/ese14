package com.example.ese14.sevice;

import com.example.ese14.entities.Flight;
import com.example.ese14.entities.FlightStatus;
import com.example.ese14.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public void createFlight(int n) {
        Random random = new Random();
        List<Flight> flights = IntStream.range(0, n)
                .mapToObj(i -> {
                    Flight flight = new Flight();
                    flight.setDescription("Flight " + i);
                    flight.setFromAirport("Airport " + random.nextInt(49));
                    flight.setToAirport("Airport " + random.nextInt(49));
                    flight.setStatus(FlightStatus.values()[random.nextInt(FlightStatus.values().length)]);
                    return flight;
                })
                .collect(Collectors.toList());
        flightRepository.saveAll(flights);
    }

    public Page<Flight> getAllFlights(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return flightRepository.findAll(pageable);
    }

    public List<Flight> getOnTimeFlight() {
        return flightRepository.findAllByStatus(FlightStatus.ON_TIME);
    }

    public List<Flight> getCustomQueryFlight(FlightStatus p1, FlightStatus p2) {
        return flightRepository.findByStatus(List.of(p1, p2));
    }
}
