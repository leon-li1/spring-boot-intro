package com.example.bootJpa.dao;

import com.example.bootJpa.model.Alien;
import org.springframework.data.repository.CrudRepository;

public interface AlienRepo  extends CrudRepository<Alien, Integer> {
}
