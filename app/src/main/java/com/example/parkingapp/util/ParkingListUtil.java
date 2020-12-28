package com.example.parkingapp.util;

import com.example.parkingapp.model.City;
import com.example.parkingapp.model.Parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingListUtil {
    public static List<Parking> getParking() {
        List<Parking> parkingList = new ArrayList<>();

        parkingList.add(new Parking("Parking 01", 30, 0));
        parkingList.add(new Parking("Parking 02",20,0));
        parkingList.add(new Parking("Parking 03",36,0));
        parkingList.add(new Parking("Parking 04",35,0));
        parkingList.add(new Parking("Parking 05",15,0));
        parkingList.add(new Parking("Parking 06",22,0));
        parkingList.add(new Parking("Parking 07",26,0));
        parkingList.add(new Parking("Parking 08",13,0));
        parkingList.add(new Parking("Parking 09",56,0));
        parkingList.add(new Parking("Parking 10",101,0));

        return parkingList;
    }
}
