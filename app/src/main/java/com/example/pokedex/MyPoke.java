package com.example.pokedex;

public class MyPoke {
    String nama,type,photo;

    public MyPoke() {
    }

    public MyPoke(String name, String type, String photo) {
        this.nama = nama;
        this.type = type;
        this.photo = photo;
    }

    public String getNama() {
        return nama;
    }

    public void setName(String nama) {
        this.nama = nama;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
