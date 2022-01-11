package com.example.myapplication.Model;

import java.util.List;

public class MainModel {
    private List<Result> galon;

    public List<Result> getResult() {
        return galon;
    }

    public void setResult(List<Result> result) {
        this.galon = galon;
    }

    public class Result{
        private int id;
        private String nama_galon;
        private String alamat_galon;
        private String bukaTutup;
        private String telepon;
        private String harga;
        private String image;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNama_galon() {
            return nama_galon;
        }

        public void setNama_galon(String nama_galon) {
            this.nama_galon = nama_galon;
        }

        public String getAlamat_galon() {
            return alamat_galon;
        }

        public void setAlamat_galon(String alamat_galon) {
            this.alamat_galon = alamat_galon;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getBukaTutup() {
            return bukaTutup;
        }

        public void setBukaTutup(String bukaTutup) {
            this.bukaTutup = bukaTutup;
        }

        public String getTelepon() {
            return telepon;
        }

        public void setTelepon(String telepon) {
            this.telepon = telepon;
        }

        public String getHarga() {
            return harga;
        }

        public void setHarga(String harga) {
            this.harga = harga;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "id=" + id +
                    ", nama_galon='" + nama_galon + '\'' +
                    ", alamat_galon='" + alamat_galon + '\'' +
                    ", bukaTutup='" + bukaTutup + '\'' +
                    ", telepon='" + telepon + '\'' +
                    ", harga='" + harga + '\'' +
                    ", image='" + image + '\'' +
                    '}';
        }
    }
    }


