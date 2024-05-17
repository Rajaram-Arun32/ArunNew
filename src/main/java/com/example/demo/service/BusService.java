package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Busses;
import com.example.demo.entity.TicketBooking;
import com.example.demo.entity.User;
import com.example.demo.repository.BusRepo;
import com.example.demo.repository.TicketRepo;
import com.example.demo.repository.UserRepo;

@org.springframework.stereotype.Service
public class BusService {
	@Autowired
	private BusRepo ticket;
	@Autowired
	private TicketRepo ticketrepo;
	@Autowired
	private UserRepo userrepo;

	public Busses save(Busses bus) {
		return ticket.save(bus);
	}
	public User saveUser(User user) {
		return userrepo.save(user);
	}
	public TicketBooking bookTicket(User user,Busses bus,List<Integer> seatNumber,double totalFare) {
		bus.setAvailableseats(bus.getAvailableseats()-totalFare);
		TicketBooking ticketbooking=new TicketBooking();
		ticketbooking.setBus(bus);
		ticketbooking.setUser(user);
		ticketbooking.setSeatNumbers(seatNumber);
		ticketbooking.setTotalfare(totalFare);
		ticketbooking.setBookingTime(LocalDateTime.now());
		ticketbooking.setStatus("Cofirmed");
		return ticketbooking;
	}
}
