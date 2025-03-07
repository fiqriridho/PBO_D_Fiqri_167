import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Inputobj = new Scanner(System.in);
        String AdminUsername = "Admin167";
        String AdminPassword = "password167";

        String[][] MahasiswaData = {
                {"Fiqri Ridho Firmansyah", "202410370110167"},
            };

        System.out.println("Pilih Login : ");
        System.out.println("Pilih 1. Admin ");
        System.out.println("Pilih 2. Mahasiswa ");
        System.out.print("Masukkan pilihan: ");
        int pilihan = Inputobj.nextInt();
        Inputobj.nextLine();

        if (pilihan == 1) {
            System.out.print("Masukkan username : ");
            String username = Inputobj.nextLine();
            System.out.print("Masukkan password : ");
            String password = Inputobj.nextLine();

            if (username.equals(AdminUsername) && password.equals(AdminPassword)) {
                System.out.println("Login Admin Berhasil!");
            }else {
                System.out.println("Login gagal! Username atau password salah.");
        }
        } else if (pilihan == 2) {
            System.out.print("Masukkan Nama : ");
            String nama = Inputobj.nextLine();
            System.out.print("Masukkan NIM : ");
            String nim = Inputobj.nextLine();

            boolean LoginBerhasil = false;
            for (String[] mahasiswa : MahasiswaData){
                if (nama.equals(mahasiswa[0]) && nim.equals(mahasiswa[1])){
                    LoginBerhasil = true;
                    break;
                }
            }if (LoginBerhasil) {
                System.out.println("Login Mahasiswa Berhasil!");
            }else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }

        } else {
            System.out.println("Pilihan tidak valid.");
        }
        Inputobj.close();
    }
}