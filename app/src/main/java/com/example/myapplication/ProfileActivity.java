package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    ImageView imgUser;
    TextView tv_name;
    TextView tv_address;

    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprofile);

        imgUser = findViewById(R.id.imgUser);
        tv_name = findViewById(R.id.tv_nama);
        tv_address = findViewById(R.id.tv_address);

    }
}
