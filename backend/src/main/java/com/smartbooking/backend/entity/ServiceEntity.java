package com.smartbooking.backend.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "service")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "service")
    private List<Timeslot> timeslots;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Timeslot> getTimeslots() { return timeslots; }
    public void setTimeslots(List<Timeslot> timeslots) { this.timeslots = timeslots; }
}