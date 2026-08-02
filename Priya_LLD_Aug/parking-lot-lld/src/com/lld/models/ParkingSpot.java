package com.lld.models;

import com.lld.enums.VehicleType;

public class ParkingSpot {

    private int spotNumber;
    private VehicleType supportedVehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber, VehicleType supportedVehicleType) {
        this.spotNumber = spotNumber;
        this.supportedVehicleType = supportedVehicleType;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    public boolean canPark(Vehicle vehicle) {
        return isAvailable()
                && supportedVehicleType == vehicle.getType();
    }

    public void park(Vehicle vehicle) {
        if (!canPark(vehicle)) {
            throw new RuntimeException(
                    "Vehicle cannot be parked in spot " + spotNumber
            );
        }

        this.parkedVehicle = vehicle;
    }

    public void vacate() {
        this.parkedVehicle = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getSupportedVehicleType() {
        return supportedVehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}