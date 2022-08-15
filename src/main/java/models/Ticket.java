package models;

public class Ticket {
    private double fromTime;
    private ParkingSpace parkingSpace;
    private Vehicle vehicle;
    private double toTime;

    public Ticket(Vehicle vehicle, double fromTime, ParkingSpace parkingSpace) {
        this.vehicle = vehicle;
        this.fromTime = fromTime;
        this.parkingSpace = parkingSpace;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public double getFromTime() {
        return fromTime;
    }

    public double getToTime() {
        return toTime;
    }
}
