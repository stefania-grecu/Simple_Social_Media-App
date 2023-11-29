package TemaTest;

public class Utilizator {
    private String user, password;
    public Utilizator(String user, String password) {
        this.user = user;
        this.password = password;
    }
    public String getNume() {
        return user;
    }
    public String getPassword() {
        return password;
    }
}