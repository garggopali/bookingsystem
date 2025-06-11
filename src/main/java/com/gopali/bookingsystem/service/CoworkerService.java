package com.gopali.bookingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopali.bookingsystem.model.AvailitySlot;
import com.gopali.bookingsystem.model.Coworker;
import com.gopali.bookingsystem.repository.AvailitySlotRepo;
import com.gopali.bookingsystem.repository.CoworkerRepo;

@Service
public class CoworkerService {
    @Autowired
    CoworkerRepo coworkerRepo;

    @Autowired
    AvailitySlotRepo availitySlotRepo;

    public boolean addCoworker(Coworker coworker) {
        if (coworker == null)
            return false;
        else {
            coworkerRepo.save(coworker);
            return true;
        }
    }

    public List<Coworker> getCoworkers() {
        return coworkerRepo.findAll();
    }

    // public boolean addCoworkerAvailabilty(Long coworkerId, AvailitySlot
    // availitySlot) {
    // if (availitySlot == null)
    // return false;
    // availitySlotRepo.save(availitySlot);
    // return true;
    // }
    // }

    public boolean addCoworkerAvailabilty(Long coworkerId, AvailitySlot availitySlot) {
        Coworker coworker = coworkerRepo.findById(coworkerId)
                .orElseThrow(() -> new IllegalArgumentException("Coworker not found"));

         availitySlot.setCoworker(coworker);
        availitySlotRepo.save(availitySlot);
        return true;
    }

    public List<AvailitySlot> getAvailabilityByCoworkerId(Long coworkerId) {
        return availitySlotRepo.findByCoworkerId(coworkerId);
    }

}
