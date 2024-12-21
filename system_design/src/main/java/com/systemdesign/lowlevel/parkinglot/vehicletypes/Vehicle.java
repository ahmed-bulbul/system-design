package com.systemdesign.lowlevel.parkinglot.vehicletypes;

public abstract class Vehicle {
    private final String licensePlate;
    private final VehicleType type;


    protected Vehicle(String licensePlate, VehicleType type) {
        if(licensePlate == null || type == null){
            throw new IllegalArgumentException("License or type can not be null");
        }
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }
}
