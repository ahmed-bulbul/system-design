package com.systemdesign.lowlevel.parkinglot2.vehicleTypes;


public abstract class Vehicle implements VehicleType {
    protected final String licensePlate;
    protected final String type;

    protected Vehicle(String licensePlate, String type) {
        if(licensePlate == null || type == null || licensePlate.isEmpty() || type.isEmpty()) {
            throw new IllegalArgumentException("License plate and type cannot be null.");
        }
        this.type = type;
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getType() {
        return type;
    }

}
