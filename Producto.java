package maquila;

public class Producto {
    private int idProducto;
    private String nombre;
    private int cantidad;
    private double precioUnitario;

    public Producto() {}

    public Producto(int idProducto, String nombre, int cantidad, double precioUnitario) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }

    public String toFileString() {
        // Producto;id;nombre;cantidad;precio
        return String.format("Producto;%d;%s;%d;%.2f",
                idProducto, nombre.replace(";", ","), cantidad, precioUnitario);
    }

    public void mostrarInfo() {
        System.out.printf("ID:%d | Producto:%s | Cantidad:%d | Precio:%.2f%n",
                idProducto, nombre, cantidad, precioUnitario);
    }
}
