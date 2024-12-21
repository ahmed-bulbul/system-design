package com.systemdesign.lowlevel.parkinglot;

import com.systemdesign.lowlevel.parkinglot.vehicletypes.MotorCycleType;
import com.systemdesign.lowlevel.parkinglot.vehicletypes.Vehicle;

public class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        super(licensePlate, new MotorCycleType());
    }
}
