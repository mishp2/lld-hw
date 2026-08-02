package com.lld.models;

import java.util.List;

public class ParkingFloor {

    private final int floor;
    private final List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floor, List<ParkingSpot> parkingSpots) {
        this.floor = floor;
        this.parkingSpots = parkingSpots;
    }

    public int getFloor() {
        return floor;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
}
