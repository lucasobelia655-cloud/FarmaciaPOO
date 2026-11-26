package dominio;
import java.io.Serializable;

public interface CalculadoraImpuesto extends Serializable {
    double calcular(double subtotal);
    double getTasa();
}
