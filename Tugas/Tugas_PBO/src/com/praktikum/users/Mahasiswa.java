package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.data.Item;
import java.util.InputMismatchException;
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
        System.out.println("=== FORM LAPORAN BARANG KEHILANGAN ===");
        System.out.print("Masukkan Nama Barang: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Masukkan Deskripsi Barang: ");
        String deskripsiBarang = scanner.nextLine();
        System.out.print("Masukkan Lokasi Terakhir Ditemukan: ");
        String lokasi = scanner.nextLine();

        Item barang = new Item(namaBarang, deskripsiBarang, lokasi, "Reported");

        LoginSystem.reportedItems.add(barang);

        System.out.println();
        System.out.println(">> Laporan berhasil dikirim! <<");
        System.out.println("-----------------------------------");
        barang.displayItem();
        System.out.println("Laporan diterima. Harap tunggu tindak lanjut.");
    }

    @Override
    public void viewReportedItems() {
        System.out.println("=== DAFTAR LAPORAN BARANG ===");

        boolean adaLaporan = false;
        for (Item item : LoginSystem.reportedItems) {
            if ("Reported".equalsIgnoreCase(item.getStatus())) {
                item.displayItem();
                adaLaporan = true;
            }
        }

        if (!adaLaporan) {
            System.out.println("Belum ada laporan barang.");
        }
    }


    @Override
    public void displayAppMenu() {
        int pilihan = 0;
        do {
            System.out.println("===== MENU MAHASISWA =====");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Masukkan Pilihan: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

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