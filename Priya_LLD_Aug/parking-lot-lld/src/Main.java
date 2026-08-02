import com.lld.display.DisplayBoard;
import com.lld.enums.VehicleType;
import com.lld.models.*;
import com.lld.services.ParkingService;
import com.lld.services.impl.HourlyFareCalculation;
import com.lld.services.impl.NearestParkingAllocation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ParkingSpot bikeSpot = new ParkingSpot(1, VehicleType.BIKE);
        ParkingSpot carSpot = new ParkingSpot(2, VehicleType.CAR);

        ParkingFloor groundFloor = new ParkingFloor(1, List.of(bikeSpot, carSpot));
        DisplayBoard displayBoard = new DisplayBoard();
        ParkingLot parkingLot = new ParkingLot("PL-1",List.of(groundFloor));

        ParkingService parkingService = new ParkingService(
                parkingLot,
                new NearestParkingAllocation(),
                new HourlyFareCalculation(50),
                displayBoard
        );
        Vehicle car = new Vehicle("DL-01-AB-1234", VehicleType.BIKE);
        Ticket ticket = parkingService.parkVehicle(car);
        double fare = parkingService.unparkVehicle(ticket);
        System.out.println("Allocated spot: " + ticket.getParkingSpot().getSpotNumber());
        System.out.println("Fare: " + fare);
    }
}