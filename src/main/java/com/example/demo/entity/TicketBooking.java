package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class TicketBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ticketId;
	@ManyToOne
	@JoinColumn(name="User-id")
	private User user;
	@ManyToOne
	@JoinColumn(name="bus-id")
	private Busses bus;
	private List<Integer> seatNumbers;
	private double totalfare;
	private LocalDateTime bookingTime;
	private String status;
}
