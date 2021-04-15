package com.example.bootJpa.dao;

import com.example.bootJpa.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienRepo  extends JpaRepository<Alien, Integer> {
}
