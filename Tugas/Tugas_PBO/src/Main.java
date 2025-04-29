import java.util.Scanner;
//ini modul 3
public class Main {
    public static void main(String[] args) {
        Scanner Inputobj = new Scanner(System.in);
        Admin admin = new Admin("Admin1","01", "Admin167","password167");
        Mahasiswa mahasiswa = new Mahasiswa("Fiqri Ridho Firmansyah","202410370110167");

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

            if (admin.login(username, password)) {
                admin.displayInfo();
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }
        } else if (pilihan == 2) {
            System.out.print("Masukkan Nama : ");
            String nama = Inputobj.nextLine();
            System.out.print("Masukkan NIM : ");
            String nim = Inputobj.nextLine();

            if (mahasiswa.login(nama, nim)) {
                mahasiswa.displayInfo();
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }
        Inputobj.close();
    }
}
