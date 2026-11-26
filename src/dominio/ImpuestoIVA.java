package dominio;
import modelo.ConfiguracionFarmacia;

public class ImpuestoIVA implements CalculadoraImpuesto {
    private static final long serialVersionUID = 1L;
    
    @Override
    public double calcular(double subtotal) {
        return subtotal * getTasa();
    }

    @Override
    public double getTasa() {
        return ConfiguracionFarmacia.TASA_IVA;
    }
}
