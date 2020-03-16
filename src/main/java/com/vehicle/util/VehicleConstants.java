package com.vehicle.util;

public enum VehicleConstants {

    MANUAL("MANUAL"),
    AUTO("AUTO");

    private String name;

    private VehicleConstants(String name) {
        this.name = name;
    }

    public String getVehicleTransmissionType() {
        return name;
    }
}
