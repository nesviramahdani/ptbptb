package com.example.myapplication.Model;



import java.util.List;

public class History {
    private List<Result> history;

    public List<Result> getHistory() {
        return history;
    }

    public void setHistory(List<Result> history) {
        this.history = history;
    }

    public class Result{
        private int id;
        private String nama;
        private int jumlah;
        private int harga;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public int getJumlah() {
            return jumlah;
        }

        public void setJumlah(int jumlah) {
            this.jumlah = jumlah;
        }

        public int getHarga() {
            return harga;
        }

        public void setHarga(int harga) {
            this.harga = harga;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "id=" + id +
                    ", nama='" + nama + '\'' +
                    ", jumlah=" + jumlah +
                    ", harga=" + harga +
                    '}';
        }
    }
}
