package com.systemdesign.lowlevel.parkinglot2;

import com.systemdesign.lowlevel.parkinglot2.vehicleTypes.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private static ParkingLot instance;
    private List<Level> levels;

    private ParkingLot() {
        levels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Level level) {
        levels.add(level);

    }

    public void displayAvailability() {
        for (Level level : levels) {
            level.displayAvailability();
        }
    }

    public void parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                break;
            }
        }
    }

    public void unparkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.unparkVehicle(vehicle)) {
                break;
            }
        }
    }

    public boolean isFull() {
        for (Level level : levels) {
            if (!level.isFull()) {
                return false;
            }
        }
        return true;
    }

}
