public class Main {
    public static void main(String[] args) {
        Hewan hewan1 = new Hewan();
        hewan1.Nama = "Kucing";
        hewan1.Jenis = "Mamalia";
        hewan1.Suara = "Nyann~~";

        Hewan hewan2 = new Hewan();
        hewan2.Nama = "Anjing";
        hewan2.Jenis = "Mamalia";
        hewan2.Suara = "Woof-Woof!!";

        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();
    }
}