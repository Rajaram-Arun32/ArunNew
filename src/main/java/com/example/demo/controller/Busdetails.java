package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Busses;
import com.example.demo.entity.TicketBooking;
import com.example.demo.entity.User;
import com.example.demo.repository.BusRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.BusService;

@RestController
@RequestMapping("/api")
public class Busdetails {
	@Autowired
	private BusService bservice;
	@Autowired
	private BusRepo busrepo;
	@Autowired
	private UserRepo userrepo;

	@PostMapping("saveBus")
	public String save(@RequestBody Busses bus) {
		bservice.save(bus);
		return "Saved Successfully";
	}

	@PostMapping("/path")
	public String saveUser(@RequestBody User user) {
		bservice.saveUser(user);
		return "User details saved Successfully";
	}

	@PostMapping("/Ticketbooking")
	public ResponseEntity<HttpStatus> bookTicket(@RequestBody TicketBooking ticketbooking) {
		Busses bus = busrepo.findById(ticketbooking.getBus().getBusid()).orElse(null);
		User user = userrepo.findById(ticketbooking.getUser().getUserId()).orElse(null);
		bservice.bookTicket(user, bus, ticketbooking.getSeatNumbers(), ticketbooking.getTotalfare());
		return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}
}
