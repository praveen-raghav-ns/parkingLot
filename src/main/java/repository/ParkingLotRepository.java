package repository;

import models.ParkingSpace;
import constants.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {

    private static ParkingLotRepository parkingLotRepository;

    public Map<VehicleType, Integer> vehicleSpaceMaxCountMap = new HashMap<>();
    public Map<VehicleType, List<ParkingSpace>> parkingSpacesMap = new HashMap<>();
    private static Integer latestSpaceDisplayId = 0;

    private ParkingLotRepository() {}

    public static synchronized ParkingLotRepository getInstance() {
        if(parkingLotRepository == null) {
            parkingLotRepository = new ParkingLotRepository();
        }
        return parkingLotRepository;
    }

    public void addParkingSpace(VehicleType vehicleType, Integer newFreeSpace) {
        vehicleSpaceMaxCountMap.put(vehicleType, vehicleSpaceMaxCountMap.getOrDefault(vehicleType, 0) + newFreeSpace);
        List<ParkingSpace> parkingSpaceList;

        if(parkingSpacesMap.containsKey(vehicleType)) {
            parkingSpaceList = parkingSpacesMap.get(vehicleType);
        } else {
            parkingSpaceList = new ArrayList<>();
            parkingSpacesMap.put(vehicleType, parkingSpaceList);
        }

        for(int i=0;i<newFreeSpace;++i) {
            parkingSpaceList.add(new ParkingSpace(vehicleType, getNewDisplayId()));
        }

    }

    public Optional<ParkingSpace> findParkingSpace(final VehicleType vehicleType) {
        if(parkingSpacesMap.containsKey(vehicleType)) {
            List<ParkingSpace> parkingSpaces = parkingSpacesMap.get(vehicleType);
            for(ParkingSpace parkingSpace : parkingSpaces) {
                if(!TicketsRepository.getInstance().isParkingSpaceBooked(parkingSpace)) {
                    return Optional.of(parkingSpace);
                }
            }
        }
        return Optional.empty();
    }

    private Integer getNewDisplayId() {
        return ++latestSpaceDisplayId;
    }
}
