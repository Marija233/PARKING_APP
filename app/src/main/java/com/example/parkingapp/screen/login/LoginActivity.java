package com.example.parkingapp.screen.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parkingapp.app.App;
import com.example.parkingapp.databinding.ActivityLoginBinding;
import com.example.parkingapp.screen.city.list.CityActivity;
import com.example.parkingapp.screen.register.RegisterActivity;
import com.example.parkingapp.util.EmailValidator;
import com.example.parkingapp.util.SharedPrefUtil;

import java.util.concurrent.Executors;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private String email = "";
    private String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewBinding();
        initButtons();
    }

    private void initViewBinding() {
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    private void initButtons() {
        binding.register.setOnClickListener(v -> startActivity(new Intent(this, RegisterActivity.class)));
        binding.loginButton.setOnClickListener(v -> {
            mapUserInput();
            if (!email.isEmpty() && !password.isEmpty()) {
                if (EmailValidator.isValidEmail(email)) {
                    Executors.newSingleThreadExecutor().execute(this::initLogin);
                } else {
                    Toast.makeText(this, "Email not valid", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "All input fields must be filled", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mapUserInput() {
        email = binding.username.getText().toString();
        password = binding.password.getText().toString();
    }

    private void initLogin() {
        if (App.getDatabase().userDao().findUserByMail(email) != null) {
            if (App.getDatabase().userDao().findUserByMail(email).password.equals(password)) {
                navigateHome();
            } else {
                runOnUiThread(() -> Toast.makeText(LoginActivity.this, "Incorrect password. Please try again", Toast.LENGTH_SHORT).show());
            }
        } else {
            runOnUiThread(() -> Toast.makeText(LoginActivity.this, "User with that email not found in database", Toast.LENGTH_SHORT).show());
        }
    }

    private void navigateHome() {
        SharedPrefUtil.saveUserEmail(this, email);
        startActivity(new Intent(LoginActivity.this, CityActivity.class));
        finish();
    }
}