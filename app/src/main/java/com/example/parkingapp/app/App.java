package com.example.parkingapp.app;

import android.app.Application;
import android.content.Context;
import android.view.MenuItem;

import androidx.room.Room;

import com.example.parkingapp.database.AppDatabase;

import java.io.File;

public class App extends Application {

    static AppDatabase db;
    private static final String DB_NAME = "parking";

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, DB_NAME)
                .build();
    }

    public static AppDatabase getDatabase() {
        return db;
    }

    private static boolean doesDatabaseExist(Context context) {
        File dbFile = context.getDatabasePath(DB_NAME);
        return dbFile.exists();
    }




}