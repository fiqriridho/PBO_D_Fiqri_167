package com.praktikum.main;

import com.praktikum.data.Item;
import com.praktikum.users.*;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    public static ArrayList<Item> getReportedItems() {
        return reportedItems;
    }

    static {
        userList.add(new Admin("Admin1", "167", "Admin167", "password167"));
        userList.add(new Mahasiswa("Fiqri", "   167"));
    }

    public static User login(String usernameOrName, String passwordOrNIM, String role) {
        for (User u : userList) {
            if ("Admin".equalsIgnoreCase(role) && u instanceof Admin) {
                if (u.login(usernameOrName, passwordOrNIM)) {
                    return u;
                }
            } else if ("Mahasiswa".equalsIgnoreCase(role) && u instanceof Mahasiswa) {
                if (u.login(usernameOrName, passwordOrNIM)) {
                    return u;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner Inputobj = new Scanner(System.in);
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

                    User admin = login(user, pass, "Admin");
                    if (admin != null) {
                        admin.displayInfo();
                        ((Admin) admin).displayAppMenu();
                    } else {
                        System.out.println("Login admin gagal!");
                    }
                    break;

                case 2:
                    System.out.print("Nama: ");
                    String nama = Inputobj.nextLine();
                    System.out.print("NIM: ");
                    String nim = Inputobj.nextLine();

                    User mahasiswa = login(nama, nim, "Mahasiswa");
                    if (mahasiswa != null) {
                        mahasiswa.displayInfo();
                        ((Mahasiswa) mahasiswa).displayAppMenu();
                    } else {
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
