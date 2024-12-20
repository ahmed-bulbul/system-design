package com.systemdesign.lowlevel.parkinglot2;

import com.systemdesign.lowlevel.parkinglot2.vehicleTypes.Vehicle;

public class ParkingSpot {

    private final int spotNumber;
    private final String vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber, String vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean isAvailable() {
        return parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {

        if (isAvailable() && vehicle.getType().equals(vehicleType)) {
            parkedVehicle = vehicle;
        }else {
            throw new IllegalArgumentException("Invalid vehicle type or spot already occupied.");
        }

    }

    public synchronized boolean unparkVehicle() {
        if (!isAvailable()) {
            parkedVehicle = null;
            return true;
        }
        return false;
    }

    public synchronized Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public synchronized int getSpotNumber() {
        return spotNumber;
    }

    public synchronized String getVehicleType() {
        return vehicleType;
    }



}
