package services;

import models.Ticket;
import models.Vehicle;
import repository.TicketsRepository;

public class TicketsService {
    TicketsRepository ticketsRepository;
    public TicketsService(){
        ticketsRepository = TicketsRepository.getInstance();
    }

    public void parkVehicle(final Vehicle vehicle, final float curTime) {
        ticketsRepository.createTicket(vehicle, curTime);
    }

    public void unparkVehicle(final Ticket ticket, final float curTime){
        ticketsRepository.unparkVehicle(ticket, curTime);
    }

}
