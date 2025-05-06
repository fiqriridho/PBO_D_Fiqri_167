package app;

import perpustakaan.*;
public class Main {
    public static void main(String[] args) {
        Buku buku = new Fiksi("Si Kancil", "Fatiharifah", "fabel");
        Buku buku1 = new NonFiksi("Laut Bercerita", "Leila S", "historical fiction");


        buku.displayInfo();
        buku1.displayInfo();

        Anggota anggota = new Anggota("Fiqri", "D167");
        Anggota anggota1 = new Anggota("Dimas", "D152");

        anggota.displayInfo();
        anggota1.displayInfo();
        System.out.println();

        anggota.pinjamBuku(buku);
        anggota1.pinjamBuku(buku1, 9);

        anggota.kembalikanBuku(buku);
        anggota1.kembalikanBuku(buku1);
    }
}