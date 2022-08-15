package models;

import constants.VehicleType;

import java.util.Objects;

public class ParkingSpace {
    private VehicleType vehicleType;
    private Integer displayId;

    public ParkingSpace(VehicleType vehicleType, Integer displayId) {
        this.vehicleType = vehicleType;
        this.displayId = displayId;
    }

    public Integer getDisplayId() {
        return displayId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpace that = (ParkingSpace) o;
        return vehicleType == that.vehicleType && Objects.equals(displayId, that.displayId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleType, displayId);
    }
}
