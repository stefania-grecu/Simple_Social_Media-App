package TemaTest;

import java.util.ArrayList;

public class Utilizator {
    private String user, password;
    ArrayList<Postare> postare;
    ArrayList<String> urmareste;
    ArrayList<String> like;

    public Utilizator(String user, String password) {
        this.user = user;
        this.password = password;
        postare = new ArrayList<Postare>();
        urmareste = new ArrayList<String>();
        like = new ArrayList<String>();
    }
    public String getNume() {
        return user;
    }
    public String getPassword() {
        return password;
    }
    public void adaugaPostare(Postare post) {
        post.idPostare();
        postare.add(post);
    }
    public void adaugaUrmareste(String urm) {
        urmareste.add(urm);
    }
    public void stergereUrmareste(String urm) {
        urmareste.remove(urm);
    }
    public void adaugaLike (String likeId) {
        like.add(likeId);
    }
}