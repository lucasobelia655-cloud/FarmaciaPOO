package excepciones;

public class ProductoCaducadoException extends FarmaciaException {
    public ProductoCaducadoException(String message) {
        super(message);
    }

    public ProductoCaducadoException(String message, Throwable cause) {
        super(message, cause);
    }
}
