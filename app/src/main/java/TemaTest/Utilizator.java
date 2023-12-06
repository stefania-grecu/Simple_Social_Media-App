package TemaTest;

import java.util.ArrayList;

public class Utilizator {
    private final String user;
    private final String password;
    ArrayList<Postare> postare;
    ArrayList<String> urmareste;
    ArrayList<String> likePostare, likeComentariu;
    ArrayList<Comentariu> comentariu;

    public Utilizator(String user, String password) {
        this.user = user;
        this.password = password;
        postare = new ArrayList<>();
        urmareste = new ArrayList<>();
        likePostare = new ArrayList<>();
        likeComentariu = new ArrayList<>();
        comentariu = new ArrayList<>();

    }
    public String getNume() {
        return user;
    }
//    public String getPassword() {
//        return password;
//    }
    public void adaugaPostare(Postare post) {
        postare.add(post);
    }
    public void stergerePostare(Postare post) {
        postare.remove(post);
    }
    public void adaugaUrmareste(String urm) {
        urmareste.add(urm);
    }
    public void stergereUrmareste(String urm) {
        urmareste.remove(urm);
    }
    public void adaugaLikePostare (String likeId) {
        likePostare.add(likeId);
    }
    public void stergereLikePostare (String likeId) {
        likePostare.remove(likeId);
    }
    public void adaugaComentariu (Comentariu com) {
        comentariu.add(com);
    }
    public void stergereComentariu (Comentariu com) {
        comentariu.remove(com);
    }
    public void adaugaLikeComentariu (String likeId) {
        likeComentariu.add(likeId);
    }
    public void stergereLikeComentariu (String likeId) {
        likeComentariu.remove(likeId);
    }
}