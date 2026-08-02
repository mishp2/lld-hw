package com.lld.models;

import com.lld.services.FareCalculationStrategy;
import com.lld.services.ParkingAllocationStrategy;

import java.time.LocalDateTime;
import java.util.List;

public class ParkingLot {

    private List<ParkingFloor> floors;
    private ParkingAllocationStrategy allocationStrategy;
    private FareCalculationStrategy fareStrategy;
    private int ticketCounter = 1;

    public ParkingLot(List<ParkingFloor> floors, ParkingAllocationStrategy allocationStrategy, FareCalculationStrategy fareStrategy) {
        this.floors = floors;
        this.allocationStrategy = allocationStrategy;
        this.fareStrategy = fareStrategy;
    }

    public Ticket parkVehicle(Vehicle vehicle) {

        ParkingSpot spot = allocationStrategy.findSpot(floors, vehicle);

        if (spot == null) {
            throw new RuntimeException("Parking lot is full");
        }
        spot.park(vehicle);
        return new Ticket(ticketCounter++,vehicle, spot);
    }

    public double unparkVehicle(Ticket ticket) {
        double fare = fareStrategy.calculateFare(ticket, LocalDateTime.now());
        ticket.getParkingSpot().vacate();
        return fare;
    }
}
