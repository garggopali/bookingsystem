package com.gopali.bookingsystem.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopali.bookingsystem.model.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {
    
    Optional<Booking> findByIdempotencyKey(String idempotencyKey);

    List<Booking> findByCoworkerIdAndDate(Long coworkerId, LocalDate date);

    List<Booking> findByDate(LocalDate date);

    List<Booking> findByCoworkerId(Long coworkerId);

}