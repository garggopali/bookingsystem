package com.gopali.bookingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopali.bookingsystem.model.Coworker;
import com.gopali.bookingsystem.repository.CoworkerRepo;

@Service
public class CoworkerService {
    @Autowired
    CoworkerRepo coworkerRepo;

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

}
