package TemaTest;

import java.util.ArrayList;

public class Postare {
    int id;
    int like;
    String text;
    ArrayList<Comentariu> comentariu;
    public Postare(String text) {
        this.id = 0;
        this.like = 0;
        this.text = text;
        comentariu = new ArrayList<>();
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
}
