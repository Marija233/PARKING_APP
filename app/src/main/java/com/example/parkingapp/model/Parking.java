package com.example.parkingapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Parking {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "parking_name")
    public String parkingName;

    @ColumnInfo(name = "max_capacity")
    public int maxCapacity;

    @ColumnInfo(name = "reserved_places")
    public int reservedPlaces;

    public Parking(String parkingName, int maxCapacity, int reservedPlaces) {
        this.parkingName = parkingName;
        this.maxCapacity = maxCapacity;
        this.reservedPlaces = reservedPlaces;
    }
}
