package com.smartbooking.backend.service;

import com.smartbooking.backend.dto.ReservationDTO;
import com.smartbooking.backend.entity.Reservation;
import com.smartbooking.backend.entity.ServiceEntity;
import com.smartbooking.backend.entity.Timeslot;
import com.smartbooking.backend.repository.ReservationRepository;
import com.smartbooking.backend.repository.ServiceRepository;
import com.smartbooking.backend.repository.TimeslotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl {

    private final ReservationRepository reservationRepository;
    private final ServiceRepository serviceRepository;
    private final TimeslotRepository timeslotRepository;

    public ReservationServiceImpl(
            ReservationRepository reservationRepository,
            ServiceRepository serviceRepository,
            TimeslotRepository timeslotRepository) {

        this.reservationRepository = reservationRepository;
        this.serviceRepository = serviceRepository;
        this.timeslotRepository = timeslotRepository;
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation create(ReservationDTO dto) {

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

        return reservationRepository.save(r);
    }
}