package TemaTest;

public class Postare {
    int id;
    boolean like;
    String text;
    public Postare(String text) {
        this.id = 0;
        this.like = false;
        this.text = text;
    }
    public int getId() {
        return id;
    }
    public void idPostare() {
        id++;
    }
}
