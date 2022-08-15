package repository;

import constants.VehicleType;
import models.rateplan.RatePlan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatePlanRepository {
    private static RatePlanRepository instance;
    private static Map<VehicleType, List<RatePlan>> ratePlanMap = new HashMap<>();

    private RatePlanRepository() {}

    public static RatePlanRepository getInstance() {
        if (instance == null ) {
            instance = new RatePlanRepository();
        }
        return instance;
    }

    public void addRatePlan(VehicleType vehicleType, RatePlan ratePlan) {
        List<RatePlan> ratePlanList;
        if(ratePlanMap.containsKey(vehicleType)) {
            ratePlanList = ratePlanMap.get(vehicleType);
        } else {
            ratePlanList = new ArrayList<>();
            ratePlanMap.put(vehicleType, ratePlanList);
        }

        ratePlanList.add(ratePlan);
    }

    public List<RatePlan> getRatePlan(VehicleType vehicleType) {
        return ratePlanMap.get(vehicleType);
    }
}
