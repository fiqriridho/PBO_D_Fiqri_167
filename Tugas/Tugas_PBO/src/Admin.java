class Admin{
    private final String username = "Admin167";
    private final String password = "password167";

    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }
}

