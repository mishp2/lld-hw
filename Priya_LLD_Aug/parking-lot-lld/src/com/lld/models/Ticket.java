package com.lld.models;

import java.time.LocalDateTime;

public class Ticket {

    private final int ticketNumber;
    private final Vehicle vehicle;
    private final LocalDateTime entryTime;
    private final ParkingSpot parkingSpot;

    public Ticket(int ticketNumber, Vehicle vehicle,ParkingSpot parkingSpot) {
        this.ticketNumber = ticketNumber;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = LocalDateTime.now();
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}
