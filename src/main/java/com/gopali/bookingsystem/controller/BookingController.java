package com.gopali.bookingsystem.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gopali.bookingsystem.model.Booking;
import com.gopali.bookingsystem.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping("")
    public ResponseEntity<Boolean> saveBooking(@RequestBody Booking booking) {
        boolean result = bookingService.addBooking(booking);
        return ResponseEntity.ok(result);
    }

    @GetMapping("")
    public List<Booking> getBookings(
            @RequestParam(required = false) LocalDate date,
            @RequestParam(required = false) Long coworkerId) {
        return bookingService.getBookings(date, coworkerId);
    }

}
