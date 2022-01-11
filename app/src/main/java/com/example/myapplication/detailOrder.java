package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class detailOrder extends AppCompatActivity {
    TextView result;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);

        String nama = getIntent().getStringExtra("nama");
        String jumlah = getIntent().getStringExtra("jumlah");
        String harga = getIntent().getStringExtra("harga");

        result = findViewById(R.id.tv_order);
        result.setText("Anda Telah Melakukan Isi Ulang Galon pada Depot" +nama+"\n dengan jumlah"+jumlah+"\n\ndan total Harga"+harga);
    }
}