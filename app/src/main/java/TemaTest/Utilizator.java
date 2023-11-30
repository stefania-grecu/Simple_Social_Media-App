package TemaTest;

import java.util.ArrayList;

public class Utilizator {
    private String user, password;
    ArrayList<Postare> postare;
    ArrayList<String> urmareste;

    public Utilizator(String user, String password) {
        this.user = user;
        this.password = password;
        postare = new ArrayList<Postare>();
        urmareste = new ArrayList<>();
    }
    public String getNume() {
        return user;
    }
    public String getPassword() {
        return password;
    }
    public void adaugaPostare(Postare post) {
        postare.add(post);
    }
    public void adaugaUrmareste(String urm) {
        urmareste.add(urm);
    }
}