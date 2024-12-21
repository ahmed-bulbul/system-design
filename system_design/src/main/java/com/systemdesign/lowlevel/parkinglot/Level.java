package com.systemdesign.lowlevel.parkinglot;

import com.systemdesign.lowlevel.parkinglot.vehicletypes.CarType;
import com.systemdesign.lowlevel.parkinglot.vehicletypes.MotorCycleType;
import com.systemdesign.lowlevel.parkinglot.vehicletypes.TruckType;
import com.systemdesign.lowlevel.parkinglot.vehicletypes.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private final int floor;
    private final List<ParkingSpot> parkingSpots;

    public Level(int floor, int numSpot) {
        this.floor = floor;
        this.parkingSpots = new ArrayList<>();
        alocateSpots(numSpot);
    }

    private void alocateSpots(int numSpot) {
        // suppose spot is 5 -> motor -2, car -2 , truck - 1
        int numMotorcycles = (int) (numSpot * .50);
        int numCars = (int) (numSpot * .40);
        int numTrucks = numSpot - numMotorcycles - numCars;

        for(int i = 1;i<= numMotorcycles;i++){
            parkingSpots.add(new ParkingSpot(i,new MotorCycleType()));
        }

        for(int i = numMotorcycles + 1 ;i<= numMotorcycles + numCars;i++){
            parkingSpots.add(new ParkingSpot(i,new CarType()));
        }

        for(int i = numMotorcycles + numCars +  1 ;i<= numSpot;i++){
            parkingSpots.add(new ParkingSpot(i,new TruckType()));
        }

    }

    public synchronized boolean parkVehicle(Vehicle vehicle){
        for(ParkingSpot spot : parkingSpots){
            if(spot.isAvailable() && spot.getVehicleType().getType()
                    .equals(vehicle.getType().getType())){
                spot.parkVehicle(vehicle);
                System.out.println("Vehicle "+vehicle.getLicensePlate()
                        + "parked at spot "+spot.getSpotNumber());
                return true;
            }
        }

        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle){
        for(ParkingSpot spot : parkingSpots){
            if(!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)){
                spot.unparkVehicle();
                System.out.println("Vehicle "+vehicle.getLicensePlate()
                        + " is unparked from spot "+spot.getSpotNumber());
                return true;
            }
        }

        return false;
    }

    public void displayAvailability(){
        System.out.println("Level "+floor + " Availability : ");
        for(ParkingSpot spot : parkingSpots){
            System.out.println("Spot "+spot.getSpotNumber() +
                    " : "+(spot.isAvailable() ? "Available":"Unavailable"));
        }
    }
}
