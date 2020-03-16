package com.vehicle.service.impl;

import java.util.UUID;

import com.vehicle.Exceptions.InvalidPayloadException;
import com.vehicle.Exceptions.ResourceException;
import com.vehicle.model.VehicleDto;
import com.vehicle.repositories.VehicleRepository;
import com.vehicle.util.VehicleConstants;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vehicle.model.Vehicle;
import com.vehicle.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {
    Logger logger = LoggerFactory.getLogger(VehicleServiceImpl.class);

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public UUID createVehicle(Vehicle vehicle) {
        VehicleDto dto = createVehicleDto(vehicle);
        if (vehicle == null || (vehicle.getVin() == null || vehicle.getMake() == null || vehicle.getModel() == null || vehicle.getYear() == 0 || vehicle.getTransmissionType() == null)) {
            throw new InvalidPayloadException(HttpStatus.INTERNAL_SERVER_ERROR, "Payload attributes cannot be null");
        } else if (StringUtils.isEmpty(vehicle.getTransmissionType()) || !EnumUtils.isValidEnum(VehicleConstants.class, vehicle.getTransmissionType())) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Transmission type should be MANUAL or AUTO");
        } else {
            return saveVehicle(dto);
        }
    }

    private VehicleDto createVehicleDto(Vehicle vehicle) {
        VehicleDto dto = new VehicleDto();
        dto.setVin(vehicle.getVin());
        dto.setMake(vehicle.getMake());
        dto.setModel(vehicle.getModel());
        dto.setYear(vehicle.getYear());
        dto.setTransmissionType(vehicle.getTransmissionType());
        return dto;
    }

    private UUID saveVehicle(VehicleDto dto) {
        logger.info("Save Vehicle ID: {}", dto.getVin());
        vehicleRepository.save(dto);
        logger.info("Vehicle Post Data: {}", dto.toString());
        return UUID.randomUUID();
    }

}
