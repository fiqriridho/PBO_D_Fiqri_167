import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nama;
        char JenisKelamin;
        int TahunLahir;
        int TahunSekarang;
        int Umur;

        Scanner Inputobj = new Scanner(System.in);

        System.out.print("Masukkan Nama: ");
        nama = Inputobj.nextLine();

        System.out.print("Masukkan Jenis Kelamin (P/L): ");
        JenisKelamin = Inputobj.next().charAt(0);

        System.out.print("Masukkan Tahun Lahir: ");
        TahunLahir = Inputobj.nextInt();

        TahunSekarang = LocalDate.now().getYear();
        Umur = TahunSekarang - TahunLahir;

        String jenisKelaminStr;
        if (JenisKelamin == 'L' || JenisKelamin == 'l') {
            jenisKelaminStr = "Laki-laki";
        } else if (JenisKelamin == 'P' || JenisKelamin == 'p') {
            jenisKelaminStr = "Perempuan";
        } else {
            jenisKelaminStr = "Tidak diketahui";
        }

        System.out.println("\nData Diri:");
        System.out.println("Nama          : " + nama);
        System.out.println("Jenis Kelamin : " + jenisKelaminStr);
        System.out.println("Umur          : " + Umur + " tahun");

        Inputobj.close();
    }
}
