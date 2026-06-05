package com.smartbooking.backend.mapper;

import com.smartbooking.backend.dto.ServiceDTO;
import com.smartbooking.backend.entity.ServiceEntity;

public class ServiceMapper {

    public static ServiceDTO toDTO(ServiceEntity s) {
        if (s == null) return null;

        return new ServiceDTO(
                s.getId(),
                s.getName(),
                s.getDescription()
        );
    }

    public static ServiceEntity toEntity(ServiceDTO dto) {
        if (dto == null) return null;

        ServiceEntity s = new ServiceEntity();
        s.setId(dto.getId());
        s.setName(dto.getName());
        s.setDescription(dto.getDescription());

        return s;
    }
}