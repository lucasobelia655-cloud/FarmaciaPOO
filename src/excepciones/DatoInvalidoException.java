package excepciones;

public class DatoInvalidoException extends FarmaciaException {
    public DatoInvalidoException(String message) {
        super(message);
    }

    public DatoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
