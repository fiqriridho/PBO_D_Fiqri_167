package perpustakaan;

public class Anggota implements Peminjaman {
    private String nama, idAnggota;

    public Anggota(String nama, String idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;
    }

    @Override
    public void pinjamBuku(Buku buku) {
        System.out.println(nama + " meminjam buku berjudul: " + buku.getJudul());
    }


    public void pinjamBuku(Buku buku, int durasi) {
        System.out.println(nama + " meminjam buku '" + buku.getJudul() + "' selama " + durasi + " hari.");
        System.out.println();
    }


    @Override
    public void kembalikanBuku(Buku buku) {
        System.out.println(nama + " mengembalikan buku berjudul: " + buku.getJudul());
    }

    public void displayInfo() {
        System.out.println("Anggota: " + nama + " (ID: " + idAnggota + ")");
    }
}
