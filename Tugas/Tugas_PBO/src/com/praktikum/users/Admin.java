package com.praktikum.users;

import com.praktikum.actions.AdminActions;

public class Admin extends User implements AdminActions {
    private final String username;
    private final String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin Berhasil!");
        System.out.println("Nama : " + getNama());
        System.out.println("Nim : " + getNim());
    }

    public void displayAppMenu() {
        int pilihan;
        do {
            System.out.println("MENU Admin");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Masukkan Pilihan: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Masukkan angka yang valid: ");
                scanner.next();
            }

            pilihan = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            switch (pilihan) {
                case 1:
                    manageItems();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 0:
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Input salah. Silakan pilih menu yang tersedia.");
            }

            System.out.println();

        } while (pilihan != 0);
    }


    @Override
    public void manageItems() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }
}

