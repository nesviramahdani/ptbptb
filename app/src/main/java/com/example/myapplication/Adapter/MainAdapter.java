package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.MainModel;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<MainModel.Result> results;
    private OnAdapterListener listener;

    public MainAdapter(List<MainModel.Result> results, OnAdapterListener listener){
        this.results = results;
        this.listener = listener;
    }


    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder (
            LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_movie, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainModel.Result galon = results.get(position);
        holder.textView.setText(galon.getNama_galon());
        holder.textView2.setText(galon.getAlamat_galon());
        holder.textView3.setText(galon.getBukaTutup());
        holder.textView4.setText(galon.getTelepon());
        holder.textView5.setText(galon.getHarga());
        Picasso.get()
                .load(galon.getImage())
                //.fit().centerCrop()
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(galon);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
            textView4 = itemView.findViewById(R.id.textView4);
            textView5 = itemView.findViewById(R.id.tvHarga);
        }
        }
    public void  setData(List<MainModel.Result> data){
        results.clear();
        results.addAll(data);
        notifyDataSetChanged();
    }

    public interface OnAdapterListener{
        void onClick(MainModel.Result galon);
    }
}
