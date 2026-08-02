package com.lld.services;

import com.lld.models.Ticket;

import java.time.LocalDateTime;

public interface FareCalculationStrategy {

    double calculateFare(Ticket ticket, LocalDateTime exitTime);
}
