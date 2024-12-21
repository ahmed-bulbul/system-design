package com.systemdesign.lowlevel.parkinglot;

import com.systemdesign.lowlevel.parkinglot.vehicletypes.TruckType;
import com.systemdesign.lowlevel.parkinglot.vehicletypes.Vehicle;


public class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate, new TruckType());
    }
}
