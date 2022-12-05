package Exception;

public class NotNegativeException extends RuntimeException{
    public NotNegativeException(){
        super("Ne peut être négatif");
    }
}
