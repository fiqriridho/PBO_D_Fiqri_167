import java.util.Scanner;

class Admin{
    private final String username = "Admin167";
    private final String password = "password167";

    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }
}

class Mahasiswa{
    private String nama, nim;

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }
    public boolean login(String inputNama, String inputPassword) {
        return inputNama.equals(nama) && inputPassword.equals(nim);
    }
    public void displayInfo(){
        System.out.println("Login Mahasiswa Berhasil");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }

}
public class Main {
    public static void main(String[] args) {
        Scanner Inputobj = new Scanner(System.in);
        Admin admin = new Admin();
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
                System.out.println("Login Admin Berhasil!");
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