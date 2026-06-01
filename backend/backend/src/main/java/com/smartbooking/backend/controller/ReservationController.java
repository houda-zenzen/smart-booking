package com.smartbooking.backend.controller;

import com.smartbooking.backend.dto.ReservationDTO;
import com.smartbooking.backend.entity.*;
import com.smartbooking.backend.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@CrossOrigin
public class ReservationController {

    private final ReservationRepository repo;
    private final ServiceRepository serviceRepository;
    private final TimeslotRepository timeslotRepository;

    public ReservationController(
            ReservationRepository repo,
            ServiceRepository serviceRepository,
            TimeslotRepository timeslotRepository) {

        this.repo = repo;
        this.serviceRepository = serviceRepository;
        this.timeslotRepository = timeslotRepository;
    }

    @GetMapping
    public List<Reservation> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Reservation create(@RequestBody ReservationDTO dto) {

        Reservation r = new Reservation();

        r.setCustomerName(dto.getCustomerName());
        r.setReservationDate(dto.getReservationDate());

        if (dto.getServiceId() != null) {
            ServiceEntity service = serviceRepository.findById(dto.getServiceId())
                    .orElseThrow(() -> new RuntimeException("Service not found"));
            r.setService(service);
        }

        if (dto.getTimeslotId() != null) {
            Timeslot t = timeslotRepository.findById(dto.getTimeslotId())
                    .orElseThrow(() -> new RuntimeException("Timeslot not found"));
            r.setTimeslot(t);
        }

        return repo.save(r);
    }
}