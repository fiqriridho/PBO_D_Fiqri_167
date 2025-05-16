package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;

import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {


    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return inputNama.equals(getNama()) && inputNim.equals(getNim());
    }

    @Override
    public void displayInfo(){
        System.out.println("Login Mahasiswa Berhasil");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
    }

    @Override
    public void reportItem() {
        System.out.println("LAPORAN KEHILANGAN");
        System.out.print("Masukkan Nama Barang: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Masukkan Nama Deskripsi Barang: ");
        String deskripsiBarang = scanner.nextLine();
        System.out.print("Masukkan Lokasi Terakhir Ditemukan: ");
        String lokasi = scanner.nextLine();

        System.out.println();
        System.out.println(">> Laporan berhasil dikirim! <<");
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Deskripsi: " + deskripsiBarang);
        System.out.println("Lokasi: " + lokasi);
        System.out.println("Laporan Diterima Harap Tunggu");
    }

    @Override
    public void viewReportedItems() {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }

    @Override
    public void displayAppMenu() {
        int pilihan;
        do {
            System.out.println("===== MENU MAHASISWA =====");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
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
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
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
}