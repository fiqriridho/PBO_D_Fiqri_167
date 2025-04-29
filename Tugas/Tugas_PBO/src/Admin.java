public class Admin extends User{
    private final String username;
    private final String password;

//    constructor dari atribut class user
    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin Berhasil!");
        System.out.println("Nama : " + getNama());
        System.out.println("Nim : " + getNim());
    }
}

