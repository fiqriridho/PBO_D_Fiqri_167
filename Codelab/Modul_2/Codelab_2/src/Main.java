public class Main {

    static class RekeningBank {
        String nomorRekening, namaPemilik;
        Double saldo;

        public RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
            this.nomorRekening = nomorRekening;
            this.namaPemilik = namaPemilik;
            this.saldo = saldo;
        }
        void tampilkanInfo() {
            System.out.println("Nomor Rekening: " + nomorRekening);
            System.out.println("Nama Pemilik: " + namaPemilik);
            System.out.println("Saldo: Rp" + saldo);
        }

        public void setorUang(double jumlah) {
            saldo += jumlah;
            System.out.println(namaPemilik + " menabung Rp" + jumlah + ". Saldo sekarang: Rp" + saldo);
        }

        public void tarikUang(double jumlah) {
            if (saldo >= jumlah) {
                saldo -= jumlah;
                System.out.println(namaPemilik + " menarik Rp" + jumlah + ". Saldo sekarang: Rp" + saldo);
            } else {
                System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + saldo);
            }
        }
    }

    public static void main(String[] args) {
        RekeningBank rekening1 = new RekeningBank("202410370110167", "Fiqri", 1000000);
        RekeningBank rekening2 = new RekeningBank("202410703110999", "Anomali", 10000);

        rekening1.tampilkanInfo();
        System.out.println();
        rekening2.tampilkanInfo();
        System.out.println();

        rekening1.setorUang(700000);
        rekening2.setorUang(500000);
        System.out.println();

        rekening2.tarikUang(1700000);
        rekening1.tarikUang(50000);
        System.out.println();

        rekening1.tampilkanInfo();
        System.out.println();
        rekening2.tampilkanInfo();
    }
}
