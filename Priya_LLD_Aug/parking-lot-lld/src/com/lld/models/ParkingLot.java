package com.lld.models;

import java.util.List;

public class ParkingLot {

    private final String parkingLotId;
    private final List<ParkingFloor> floors;

    public ParkingLot(String parkingLotId, List<ParkingFloor> floors) {
        this.floors = floors;
        this.parkingLotId = parkingLotId;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }
}
