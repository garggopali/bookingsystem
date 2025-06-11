package com.gopali.bookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gopali.bookingsystem.model.Coworker;

@Repository
public interface CoworkerRepo extends JpaRepository<Coworker, Long> {

}
