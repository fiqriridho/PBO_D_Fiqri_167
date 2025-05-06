package perpustakaan;

public class Fiksi extends Buku{
    private String genre;
    public Fiksi(String judul, String penulis, String genre) {
        super(judul, penulis);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public void displayInfo() {
        System.out.println("Buku Fiksi: " + getJudul() + " oleh " + getPenulis() + " (Genre: " + getGenre() + ")");
    }
}
