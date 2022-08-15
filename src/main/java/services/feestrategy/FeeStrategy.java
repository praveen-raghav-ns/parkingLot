package services.feestrategy;

import models.Ticket;
import models.rateplan.RatePlan;

public interface FeeStrategy {
    double calculateFeesForInterval(Ticket ticket, double remainingInterval, RatePlan ratePlan);
    double getDeductionHours(RatePlan ratePlan);
}
