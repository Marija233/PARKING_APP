package com.example.parkingapp.screen.city.list;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.parkingapp.R;
import com.example.parkingapp.app.App;
import com.example.parkingapp.databinding.ActivityCityBinding;
import com.example.parkingapp.screen.login.LoginActivity;
import com.example.parkingapp.screen.myreservations.MyReservationsActivity;
import com.example.parkingapp.screen.parkingplaces.ParkingPlaces;
import com.example.parkingapp.screen.reservation.ReservationActivity;

import java.util.concurrent.Executors;

public class CityActivity extends AppCompatActivity {

    private ActivityCityBinding binding;
    private CityAdapter cityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewBinding();
        setupUi();
    }

    private void initViewBinding() {
        binding = ActivityCityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    private void setupUi() {
        initCityAdapter();
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, binding.navigationDrawer, binding.toolbarId.toolbar, R.string.open, R.string.close);
        binding.navigationDrawer.addDrawerListener(drawerToggle);
        binding.navigationDrawer.setClickable(true);
        drawerToggle.syncState();
        setupNavigationView();
        showCityList();
    }

    private void setupNavigationView() {
        binding.toolbarId.toolbarBackButton.setVisibility(View.GONE);
        binding.toolbarId.toolbarTitle.setText("Cities");
        binding.mDrawerLayout.setNavigationItemSelectedListener(item -> {
            switchScreen(item.getItemId());
            return true;
        });
    }

    private void switchScreen(int id) {
        binding.navigationDrawer.closeDrawers();
        switch (id) {
            case R.id.menuItemLogout:
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.menuItemExit:
                finish();
                break;
            case R.id.menuItemReservations:
                binding.navigationDrawer.closeDrawers();
                startActivity(new Intent(this, MyReservationsActivity.class));
                break;
            case R.id.menuItemParkingPlaces:
                Intent parkingIntent = new Intent(this, ParkingPlaces.class);
                startActivity(parkingIntent);
                break;
            case R.id.menuItemReservationConfirmation:
                binding.navigationDrawer.closeDrawers();
                Intent intent = new Intent(this, ReservationActivity.class);
                startActivity(intent);
                break;
            default:
                Log.e("TAG", "Nothing selected");
        }
    }

    private void initCityAdapter() {
        cityAdapter = new CityAdapter(this);
        binding.cityRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.cityRecyclerView.setAdapter(cityAdapter);
    }

    private void showCityList() {
        Executors.newSingleThreadExecutor().execute(() -> {
            cityAdapter.addAll(App.getDatabase().cityDao().getAll());
        });
    }
}