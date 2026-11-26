package excepciones;

public class PagoInvalidoException extends FarmaciaException {
    public PagoInvalidoException(String message) {
        super(message);
    }

    public PagoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
