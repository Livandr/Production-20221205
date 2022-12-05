package Exception;

public class NotPresentException extends RuntimeException{
    public NotPresentException(){
        super("Produit non présent dans le stock");
    }
}
