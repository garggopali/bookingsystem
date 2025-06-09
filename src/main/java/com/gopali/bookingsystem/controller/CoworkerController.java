package com.gopali.bookingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopali.bookingsystem.model.Coworker;
import com.gopali.bookingsystem.service.CoworkerService;

@Service
@RestController
@RequestMapping("/coworkers")
public class CoworkerController {
    @Autowired
    CoworkerService coworkerService;

    @RequestMapping("")
     public ResponseEntity<Boolean> saveCoworker(@RequestBody Coworker coworker) {
        boolean result = coworkerService.addCoworker(coworker);
        return ResponseEntity.ok(result);
    }

    @GetMapping("")
    public List<Coworker> getCoworkers() {
        return coworkerService.getCoworkers();
    }

}
