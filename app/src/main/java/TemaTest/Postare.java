package TemaTest;

import java.util.ArrayList;

public class Postare {
    int id;
    String text;
    ArrayList<Comentariu> comentariu;
    ArrayList<String> like;
    public Postare(String text) {
        this.id = 0;
        this.text = text;
        comentariu = new ArrayList<>();
        like = new ArrayList<String>();
    }
    public int getId() {
        return id;
    }
    public void idPostare() {
        id++;
    }

    public void adaugaComentariu(Comentariu com) {
        com.idComentariu();
        comentariu.add(com);
    }
    public void stergereComentariu(Comentariu com) {
        comentariu.remove(com);
    }
    public void adaugaLike(String user) {
        like.add(user);
    }
    public void stergeLike(String user) {
        like.remove(user);
    }
}
