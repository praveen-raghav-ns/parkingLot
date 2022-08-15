package models;

import constants.VehicleType;

public class Vehicle {
    private VehicleType vehicleType;
    private String regNo;

    public Vehicle(VehicleType vehicleType, String regNo) {
        this.vehicleType = vehicleType;
        this.regNo = regNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getRegNo() {
        return regNo;
    }
}
