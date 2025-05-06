package perpustakaan;

public class NonFiksi extends Buku{
    private String bidang;

    public NonFiksi(String judul, String penulis, String bidang) {
        super(judul, penulis);
        this.bidang = bidang;
    }

    public String getBidang() {
        return bidang;
    }

    @Override
    public void displayInfo() {
        System.out.println("Buku Non-Fiksi : " + getJudul() + " oleh " + getPenulis() + " (Bidang: " + getBidang() + ")");
        System.out.println();

    }
}
