package com.praktikum.main;

import com.praktikum.data.Item;
import com.praktikum.users.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    public static ArrayList<Item> getReportedItems() {
        return reportedItems;
    }

    public static void main(String[] args) {
        Scanner Inputobj = new Scanner(System.in);

        userList.add(new Admin("Admin1", "167", "Admin167", "password167"));
        userList.add(new Mahasiswa("Fiqri Ridho Firmansyah", "202410370110167"));

        boolean running = true;

        while (running) {
            System.out.println("=== Menu Login ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");

            int pilihan;
            try {
                pilihan = Inputobj.nextInt();
                Inputobj.nextLine();
            } catch (Exception e) {
                System.out.println("Input harus angka!");
                Inputobj.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Username: ");
                    String user = Inputobj.nextLine();
                    System.out.print("Password: ");
                    String pass = Inputobj.nextLine();

                    boolean loginAdmin = false;
                    for (User u : userList) {
                        if (u instanceof Admin && u.login(user, pass)) {
                            u.displayInfo();
                            ((Admin) u).displayAppMenu();
                            loginAdmin = true;
                            break;
                        }
                    }
                    if (!loginAdmin) {
                        System.out.println("Login admin gagal!");
                    }
                    break;

                case 2:
                    System.out.print("Nama: ");
                    String nama = Inputobj.nextLine();
                    System.out.print("NIM: ");
                    String nim = Inputobj.nextLine();

                    boolean loginMhs = false;
                    for (User u : userList) {
                        if (u instanceof Mahasiswa && u.login(nama, nim)) {
                            u.displayInfo();
                            ((Mahasiswa) u).displayAppMenu();
                            loginMhs = true;
                            break;
                        }
                    }
                    if (!loginMhs) {
                        System.out.println("Login mahasiswa gagal!");
                    }
                    break;

                case 0:
                    System.out.println("Program selesai. Terima kasih!");
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

            System.out.println();
        }

        Inputobj.close();
    }
}
