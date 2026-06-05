package com.smartbooking.backend.mapper;

import com.smartbooking.backend.dto.ReservationDTO;
import com.smartbooking.backend.entity.Reservation;
import com.smartbooking.backend.entity.ServiceEntity;
import com.smartbooking.backend.entity.Timeslot;

public class ReservationMapper {

    public static ReservationDTO toDTO(Reservation r) {
        if (r == null) return null;

        return new ReservationDTO(
                r.getId(),
                r.getCustomerName(),
                r.getReservationDate(),
                r.getService() != null ? r.getService().getId() : null,
                r.getTimeslot() != null ? r.getTimeslot().getId() : null
        );
    }

    public static Reservation toEntity(ReservationDTO dto,
                                       ServiceEntity service,
                                       Timeslot timeslot) {

        if (dto == null) return null;

        Reservation r = new Reservation();
        r.setId(dto.getId());
        r.setCustomerName(dto.getCustomerName());
        r.setReservationDate(dto.getReservationDate());
        r.setService(service);
        r.setTimeslot(timeslot);

        return r;
    }
}