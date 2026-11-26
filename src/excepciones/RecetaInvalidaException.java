package excepciones;

public class RecetaInvalidaException extends FarmaciaException {
    public RecetaInvalidaException(String message) {
        super(message);
    }

    public RecetaInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }
}
