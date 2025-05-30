package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.data.Item;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;

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
        int pilihan;
        do {
            System.out.println("=== MENU KELOLA LAPORAN BARANG ===");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil (Claimed)");
            System.out.println("0. Kembali");
            System.out.print("Masukkan Pilihan: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Masukkan angka yang valid: ");
                scanner.next();
            }

            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("=== SEMUA LAPORAN BARANG ===");
                    for (Item item : LoginSystem.reportedItems) {
                        item.displayItem();
                        System.out.println("----------------------------------");
                    }
                    break;

                case 2:
                    ArrayList<Item> items = LoginSystem.reportedItems;
                    ArrayList<Integer> indexMap = new ArrayList<>();

                    System.out.println("=== LAPORAN YANG BELUM DIAMBIL ===");
                    Iterator<Item> iterator = items.iterator();
                    int index = 0;
                    int no = 1;
                    while (iterator.hasNext()) {
                        Item item = iterator.next();
                        if ("Reported".equalsIgnoreCase(item.getStatus())) {
                            System.out.println(no + ". " + item.getItemName());
                            indexMap.add(index);
                            no++;
                        }
                        index++;
                    }

                    if (indexMap.isEmpty()) {
                        System.out.println("Tidak ada barang yang belum diambil.");
                        break;
                    }

                    System.out.print("Masukkan nomor barang yang ingin ditandai: ");
                    try {
                        int input = scanner.nextInt();
                        scanner.nextLine();

                        if (input < 1 || input > indexMap.size()) {
                            throw new IndexOutOfBoundsException();
                        }

                        int originalIndex = indexMap.get(input - 1);
                        items.get(originalIndex).setStatus("Claimed");
                        System.out.println("Status berhasil diubah menjadi 'Claimed'.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka.");
                        scanner.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Nomor tidak tersedia dalam daftar.");
                    }

                    break;

                case 0:
                    System.out.println("Kembali ke menu utama...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
            System.out.println();
        } while (pilihan != 0);
    }

    @Override
    public void manageUsers() {
        int pilihan;
        do {
            System.out.println("=== MENU KELOLA MAHASISWA ===");
            System.out.println("1. Lihat Daftar Mahasiswa");
            System.out.println("2. Tambah Mahasiswa Baru");
            System.out.println("3. Hapus Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Masukkan Pilihan: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Masukkan angka yang valid: ");
                scanner.next();
            }

            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    lihatMahasiswa();
                    break;
                case 2:
                    tambahMahasiswa();
                    break;
                case 3:
                    hapusMahasiswa();
                    break;
                case 0:
                    System.out.println("Kembali ke menu utama...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
            System.out.println();

        } while (pilihan != 0);
    }

    private void lihatMahasiswa() {
        System.out.println("=== DAFTAR MAHASISWA TERDAFTAR ===");
        int count = 0;
        for (User user : LoginSystem.userList) {
            if (user instanceof Mahasiswa) {
                count++;
                System.out.println(count + ". " + user.getNama() + " - NIM: " + user.getNim());
            }
        }
        if (count == 0) {
            System.out.println("Belum ada mahasiswa yang terdaftar.");
        }
    }

    private void tambahMahasiswa() {
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = scanner.nextLine();

        for (User user : LoginSystem.userList) {
            if (user instanceof Mahasiswa && user.getNim().equals(nim)) {
                System.out.println("Mahasiswa dengan NIM ini sudah terdaftar.");
                return;
            }
        }

        Mahasiswa mahasiswaBaru = new Mahasiswa(nama, nim);
        LoginSystem.userList.add(mahasiswaBaru);
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    private void hapusMahasiswa() {
        lihatMahasiswa();
        System.out.print("Masukkan nomor mahasiswa yang ingin dihapus: ");
        try {
            int nomor = scanner.nextInt();
            scanner.nextLine();

            int index = -1;
            int count = 0;
            int currentIndex = 0;

            for (User user : LoginSystem.userList) {
                if (user instanceof Mahasiswa) {
                    count++;
                    if (count == nomor) {
                        index = currentIndex;
                        break;
                    }
                }
                currentIndex++;
            }

            if (index != -1) {
                LoginSystem.userList.remove(index);
                System.out.println("Mahasiswa berhasil dihapus.");
            } else {
                System.out.println("Nomor tidak valid.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka.");
            scanner.nextLine();
        }
    }
}
