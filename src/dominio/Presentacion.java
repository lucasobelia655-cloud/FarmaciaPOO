package dominio;

public class Presentacion {
    PIEZA("Pieza individual");
    EMPAQUE("Empaque cerrado");

    private final String descripcion;

    Presentacion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override 

    public String toString() {
        return descripcion;
    }
    
}
