package com.example.ese14.repository;

import com.example.ese14.entities.Flight;
import com.example.ese14.entities.FlightStatus;
import lombok.CustomLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByStatus(List<FlightStatus> statuses);
    List<Flight> findAllByStatus(FlightStatus status);
}
