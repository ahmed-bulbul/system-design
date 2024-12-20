package com.systemdesign.lowlevel.parkinglot2;

import com.systemdesign.lowlevel.parkinglot2.vehicleTypes.Car;
import com.systemdesign.lowlevel.parkinglot2.vehicleTypes.MotorCycle;
import com.systemdesign.lowlevel.parkinglot2.vehicleTypes.Truck;
import com.systemdesign.lowlevel.parkinglot2.vehicleTypes.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private final int floor;
    private final List<ParkingSpot> parkingSpots;

    public Level(int floor, int numSpots) {
        this.floor = floor;
        parkingSpots = new ArrayList<>(numSpots);
        // Assign spots in ration of 50:40:10 for bikes, cars and trucks
        double spotsForBikes = 0.50;
        double spotsForCars = 0.40;

        int numBikes = (int) (numSpots * spotsForBikes);
        int numCars = (int) (numSpots * spotsForCars);

        for (int i = 1; i <= numBikes; i++) {
            parkingSpots.add(new ParkingSpot(i, MotorCycle.TYPE));
        }
        for (int i = numBikes + 1; i <= numBikes + numCars; i++) {
            parkingSpots.add(new ParkingSpot(i, Car.TYPE));
        }
        for (int i = numBikes + numCars + 1; i <= numSpots; i++) {
            parkingSpots.add(new ParkingSpot(i, Truck.TYPE));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {

        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable() && spot.getVehicleType().equals(vehicle.getType())) {
                spot.parkVehicle(vehicle);
                System.out.println("Vehicle " + vehicle.getLicensePlate()+" [type : "+ vehicle.getType() +"]"+ " has been parked at spot " + spot.getSpotNumber());
                return true;
            }
        }
        return false;
    }



    public synchronized boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)) {
                spot.unparkVehicle();
                System.out.println("Vehicle " + vehicle.getLicensePlate() + " type : "+ vehicle.getType() + " has been unparked from spot " + spot.getSpotNumber());
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("Level " + floor + " Availability:");
        for (ParkingSpot spot : parkingSpots) {
            System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isAvailable() ? "Available For"  : "Occupied By ")+" "+spot.getVehicleType());
        }
    }


    public boolean isFull() {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable()) {
                return false;
            }
        }
        return true;
    }
}
