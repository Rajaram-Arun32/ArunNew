package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Busses {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int busid;
	private String busSource;;
	private String busDestination;
	private LocalDateTime busDipartureTime;
	private LocalDateTime busArrivalTime;
	private int totalNoOfSeats;
	private double availableseats;
	private int totalFare;	
}
