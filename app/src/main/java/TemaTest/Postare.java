package TemaTest;

public class Postare {
    int id;
    private static int idOld = 0;
    String text;
    public Postare(String text) {
        this.id = ++idOld;
        this.text = text;
    }
    public int getId() {
        return id;
    }
    public void idPostare() {
        id++;
    }
}
