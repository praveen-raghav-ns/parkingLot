package models.rateplan;

import constants.IntervalType;

public class Interval {
    private IntervalType intervalType;

    public Interval(IntervalType intervalType) {
        this.intervalType = intervalType;
    }

    public IntervalType getIntervalType() {
        return intervalType;
    }
}
