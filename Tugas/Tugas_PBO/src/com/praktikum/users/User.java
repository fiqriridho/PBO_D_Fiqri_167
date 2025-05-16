package com.praktikum.users;


import java.util.Scanner;

//class tambahan dari modul 3
public abstract class User {
    private String nama;
    private String nim;
    Scanner scanner = new Scanner(System.in);


    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public abstract boolean login(String inputNama, String inputNim);

    public void displayInfo() {
        System.out.println("Informasi com.praktikum.users.User");
    }

    public abstract void displayAppMenu();
}

