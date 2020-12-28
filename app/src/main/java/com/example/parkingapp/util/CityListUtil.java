package com.example.parkingapp.util;

import com.example.parkingapp.model.City;

import java.util.ArrayList;
import java.util.List;

public class CityListUtil {

    public static List<City> getCities() {
        List<City> cityList = new ArrayList<>();

        cityList.add(new City("Skopje"));
        cityList.add(new City("Veles"));
        cityList.add(new City("Bitola"));
        cityList.add(new City("Ohrid"));
        cityList.add(new City("Dojran"));
        cityList.add(new City("Stip"));
        cityList.add(new City("Kumanovo"));
        cityList.add(new City("Gostivar"));
        cityList.add(new City("Berovo"));
        cityList.add(new City("Prilep"));

        return cityList;
    }
}
