package com.lld.display;

import com.lld.enums.VehicleType;
import com.lld.models.ParkingFloor;
import com.lld.models.ParkingSpot;

import java.util.List;

public class DisplayBoard {

    public void display(List<ParkingFloor> floors){
        System.out.println("----- Parking Availability -----");

        for (ParkingFloor floor : floors) {
            System.out.println("Floor: " + floor.getFloor());
            for (VehicleType vehicleType : VehicleType.values()) {
                long availableSpots = floor
                        .getParkingSpots()
                        .stream()
                        .filter(ParkingSpot::isAvailable)
                        .filter(spot -> spot.getSupportedVehicleType() == vehicleType)
                        .count();

                System.out.println(vehicleType + " spots available: " + availableSpots);
            }
        }
        System.out.println("--------------------------------");
    }
}
