package com.systemdesign.lowlevel.parkinglot2.vehicleTypes;

public class Truck  extends Vehicle {

    public static final String TYPE = "Truck";

    public Truck(String licensePlate) {
        super(licensePlate, TYPE);
    }
}
