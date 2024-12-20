package com.systemdesign.lowlevel.parkinglot;

import com.systemdesign.lowlevel.parkinglot.vehicletype.Car;
import com.systemdesign.lowlevel.parkinglot.vehicletype.Motorcycle;
import com.systemdesign.lowlevel.parkinglot.vehicletype.Truck;
import com.systemdesign.lowlevel.parkinglot.vehicletype.Vehicle;

public class ParkingLotDemo {

    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1, 5));
        parkingLot.addLevel(new Level(2, 5));

        Vehicle car = new Car("ABC123");
        Vehicle truck = new Truck("XYZ789");
        Vehicle motorcycle = new Motorcycle("M1234");

        // Park vehicles
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(motorcycle);

        // Display availability
        parkingLot.displayAvailability();

        // Unpark vehicle
        parkingLot.unparkVehicle(motorcycle);

        System.out.println("----------------------------");
        System.out.println("After unparking motorcycle:");
        System.out.println();
        System.out.println("----------------------------");

        // Display updated availability
        parkingLot.displayAvailability();
    }
}