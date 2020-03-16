package com.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.model.Vehicle;
import com.vehicle.service.VehicleService;

@RestController
@RequestMapping("/vehicle-api/v1/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/vehicle")
    public ResponseEntity<String> createVehicle(@RequestBody Vehicle vehicle) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Vehicle-Header", vehicleService.createVehicle(vehicle).toString());

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body("Response with header using ResponseEntity");
    }
}
