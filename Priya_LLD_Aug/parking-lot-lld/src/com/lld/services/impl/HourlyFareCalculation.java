package com.lld.services.impl;

import com.lld.models.Ticket;
import com.lld.services.FareCalculationStrategy;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyFareCalculation implements FareCalculationStrategy {

    private double hourlyRate;

    public HourlyFareCalculation(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateFare(Ticket ticket, LocalDateTime exitTime) {

        long minutes = Duration.between(
                ticket.getEntryTime(),
                exitTime
        ).toMinutes();

        long hours = Math.max(1, (minutes + 59) / 60);
        return hours * hourlyRate;
    }
}
