package com.vehicle.repositories;

import com.vehicle.model.VehicleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleDto, Long> {
}
