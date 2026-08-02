package com.lld.models;

import com.lld.enums.VehicleType;

public class Vehicle {
    private final String registrationNumber;
    private final VehicleType type;


    public Vehicle(String registrationNumber, VehicleType type) {
        this.registrationNumber = registrationNumber;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

}
