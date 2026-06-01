package com.smartbooking.backend.controller;

import com.smartbooking.backend.entity.Timeslot;
import com.smartbooking.backend.repository.TimeslotRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeslots")
@CrossOrigin
public class TimeslotController {

    private final TimeslotRepository repo;

    public TimeslotController(TimeslotRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Timeslot> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Timeslot create(@RequestBody Timeslot timeslot) {
        return repo.save(timeslot);
    }
}