package com.gopali.bookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopali.bookingsystem.model.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {

}