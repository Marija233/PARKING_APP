package com.example.parkingapp.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CityDao {

    @Insert
    void insertCity(User user);

    @Insert
    void insertAllCities(List<City> cities);

    @Query("SELECT * FROM city")
    List<City> getAll();
}
