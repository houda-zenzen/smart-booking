package com.smartbooking.backend.controller;

import com.smartbooking.backend.entity.ServiceEntity;
import com.smartbooking.backend.repository.ServiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
@CrossOrigin
public class ServiceController {

    private final ServiceRepository repo;

    public ServiceController(ServiceRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<ServiceEntity> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public ServiceEntity create(@RequestBody ServiceEntity service) {
        return repo.save(service);
    }
}