package TemaTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;

public class Comentariu implements Likeable {
    int id;
    String text, user;
    AbstractList<String> like;
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date date = new Date();
    String currentDateAsString;

    public Comentariu(String text, int id, String user) {
        this.text = text;
        this.id = id;
        this.user = user;
        like = new ArrayList<>();
        currentDateAsString = dateFormat.format(date);
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return currentDateAsString;
    }

    public String getUser() {
        return user;
    }

    public void adaugaLike(String user) {
        like.add(user);
    }

    public void stergeLike(String user) {
        like.remove(user);
    }
    public int getNrLike() {
        return like.size();
    }
}
