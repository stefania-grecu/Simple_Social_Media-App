package TemaTest;

public class Comentariu {
    int nrLike;
    int id;
    String text;
    public Comentariu(String text) {
        this.text = text;
        this.nrLike = 0;
        this.id = 0;
    }
    public void idComentariu() {
        id++;
    }
    public int getId() {
        return id;
    }
}
