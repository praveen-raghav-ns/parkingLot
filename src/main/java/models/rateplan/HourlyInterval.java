package models.rateplan;

import constants.IntervalType;

public class HourlyInterval extends Interval {

    private double startTime;
    private double endTime;

    public HourlyInterval(double startTime, double endTime) {
        super(IntervalType.HOURLY_INTERVAL);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public double getStartTime() {
        return startTime;
    }

    public double getEndTime() {
        return endTime;
    }
}
