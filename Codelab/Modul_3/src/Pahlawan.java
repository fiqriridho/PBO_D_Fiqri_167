// Subclass Pahlawan
class Pahlawan extends KarakterGame {
    // Constructor Pahlawan, memanggil constructor superclass
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    // Override method serang untuk memberikan efek serangan khas pahlawan
    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Orbital Strike!");
        target.setKesehatan(target.getKesehatan() - 20); // Mengurangi 20 kesehatan target
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}