package com.smartbooking.backend.repository;

import com.smartbooking.backend.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}