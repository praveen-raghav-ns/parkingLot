package models.rateplan;

import constants.FeeType;
import constants.VehicleType;

public class RatePlan {
    private FeeType feeType;
    private Interval interval;
    private double fee;
    private VehicleType vehicleType;

    public RatePlan(FeeType feeType, Interval interval, double fee, VehicleType vehicleType) {
        this.feeType = feeType;
        this.interval = interval;
        this.fee = fee;
        this.vehicleType = vehicleType;
    }

    public FeeType getFeeType() {
        return feeType;
    }

    public Interval getInterval() {
        return interval;
    }

    public double getFee() {
        return fee;
    }

}
