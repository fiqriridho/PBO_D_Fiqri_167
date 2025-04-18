// Superclass KarakterGame
class KarakterGame {
    private String nama; // Nama karakter
    private int kesehatan; // Kesehatan karakter

    // Constructor untuk inisialisasi nama dan kesehatan
    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    // Getter untuk mendapatkan nama karakter
    public String getNama() {
        return nama;
    }

    // Setter untuk mengubah nama karakter
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter untuk mendapatkan kesehatan karakter
    public int getKesehatan() {
        return kesehatan;
    }

    // Setter untuk mengubah kesehatan karakter
    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    // Method serang yang akan di-override oleh subclass
    public void serang(KarakterGame target) {
        // Method ini diisi oleh subclass
    }
}