package dominio;

import excepciones.DatoInvalidoException;
import excepciones.ProductoCaducadoException;
import java.time.LocalDate;

public abstract class Medicamento extends Producto {
    private static final long serialVersionUID = 1L;

    private String lote;
    private LocalDate fechaCaducidad;

    public Medicamento(String codigo, String nombre, double precio, int stock, String lote, LocalDate fechaCaducidad) {
        super(codigo, nombre, precio, stock);
        setLote(lote);
        setFechaCaducidad(fechaCaducidad);
    }
    
    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        if (lote == null || lote.trim().isEmpty()) {
            throw new DatoInvalidoException("El lote del medicamento no puede estar vacío.");
        }
        this.lote = lote.trim().toUpperCase();

    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        if(fechaCaducidad == null){
            throw new DatoInvalidoException("La fecha de caducidad del medicamento no puede ser nula.");
        }
        this.fechaCaducidad = fechaCaducidad;
    }

    public boolean estaCaducado() {
        return fechaCaducidad.isBefore(LocalDate.now());
    }

    public boolean proximoACaducar(int dias){
        LocalDate limite = LocalDate.now().plusDays(dias);
        return !estaCaducado() && !fechaCaducidad.isAfter(limite);
    }

    public void validarVigencia(){
        if(estaCaducado()){
            throw new ProductoCaducadoException("El medicamento " + getNombre() + " con lote " + getLote() + " ha caducado el" + fechaCaducidad + ".");
        }
    }

    @Override 

    public CalculadoraImpuesto getCalculadoraImpuesto() {
        return new ImpuestoTasaCero();
    }


}
