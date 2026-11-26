package excepciones;

public class FarmaciaException extends RuntimeException {
    public FarmaciaException(String message) {
        super(message);
    }

    public FarmaciaException(String message, Throwable cause) {
        super(message, cause);
    }

    
}
