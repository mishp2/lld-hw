package com.lld.services;

import com.lld.display.DisplayBoard;
import com.lld.models.ParkingLot;
import com.lld.models.ParkingSpot;
import com.lld.models.Ticket;
import com.lld.models.Vehicle;

import java.time.LocalDateTime;

public class ParkingService {

    private final ParkingLot parkingLot;
    private final ParkingAllocationStrategy parkingAllocationStrategy;
    private final FareCalculationStrategy fareCalculationStrategy;
    private final DisplayBoard displayBoard;

    private int ticketCounter =1;

    public ParkingService(ParkingLot parkingLot,
                          ParkingAllocationStrategy parkingAllocationStrategy,
                          FareCalculationStrategy fareCalculationStrategy,
                          DisplayBoard displayBoard) {
        this.parkingLot = parkingLot;
        this.parkingAllocationStrategy = parkingAllocationStrategy;
        this.fareCalculationStrategy = fareCalculationStrategy;
        this.displayBoard = displayBoard;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = parkingAllocationStrategy.findSpot(parkingLot.getFloors(), vehicle);
        if (spot == null) {
            throw new RuntimeException("Parking lot is full");
        }
        spot.park(vehicle);
        Ticket ticket = new Ticket(ticketCounter++, vehicle, spot);
        displayBoard.display(parkingLot.getFloors());
        return ticket;
    }

    public double unparkVehicle(Ticket ticket) {
        double fare = fareCalculationStrategy.calculateFare(ticket, LocalDateTime.now());
        ticket.getParkingSpot().vacate();
        return fare;
    }
}
