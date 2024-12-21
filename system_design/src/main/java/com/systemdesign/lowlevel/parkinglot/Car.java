package com.systemdesign.lowlevel.parkinglot;

import com.systemdesign.lowlevel.parkinglot.vehicletypes.CarType;
import com.systemdesign.lowlevel.parkinglot.vehicletypes.Vehicle;

public class Car extends Vehicle {

    public Car(String licensePlate) {
        super(licensePlate, new CarType());
    }
}
