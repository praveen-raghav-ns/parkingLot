package services.feestrategy;

import constants.FeeType;
import models.Ticket;
import models.rateplan.HourlyInterval;
import models.rateplan.RatePlan;

public class HourlyFeeStrategy implements FeeStrategy{
    public double calculateFeesForInterval(Ticket ticket, double remainingInterval, RatePlan ratePlan) {
        HourlyInterval interval = (HourlyInterval) ratePlan.getInterval();

        double amount = 0;
        if (ratePlan.getFeeType().equals(FeeType.PER_UNIT)) {
            amount = Math.min(remainingInterval, interval.getEndTime() - interval.getStartTime()) * ratePlan.getFee();
        } else if(ratePlan.getFeeType().equals(FeeType.FLAT_FEE)) {
            amount = ratePlan.getFee();
        }
        return amount;
    }

    public double getDeductionHours(RatePlan ratePlan){
        HourlyInterval interval = (HourlyInterval) ratePlan.getInterval();
        return interval.getEndTime() - interval.getStartTime();
    }
}
