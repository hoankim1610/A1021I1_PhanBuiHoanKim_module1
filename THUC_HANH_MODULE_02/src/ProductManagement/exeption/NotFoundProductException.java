package ProductManagement.exeption;

public class NotFoundProductException extends Exception{
    public NotFoundProductException(String message) {
        super(message);
    }
}
