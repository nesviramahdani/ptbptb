package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.NumberFormat;

public class GalonActivity extends AppCompatActivity {
    private final String TAG = "GalonActivity";
    int quantity =0;
   /* TextView priceTextView = (TextView) findViewById(R.id.tvTotal);
    TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
    TextView tvnama = findViewById(R.id.tvGalonName);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galon);
        getSupportActionBar().hide();

        TextView tvnama = findViewById(R.id.tvGalonName);
        TextView tvalamat = findViewById(R.id.tvGalonDetail);
        TextView tvbukaTutup = findViewById(R.id.tvGalonBukaTutup);
        TextView tvTelepon = findViewById(R.id.tvGalonTelepon);
        TextView tvharga = findViewById(R.id.tvGalonHarga);


        String nama = getIntent().getStringExtra("intent_nama");
        getSupportActionBar().setTitle(nama);
        String alamat = getIntent().getStringExtra("intent_alamat");
        String bukaTutup = getIntent().getStringExtra("intent_bukaTutup");
        String telepon = getIntent().getStringExtra("intent_telepon");
        String harga = getIntent().getStringExtra("intent_harga");
        String image = getIntent().getStringExtra("intent_image");


        Picasso.get()
                .load(image)
                //.fit().centerCrop()
                .into((ImageView) findViewById(R.id.imgGalon));
        tvnama.setText(nama);
        tvalamat.setText(alamat);
        tvbukaTutup.setText(bukaTutup);
        tvTelepon.setText(telepon);
        tvharga.setText(harga);
    }

   /* private void btn(View view) {
                AlertDialog dialog = new AlertDialog.Builder(GalonActivity.this)
                        .setTitle("Anda yakin ingin keluar ?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                order();
                            }

                            private void order() {
                                Intent i = new Intent(GalonActivity.this, detailOrder.class);
                                i.putExtra("nama", tvnama.getText().toString());
                                i.putExtra("jumlah", quantityTextView.getText().toString());
                                i.putExtra("harga", priceTextView.getText().toString());
                                startActivity(i);
                            }
                        })
                        .setNegativeButton("Tidak", null)
                        .create();
                dialog.show();

            }
*/



    public void increment(View view){//perintah tombol tambah
        if(quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);
    }



    public void decrement(View view){//perintah tombol tambah
        if (quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
    }


    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }

    public void Chek(View view) {

        int price=calculateprice();//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);
        displayMessage(pricemessage);

    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.tvTotal);
        priceTextView.setText(message);
    }

    private int calculateprice(){//jumlah pesanan * harga
        int harga = 5000;

        return quantity * harga;
    }

    private String createOrderSummary(int price){
        String pricemessage = "\n Total Rp" + price;
        pricemessage+="\n Thankyou";
        return  pricemessage;
    }

    public  void btn(View view){
        Intent i = new Intent(GalonActivity.this, detailOrder.class);
        startActivity(i);

    }
}