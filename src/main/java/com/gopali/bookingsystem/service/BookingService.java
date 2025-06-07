package com.gopali.bookingsystem.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopali.bookingsystem.model.Booking;
import com.gopali.bookingsystem.repository.BookingRepo;

@Service
public class BookingService {

    @Autowired
    BookingRepo bookingRepo;

    public boolean addBooking(Booking booking) {
        if (booking == null)
            return false;
        else {
            bookingRepo.save(booking);
            return true;
        }
    }

    public List<Booking> getBookings() {
        return bookingRepo.findAll();
    }

    // 1. add db connfig
    // 2. java profiling
    // getting the booking
}