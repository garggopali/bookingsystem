package com.gopali.bookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopali.bookingsystem.model.AvailitySlot;

public interface AvailitySlotRepo extends JpaRepository<AvailitySlot,Long> {
    
}
