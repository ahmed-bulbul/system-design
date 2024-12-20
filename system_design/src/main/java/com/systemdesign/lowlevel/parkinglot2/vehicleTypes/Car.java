package com.systemdesign.lowlevel.parkinglot2.vehicleTypes;

public class Car extends Vehicle {

    public static final String TYPE = "Car";
    public Car(String licensePlate) {
        super(licensePlate,TYPE);
    }

}
