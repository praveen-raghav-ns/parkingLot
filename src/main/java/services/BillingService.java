package services;

import constants.FeeType;
import constants.IntervalType;
import models.Ticket;
import models.rateplan.RatePlan;
import repository.RatePlanRepository;
import repository.TicketsRepository;
import services.feestrategy.DailyFeeStrategy;
import services.feestrategy.FeeStrategy;
import services.feestrategy.HourlyFeeStrategy;

import java.util.List;

public class BillingService {

    public static double calculateAmount(String vehicleNo, double exitTime) {
        Ticket ticket = TicketsRepository.getInstance().getTicketByVehicleNo(vehicleNo);

        double parkedInterval = exitTime - ticket.getFromTime();
        double remainingInterval = parkedInterval;

        List<RatePlan> ratePlanList = RatePlanRepository.getInstance().getRatePlan(ticket.getVehicle().getVehicleType());

        double totalAmount = 0;
        for (RatePlan ratePlan: ratePlanList) {
            IntervalType intervalType = ratePlan.getInterval().getIntervalType();
            FeeStrategy feeStrategy ;
            feeStrategy = intervalType.equals(IntervalType.DAILY) ?
                                new DailyFeeStrategy() :
                                new HourlyFeeStrategy();

            totalAmount += feeStrategy.calculateFeesForInterval(ticket, remainingInterval, ratePlan);
            remainingInterval -= feeStrategy.getDeductionHours(ratePlan);
            if(remainingInterval <= 0) {
                break;
            }
        }

        System.out.println("UnParking :" + vehicleNo);
        System.out.println("Amoount paid:  " + totalAmount);
        return totalAmount;
    }
}
