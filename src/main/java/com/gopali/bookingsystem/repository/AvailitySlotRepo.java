package com.gopali.bookingsystem.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopali.bookingsystem.model.AvailitySlot;

public interface AvailitySlotRepo extends JpaRepository<AvailitySlot, Long> {
    List<AvailitySlot> findByCoworkerIdAndDate(Long coworkerId, LocalDate date);
    List<AvailitySlot> findByCoworkerId(Long coworkerId);
}
