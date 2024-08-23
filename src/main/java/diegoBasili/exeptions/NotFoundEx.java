package diegoBasili.exeptions;

public class NotFoundEx extends RuntimeException {
    public NotFoundEx(int id) {
        super("l'elemento con id " + id + " non è stato trovato");
    }
}
