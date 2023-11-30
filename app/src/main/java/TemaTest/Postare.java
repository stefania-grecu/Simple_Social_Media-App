package TemaTest;

public class Postare {
    int id;
    String text;
    public Postare(String text) {
        this.id = 0;
        this.text = text;
    }
    public int getId() {
        return id;
    }
    public void idPostare() {
        id++;
    }
}
