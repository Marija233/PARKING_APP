package com.example.parkingapp.screen.parkingplaces;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.parkingapp.R;
import com.example.parkingapp.app.App;
import com.example.parkingapp.model.Parking;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class ParkingPlaces extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;
    List<Parking> parkingList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_places3);
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, parkingList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        getParkingFromDb();
    }

    private void getParkingFromDb() {
        Executors.newSingleThreadExecutor().execute(() -> {
            adapter.addAll(App.getDatabase().parkingDao().getAll());
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}