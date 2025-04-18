public class Main {
    public static void main(String[] args) {
        // Membuat objek Pahlawan dan Musuh
        KarakterGame karakterUmum = new KarakterGame("Karakter Umum", 100);
        Pahlawan pahlawan = new Pahlawan("Brimstone", 150);
        Musuh musuh = new Musuh("Viper", 200);

        // Menampilkan status awal kesehatan karakter
        System.out.println("Status awal:");
        System.out.println(pahlawan.getNama() + " memiliki kesehatan: " + pahlawan.getKesehatan());
        System.out.println(musuh.getNama() + " memiliki kesehatan: " + musuh.getKesehatan());

        // Simulasi pertarungan
        pahlawan.serang(musuh); // Pahlawan menyerang musuh
        musuh.serang(pahlawan); // Musuh menyerang pahlawan
    }
}
