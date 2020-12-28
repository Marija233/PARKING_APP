package com.example.parkingapp.screen.city;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingapp.databinding.ItemCityBinding;
import com.example.parkingapp.model.City;

import java.util.ArrayList;
import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private Context context;
    private final List<City> cityList;

    CityAdapter(Context context) {
        this.context = context;
        cityList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemCityBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(cityList.get(position));
    }

    public void addAll(List<City> cities) {
        cityList.clear();
        cityList.addAll(cities);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return cityList != null ? cityList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemCityBinding itemCityBinding;

        public ViewHolder(@NonNull ItemCityBinding itemCityBinding) {
            super(itemCityBinding.getRoot());
            this.itemCityBinding = itemCityBinding;
        }

        public void bind(City city) {
            if (city != null && !TextUtils.isEmpty(city.cityName)) {
                itemCityBinding.itemCityName.setText(city.cityName);
            }
        }
    }
}
