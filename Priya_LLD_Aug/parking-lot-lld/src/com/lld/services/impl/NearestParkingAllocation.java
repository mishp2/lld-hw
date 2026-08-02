package com.lld.services.impl;

import com.lld.models.ParkingFloor;
import com.lld.models.ParkingSpot;
import com.lld.models.Vehicle;
import com.lld.services.ParkingAllocationStrategy;

import java.util.List;

public class NearestParkingAllocation implements ParkingAllocationStrategy {

    @Override
    public ParkingSpot findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            for (ParkingSpot spot : floor.getParkingSpots()) {
                if (spot.canPark(vehicle)) {
                    return spot;
                }
            }
        }
        return null;
    }
}
