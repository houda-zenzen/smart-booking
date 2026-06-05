package com.smartbooking.backend.dto;

import java.time.LocalDate;

public class ReservationDTO {

    private Long id;
    private String customerName;
    private LocalDate reservationDate;
    private Long serviceId;
    private Long timeslotId;

    public ReservationDTO() {
    }

    public ReservationDTO(Long id,
                          String customerName,
                          LocalDate reservationDate,
                          Long serviceId,
                          Long timeslotId) {

        this.id = id;
        this.customerName = customerName;
        this.reservationDate = reservationDate;
        this.serviceId = serviceId;
        this.timeslotId = timeslotId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getTimeslotId() {
        return timeslotId;
    }

    public void setTimeslotId(Long timeslotId) {
        this.timeslotId = timeslotId;
    }
}