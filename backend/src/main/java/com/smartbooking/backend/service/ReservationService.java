package com.smartbooking.backend.service;

import com.smartbooking.backend.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {

    List<ReservationDTO> getAll();

    ReservationDTO getById(Long id);

    ReservationDTO create(ReservationDTO dto);

    ReservationDTO update(Long id, ReservationDTO dto);

    void delete(Long id);
}