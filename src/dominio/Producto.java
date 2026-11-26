package dominio;

import excepciones.DatoInvalidoException;
import excepciones.StockInsuficienteException;
import java.io.Serializable;

public abstract class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int contadorProductos = 0;

    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String codigo, String nombre, double precio, int stock) {
        setCodigo(codigo);
        setNombre(nombre);  
        setPrecio(precio);
        setStock(stock);
        contadorProductos++;
    }

    public static int getContadorProductos() {
        return contadorProductos;
    }

    public static void setContadorProductos(int total){
        contadorProductos = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new DatoInvalidoException("El código del producto no puede estar vacío.");
        }
        this.codigo = codigo.trim().toUpperCase();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatoInvalidoException("El nombre del producto no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new DatoInvalidoException("El precio del producto debe ser un valor positivo.");
        }
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new DatoInvalidoException("El stock del producto no puede ser negativo.");
        }
        this.stock = stock;
    }

    public void aumentarStock(int cantidad) {
        if (cantidad <= 0) {
            throw new DatoInvalidoException("La cantidad a aumentar debe ser un valor positivo.");
        }
        this.stock += cantidad;
    }

    public void descontarStock(int cantidad) {
        if (cantidad <= 0) {
            throw new DatoInvalidoException("La cantidad a descontar debe ser un valor positivo.");
        }
        if (cantidad > this.stock) {
            throw new StockInsuficienteException("No hay suficiente stock para descontar la cantidad solicitada.");
        }
        this.stock -= cantidad;
    }

    //Nuestras operaciones polimórficas donde cada clase debe saber cómo responder

    public abstract boolean requiereReceta();
    public abstract CalculadoraImpuesto getCalculadoraImpuesto();
    public abstract String getCategoria();

    public double obtenerPrecioPorPresentacion(Presentacion presentacion) {
        return this.precio;
       
    }

    public double obtenerUnidadesPorPresentacion(Presentacion presentacion) {
        return cantidad;
    }

    @Override 
    public String  toString(){
        return codigo + " - " + nombre + " ($" + String.format("%.2f", precio) + ")";
    }
}
