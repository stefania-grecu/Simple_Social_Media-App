package TemaTest;

import java.util.ArrayList;

public class Utilizator {
    private String user, password;
    ArrayList<Postare> postare = new ArrayList<Postare>();

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
    public void adaugaPost(Postare post) {
        postare.add(post);
    }
}