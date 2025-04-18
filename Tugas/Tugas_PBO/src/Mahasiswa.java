class Mahasiswa{
    private String nama, nim;

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }
    public boolean login(String inputNama, String inputPassword) {
        return inputNama.equals(nama) && inputPassword.equals(nim);
    }
    public void displayInfo(){
        System.out.println("Login Mahasiswa Berhasil");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }

}