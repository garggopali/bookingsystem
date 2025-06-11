package com.gopali.bookingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopali.bookingsystem.model.AvailitySlot;
import com.gopali.bookingsystem.model.Coworker;
import com.gopali.bookingsystem.service.CoworkerService;

@RestController
@RequestMapping("/coworkers")
public class CoworkerController {
    @Autowired
    CoworkerService coworkerService;

    @PostMapping("")
    public ResponseEntity<Boolean> saveCoworker(@RequestBody Coworker coworker) {
        boolean result = coworkerService.addCoworker(coworker);
        return ResponseEntity.ok(result);
    }

    @GetMapping("")
    public List<Coworker> getCoworkers() {
        return coworkerService.getCoworkers();
    }

    @PostMapping("/{id}/availability")
    public ResponseEntity<Boolean> saveCoworkerAvailabilty(
            @PathVariable Long id,
            @RequestBody AvailitySlot availitySlot) {
        boolean result = coworkerService.addCoworkerAvailabilty(id, availitySlot);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}/availability")
    public List<AvailitySlot> getCoworkersAvailabilty(@PathVariable Long id) {
        return coworkerService.getAvailabilityByCoworkerId(id);
    }

}
