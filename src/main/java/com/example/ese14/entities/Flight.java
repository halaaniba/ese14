package com.example.ese14.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "description")
    private String description;
    @Column(nullable = false, name = "from_airport")
    private String fromAirpoirt;
    @Column(nullable = false, name = "to_airport")
    private String toAirport;


    @Enumerated(EnumType.STRING)
    private FlightStatus status = FlightStatus.ON_TIME;
}

