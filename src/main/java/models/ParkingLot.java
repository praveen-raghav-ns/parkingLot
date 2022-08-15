//package models;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ParkingLot {
//    private Integer latestSpaceDisplayId = 0;
//    public Map<VehicleType, Integer> vehicleSpaceCountMap = new HashMap<>();
//    public Map<VehicleType, List<ParkingSpace>> parkingSpaces = new HashMap<>();
//
//    public void addParkingSpace(VehicleType vehicleType, Integer newFreeSpace) {
//        vehicleSpaceCountMap.put(vehicleType, vehicleSpaceCountMap.getOrDefault(vehicleType, 0) + newFreeSpace);
//        List<ParkingSpace> parkingSpaceList;
//
//        if(parkingSpaces.containsKey(vehicleType)) {
//            parkingSpaceList = parkingSpaces.get(vehicleType);
//        } else {
//            parkingSpaceList = new ArrayList<>();
//        }
//
//        for(int i=0;i<newFreeSpace;++i) {
//            parkingSpaceList.add(new ParkingSpace(vehicleType, getNewDisplayId()));
//        }
//    }
//
//    public Integer getNewDisplayId() {
//        return ++latestSpaceDisplayId;
//    }
//}
