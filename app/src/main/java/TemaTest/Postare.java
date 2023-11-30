package TemaTest;

import java.util.ArrayList;

public class Postare {
    int id;
    int like;
    String text;
    ArrayList<String> comentariu;
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

    public void adaugaComentariu(String text) {
        comentariu.add(text);
    }
    public void stergereComentariu(String comId) {
        comentariu.remove(comId);
    }
}
