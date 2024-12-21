package com.systemdesign.lowlevel.parkinglot;

import com.systemdesign.lowlevel.parkinglot.vehicletypes.Vehicle;

public class ParkingLotApplication {

    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

        parkingLot.addlevel(new Level(1,5));
        parkingLot.addlevel(new Level(2,5));

        Vehicle car = new Car("ABC123");
        Vehicle motorcycle = new Motorcycle("DEF123");
        Vehicle truck = new Truck("XYZ123");


        parkingLot.displayAvailability();

        System.out.println("--------Parking------------");
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(motorcycle);

        System.out.println("----------Ater park-----------");

        parkingLot.displayAvailability();


    }
}
