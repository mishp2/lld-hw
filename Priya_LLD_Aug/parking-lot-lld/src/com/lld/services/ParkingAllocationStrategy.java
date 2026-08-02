package com.lld.services;

import com.lld.models.ParkingFloor;
import com.lld.models.ParkingSpot;
import com.lld.models.Vehicle;

import java.util.List;

public interface ParkingAllocationStrategy {

    ParkingSpot findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
