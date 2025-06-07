package com.gopali.bookingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopali.bookingsystem.model.Booking;
import com.gopali.bookingsystem.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping("/post")
    public ResponseEntity<Boolean> saveBooking(@RequestBody Booking booking) {
        boolean result = bookingService.addBooking(booking);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get")
    public List<Booking> getBookings() {
        return bookingService.getBookings();
    }

}
