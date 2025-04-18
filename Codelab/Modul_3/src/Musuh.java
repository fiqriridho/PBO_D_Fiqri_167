// Subclass Musuh
class Musuh extends KarakterGame {
    // Constructor Musuh, memanggil constructor superclass dari class KarakterGame
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    // Override method serang untuk memberikan efek serangan dari pihak musuh
    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan sihir!");
        target.setKesehatan(target.getKesehatan() - 15); // Mengurangi 15 kesehatan target
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}
