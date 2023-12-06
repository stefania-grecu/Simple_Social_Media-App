package TemaTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Postare implements Likeable{
    private final int id;
    String text, user;
    ArrayList<Comentariu> comentariu;
    ArrayList<String> like;
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date date = new Date();
    String currentDateAsString;
    public Postare(String text, int id, String user) {
        this.id = id;
        this.text = text;
        this.user = user;
        comentariu = new ArrayList<>();
        like = new ArrayList<>();
        currentDateAsString = dateFormat.format(date);
    }
    public int getId() {
        return id;
    }
    public void adaugaComentariu(Comentariu com) {
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
    public String getData() {
        return currentDateAsString;
    }
    public int getNrLike() {
        return like.size();
    }
    public int getNrCom() {
        return comentariu.size();
    }
}
