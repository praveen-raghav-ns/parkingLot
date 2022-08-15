import constants.FeeType;
import models.Ticket;
import models.Vehicle;
import constants.VehicleType;
import models.rateplan.DailyInterval;
import models.rateplan.HourlyInterval;
import models.rateplan.RatePlan;
import repository.ParkingLotRepository;
import repository.RatePlanRepository;
import repository.TicketsRepository;

import java.util.Optional;

public class Driver {
    public static void main(String[] args) {
        testStadiumParkingLot();
//        testAirportParkingLot();
    }

    static void testStadiumParkingLot() {

        Vehicle car1 = new Vehicle(VehicleType.CAR, "car1");
        Vehicle car2 = new Vehicle(VehicleType.CAR, "car2");
        Vehicle bike1 = new Vehicle(VehicleType.BIKE, "bike1");

        ParkingLotRepository.getInstance().addParkingSpace(VehicleType.BIKE, 5);
        ParkingLotRepository.getInstance().addParkingSpace(VehicleType.CAR, 3);
        TicketsRepository ticketsRepository = TicketsRepository.getInstance();

        Optional<Ticket> car1Ticket = ticketsRepository.createTicket(car1, 1.0);
        Optional<Ticket> car2Ticket = ticketsRepository.createTicket(car2, 1.0);

        RatePlan bikeRatePlan1 = new RatePlan(FeeType.FLAT_FEE, new HourlyInterval(0, 4), 30, VehicleType.BIKE);
        RatePlan bikeRatePlan2 = new RatePlan(FeeType.FLAT_FEE, new HourlyInterval(4, 12), 60, VehicleType.BIKE);
        RatePlan bikeRatePlan3 = new RatePlan(FeeType.PER_UNIT, new HourlyInterval(12, 300), 60, VehicleType.BIKE);

        RatePlan carRatePlan1 = new RatePlan(FeeType.FLAT_FEE, new HourlyInterval(0, 4), 60, VehicleType.CAR);
        RatePlan carRatePlan2 = new RatePlan(FeeType.FLAT_FEE, new HourlyInterval(4, 12), 120, VehicleType.CAR);
        RatePlan carRatePlan3 = new RatePlan(FeeType.PER_UNIT, new HourlyInterval(12, 300), 200, VehicleType.CAR);

        RatePlanRepository ratePlanRepository = RatePlanRepository.getInstance();
        ratePlanRepository.addRatePlan(VehicleType.BIKE, bikeRatePlan1);
        ratePlanRepository.addRatePlan(VehicleType.BIKE, bikeRatePlan2);
        ratePlanRepository.addRatePlan(VehicleType.BIKE, bikeRatePlan3);
        ratePlanRepository.addRatePlan(VehicleType.CAR, carRatePlan1);
        ratePlanRepository.addRatePlan(VehicleType.CAR, carRatePlan2);
        ratePlanRepository.addRatePlan(VehicleType.CAR, carRatePlan3);

        ticketsRepository.unparkVehicle(car1Ticket.get(), 16);

    }

    static void testAirportParkingLot() {
        Vehicle car1 = new Vehicle(VehicleType.CAR, "car1");
        Vehicle car2 = new Vehicle(VehicleType.CAR, "car2");
        Vehicle bike1 = new Vehicle(VehicleType.BIKE, "bike1");

        ParkingLotRepository.getInstance().addParkingSpace(VehicleType.BIKE, 5);
        ParkingLotRepository.getInstance().addParkingSpace(VehicleType.CAR, 3);
        TicketsRepository ticketsRepository = TicketsRepository.getInstance();

        Optional<Ticket> car1Ticket = ticketsRepository.createTicket(car1, 1.0);
        Optional<Ticket> car2Ticket = ticketsRepository.createTicket(car2, 1.0);

        RatePlan bikeRatePlan1 = new RatePlan(FeeType.FLAT_FEE, new HourlyInterval(0, 1), 0, VehicleType.BIKE);
        RatePlan bikeRatePlan2 = new RatePlan(FeeType.FLAT_FEE, new HourlyInterval(1, 8), 40, VehicleType.BIKE);
        RatePlan bikeRatePlan3 = new RatePlan(FeeType.FLAT_FEE, new HourlyInterval(8, 24), 60, VehicleType.BIKE);
        RatePlan bikeRatePlan4 = new RatePlan(FeeType.PER_UNIT, new DailyInterval(), 80, VehicleType.BIKE);

        RatePlan carRatePlan1 = new RatePlan(FeeType.FLAT_FEE, new HourlyInterval(0, 12), 60, VehicleType.CAR);
        RatePlan carRatePlan2 = new RatePlan(FeeType.FLAT_FEE, new HourlyInterval(12, 24), 80, VehicleType.CAR);
        RatePlan carRatePlan3 = new RatePlan(FeeType.PER_UNIT, new DailyInterval(), 100, VehicleType.CAR);

        RatePlanRepository ratePlanRepository = RatePlanRepository.getInstance();
        ratePlanRepository.addRatePlan(VehicleType.BIKE, bikeRatePlan1);
        ratePlanRepository.addRatePlan(VehicleType.BIKE, bikeRatePlan2);
        ratePlanRepository.addRatePlan(VehicleType.BIKE, bikeRatePlan3);
        ratePlanRepository.addRatePlan(VehicleType.BIKE, bikeRatePlan4);
        ratePlanRepository.addRatePlan(VehicleType.CAR, carRatePlan1);
        ratePlanRepository.addRatePlan(VehicleType.CAR, carRatePlan2);
        ratePlanRepository.addRatePlan(VehicleType.CAR, carRatePlan3);

        ticketsRepository.unparkVehicle(car1Ticket.get(), 47);
    }
}
