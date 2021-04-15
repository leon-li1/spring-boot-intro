package com.example.bootJpa.controller;

import com.example.bootJpa.dao.AlienRepo;
import com.example.bootJpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class AlienController {
    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home() {
        return "home.jsp";
    }

    @RequestMapping("/addAlien")
    public String addAlien(Alien alien) {
        repo.save(alien);
        return "home.jsp";
    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid) {
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        Alien alien = repo.findById(aid).orElse(new Alien());
        mv.addObject(alien);
        return mv;
    }

    @RequestMapping("/updateAlien")
    public ModelAndView updateAlien(Alien alien) {
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        repo.deleteById(alien.getAid());
        repo.save(alien);
        mv.addObject(alien);
        return mv;
    }

    @RequestMapping("/deleteAlien")
    public ModelAndView deleteAlien(@RequestParam int aid) {
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        Alien alien = repo.findById(aid).orElse(new Alien());
        repo.deleteById(aid);
        mv.addObject(alien);
        return mv;
    }

    @RequestMapping("/aliens")
    @ResponseBody
    public List<Alien> getAliens() {
        return repo.findAll();
    }

    @RequestMapping("/alien/{aid}")
    @ResponseBody
    public Optional<Alien> getAlienByAid(@PathVariable("aid") int aid) {
        return repo.findById(aid);
    }
}