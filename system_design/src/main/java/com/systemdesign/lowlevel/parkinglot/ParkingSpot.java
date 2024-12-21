package com.systemdesign.lowlevel.parkinglot;

import com.systemdesign.lowlevel.parkinglot.vehicletypes.Vehicle;
import com.systemdesign.lowlevel.parkinglot.vehicletypes.VehicleType;

public class ParkingSpot {
    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean isAvailable(){
        return parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle){
        if(isAvailable() && vehicle.getType().getType().equals(vehicleType.getType())){
            parkedVehicle = vehicle;
        }else{
            throw new IllegalArgumentException("Invalid vehicle type or spot already occupied");
        }
    }

    public synchronized void unparkVehicle(){
        if(!isAvailable()){
            parkedVehicle = null;
        }else{
            throw new IllegalStateException("Spot is already empty");
        }
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
