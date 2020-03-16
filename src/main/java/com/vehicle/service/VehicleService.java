package com.vehicle.service;
import java.util.UUID;
import com.vehicle.model.Vehicle;

public interface VehicleService {
    UUID createVehicle(Vehicle vehicle);
}
