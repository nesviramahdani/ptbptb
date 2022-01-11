package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.Adapter.MainAdapter;
import com.example.myapplication.Model.MainModel;
import com.example.myapplication.Retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    //private ProgressBar progressBar;
    private MainAdapter mainAdapter;
    private List<MainModel.Result> results = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        setupView();
        setupRecyclerView();
        getDataFromAPi();
    }

    private void setupRecyclerView() {
        mainAdapter = new MainAdapter(results, new MainAdapter.OnAdapterListener() {
            @Override
            public void onClick(MainModel.Result galon) {
                Toast.makeText(MainActivity.this, galon.getNama_galon(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, GalonActivity.class);
                intent.putExtra("intent_nama", galon.getNama_galon());
                intent.putExtra("intent_image", galon.getImage());
                intent.putExtra("intent_alamat", galon.getAlamat_galon());
                intent.putExtra("intent_bukaTutup", galon.getBukaTutup());
                intent.putExtra("intent_telepon", galon.getTelepon());
                intent.putExtra("intent_harga", galon.getHarga());
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainAdapter);
    }

    private void setupView() {
        recyclerView = findViewById(R.id.recyclerView);
        //progressBar = findViewById(R.id.progressBar);
    }

    private void getDataFromAPi(){
       // progressBar.setVisibility(View.VISIBLE);
        ApiService.endpoint().getData()
                .enqueue(new Callback<MainModel>() {
                    @Override
                    public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                        if(response.isSuccessful()){
                            List<MainModel.Result> results = response.body().getResult();
                            Log.d(TAG, results.toString());
                            mainAdapter.setData(results);
                        }
                    }

                    @Override
                    public void onFailure(Call<MainModel> call, Throwable t) {
                        Log.d(TAG, t.toString());

                    }
                });
    }
}