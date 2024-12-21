package com.systemdesign.lowlevel.parkinglot;

import com.systemdesign.lowlevel.parkinglot.vehicletypes.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<Level> levels;


    public ParkingLot() {
        this.levels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance(){
        if(instance == null){
            instance = new ParkingLot();
        }

        return instance;
    }

    public void addlevel(Level level){
        levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(Level level : levels){
            if(level.parkVehicle(vehicle)){
                return true;
            }
        }

        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle){
        for(Level level : levels){
            if(level.unparkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        for(Level level : levels){
            level.displayAvailability();
        }
    }

}
