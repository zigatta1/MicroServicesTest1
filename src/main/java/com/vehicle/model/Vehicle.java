package com.vehicle.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {

    @NotNull(message = "vin is required")
    private String vin;

    @NotNull(message = "year is required")
    private Integer year;

    @NotNull(message = "make is required")
    private String make;

    @NotNull(message = "model is required")
    private String model;

    @NotNull(message = "transmissionType is required")
    private String transmissionType;

    public Vehicle() {

    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    @Override
    public String toString() {
        return "Vehicle [vin=" + vin + ", year=" + year + ", make=" + make + ", model=" + model + ", transmissionType="
                + transmissionType + "]";
    }
}

