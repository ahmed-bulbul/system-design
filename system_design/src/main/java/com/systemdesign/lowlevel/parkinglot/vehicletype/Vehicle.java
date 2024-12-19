package com.systemdesign.lowlevel.parkinglot.vehicletype;

public abstract class Vehicle {
    protected VehicleType type;
    protected String licensePlate;

    protected Vehicle(VehicleType vehicleType, String licensePlate) {
        this.type = vehicleType;
        this.licensePlate = licensePlate;
    }

    public VehicleType getType() {
        return type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
