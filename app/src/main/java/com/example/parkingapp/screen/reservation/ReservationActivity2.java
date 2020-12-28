package com.example.parkingapp.screen.reservation;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parkingapp.R;

import java.util.ArrayList;
import java.util.List;

public class ReservationActivity2 extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {
    private Spinner selectionSpinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);

        initDynamicListSpinner();
        initSelectionSpinner();
    }

    private void initDynamicListSpinner() {
      Spinner dynamicListSpinner = findViewById(R.id.selection_header);

      //  Custom choices
       List<CharSequence> choices = new ArrayList<>();
        choices.add("18:00-19:00");
         choices.add("19:00-20:00");
        choices.add("20:00-21:00");
        choices.add("21:00-22:00");
        choices.add("22:00-23:00");
        choices.add("23:00-24:00");

       //  Create an ArrayAdapter with custom choices
       ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, choices);

        //Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

       // Set the adapter to th spinner
        dynamicListSpinner.setAdapter(adapter);
    }

    private void initSelectionSpinner() {
       selectionSpinner = findViewById(R.id.selection_header);

        // Set SpinnerActivity as the item selected listener
       selectionSpinner.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Toast.makeText(this, selectionSpinner.getSelectedItem() + " selected", Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }
}