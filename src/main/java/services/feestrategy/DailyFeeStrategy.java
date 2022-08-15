package services.feestrategy;

import constants.FeeType;
import models.Ticket;
import models.rateplan.RatePlan;

public class DailyFeeStrategy implements FeeStrategy{
    public double calculateFeesForInterval(Ticket ticket, double remainingInterval, RatePlan ratePlan) {
        double amount = 0;
        if (ratePlan.getFeeType().equals(FeeType.PER_UNIT)) {
            amount = (remainingInterval/24)*ratePlan.getFee();
        } else if(ratePlan.getFeeType().equals(FeeType.FLAT_FEE)) {
            amount = ratePlan.getFee();
        }
        return amount;
    }

    public double getDeductionHours(RatePlan ratePlan){
        return Integer.MAX_VALUE;
    }
}
