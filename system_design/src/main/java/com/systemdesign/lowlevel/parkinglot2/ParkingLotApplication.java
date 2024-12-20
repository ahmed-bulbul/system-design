package com.systemdesign.lowlevel.parkinglot2;

import com.systemdesign.lowlevel.parkinglot2.vehicleTypes.Car;
import com.systemdesign.lowlevel.parkinglot2.vehicleTypes.MotorCycle;
import com.systemdesign.lowlevel.parkinglot2.vehicleTypes.Truck;
import com.systemdesign.lowlevel.parkinglot2.vehicleTypes.Vehicle;

public class ParkingLotApplication {
    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getInstance();

        parkingLot.addLevel(new Level(1, 5));
        parkingLot.addLevel(new Level(2, 5));

        Vehicle car = new Car("ABC123");
        Vehicle car2 = new Car("ABC1234");
        Vehicle truck = new Truck("XYZ789");
        Vehicle motorcycle = new MotorCycle("M1234");

        // Display availability
        parkingLot.displayAvailability();

        System.out.println("----------Parking-------");

        // Park vehicles
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(motorcycle);



        // Unpark vehicle
        parkingLot.unparkVehicle(motorcycle);

        System.out.println("-------------unpark---------------");


        // Display updated availability
        parkingLot.displayAvailability();

    }
}
