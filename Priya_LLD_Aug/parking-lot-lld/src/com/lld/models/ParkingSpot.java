package com.lld.models;

import com.lld.enums.VehicleType;

public class ParkingSpot {
    private int spotNumber;
    private Vehicle parkedVehicle;
    private VehicleType vehicleType;


    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    public boolean canPark(Vehicle vehicle) {
        return isAvailable()
                && parkedVehicle.getType() == vehicleType;
    }

    public void park(Vehicle vehicle) {
        parkedVehicle = vehicle;
    }

    public void vacate() {
        parkedVehicle = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }


}
