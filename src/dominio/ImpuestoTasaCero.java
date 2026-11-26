package dominio;

public class ImpuestoTasaCero implements CalculadoraImpuesto {
    private static final long serialVersionUID = 1L;
    
    @Override
    public double calcular(double subtotal) {
        return 0.0;
    }

    @Override
    public double getTasa() {
        return 0.0;
    }
}
