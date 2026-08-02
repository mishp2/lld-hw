import com.lld.enums.VehicleType;
import com.lld.models.*;
import com.lld.services.impl.HourlyFareCalculation;
import com.lld.services.impl.NearestParkingAllocation;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ParkingSpot bikeSpot =
                new ParkingSpot(1, VehicleType.BIKE);

        ParkingSpot carSpot =
                new ParkingSpot(2, VehicleType.CAR);

        ParkingFloor groundFloor = new ParkingFloor(
                        0, List.of(bikeSpot, carSpot));

        ParkingLot parkingLot = new ParkingLot(List.of(groundFloor), new NearestParkingAllocation(), new HourlyFareCalculation(50));

        Vehicle car =
                new Vehicle(
                        "DL-01-AB-1234",
                        VehicleType.CAR
                );

        Ticket ticket = parkingLot.parkVehicle(car);

        System.out.println(
                "Allocated spot: "
                        + ticket.getParkingSpot().getSpotNumber()
        );

        double fare = parkingLot.unparkVehicle(ticket);

        System.out.println("Fare: " + fare);
    }
}