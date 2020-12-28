package com.example.parkingapp.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ParkingDao {

    @Insert
    void insertAllParking(List<Parking> parking);

    @Query("SELECT * FROM parking")
    List<Parking> getAll();
}

