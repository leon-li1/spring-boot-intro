package com.example.bootJpa.controller;

import com.example.bootJpa.dao.AlienRepo;
import com.example.bootJpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {
    @Autowired
    AlienRepo repo;

    @GetMapping("/")
    public String home() {
        return "home.jsp";
    }

    @GetMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid) {
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        Alien alien = repo.findById(aid).orElse(new Alien());
        mv.addObject(alien);
        return mv;
    }

    @GetMapping(value = "/aliens", produces = {"application/json"})
    public List<Alien> getAliens() {
        return repo.findAll();
    }

    @GetMapping("/alien/{aid}")
    public Optional<Alien> getAlienByAid(@PathVariable("aid") int aid) {
        return repo.findById(aid);
    }

    @PostMapping("/alien")
    public Alien addAlien(@RequestBody Alien alien) {
        repo.save(alien);
        return alien;
    }

    @PutMapping("/alien")
    public Alien updateAlien(@RequestBody Alien alien) {
        repo.save(alien);
        return alien;
    }

    @DeleteMapping("/alien/{aid}")
    public Alien deleteAlien(@PathVariable("aid") int aid) {
        Alien alien = repo.findById(aid).orElse(new Alien());
        repo.delete(alien);
        return alien;
    }

}