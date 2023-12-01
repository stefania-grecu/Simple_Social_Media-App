package TemaTest;

public class Comentariu {
    int id;
    String text;
    public Comentariu(String text) {
        this.text = text;
        this.id = 0;
    }
    public void idComentariu() {
        id++;
    }
    public int getId() {
        return id;
    }
}
