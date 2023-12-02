package TemaTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comentariu {
    int id;
    String text, user;
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date date = new Date();
    String currentDateAsString;
    public Comentariu(String text, int id, String user) {
        this.text = text;
        this.id = id;
        this.user = user;
        currentDateAsString = dateFormat.format(date);
    }
    public int getId() {
        return id;
    }
    public String getData() {
        return currentDateAsString;
    }
}
