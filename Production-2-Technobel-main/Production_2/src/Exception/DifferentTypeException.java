package Exception;

public class DifferentTypeException extends RuntimeException {
    public DifferentTypeException() {
        super("Ce produit ne peut pas être dans ce stock");
    }
}
