package repository;

import models.ParkingSpace;
import models.Ticket;
import models.Vehicle;
import constants.VehicleType;
import services.BillingService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicketsRepository {
    private static TicketsRepository instance;
    private static Map<String, Ticket> ticketsMap = new HashMap<>();

    private TicketsRepository(){}

    public static synchronized TicketsRepository getInstance() {
        if(instance == null) {
            instance = new TicketsRepository();
        }

        return instance;
    }

    public Optional<Ticket> createTicket(final Vehicle vehicle, final double curTime) {
        VehicleType vehicleType = vehicle.getVehicleType();
        Optional<ParkingSpace> optionalParkingSpace = ParkingLotRepository.getInstance().findParkingSpace(vehicleType);
        Optional<Ticket> optionalTicket = Optional.empty();
        if (optionalParkingSpace.isPresent()) {
            Ticket ticket = new Ticket(vehicle, curTime, optionalParkingSpace.get());
            optionalTicket = Optional.of(ticket);
            ticketsMap.put(vehicle.getRegNo(), ticket);
        }
        return optionalTicket;
    }

    public void unparkVehicle(final Ticket ticket, final double exitTime) {
        Vehicle vehicle = ticket.getVehicle();
        BillingService.calculateAmount(vehicle.getRegNo(), exitTime);

        ticketsMap.remove(vehicle.getRegNo());

    }

    public boolean isParkingSpaceBooked(ParkingSpace parkingSpace) {
        for(String vehicleNo : ticketsMap.keySet()) {
            if(ticketsMap.get(vehicleNo).getParkingSpace().equals(parkingSpace)) {
                return true;
            }
        }
        return false;
    }

    public Ticket getTicketByVehicleNo(String vehicleNo) {
        return ticketsMap.get(vehicleNo);
    }

    public void printTickets() {
        for(String vehicleNo : ticketsMap.keySet()) {
            System.out.println("---------------");
            System.out.println(ticketsMap.get(vehicleNo).getVehicle().getRegNo());
            System.out.println(ticketsMap.get(vehicleNo).getParkingSpace().getDisplayId());
        }
    }
}
