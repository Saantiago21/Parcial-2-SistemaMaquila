package maquila;

public class Operario extends Empleado {
    private String lineaProduccion;
    private int horasExtras;

    public Operario() { super(); }

    public Operario(int id, String nombre, int edad, double salario, String lineaProduccion, int horasExtras) {
        super(id, nombre, edad, salario);
        this.lineaProduccion = lineaProduccion;
        this.horasExtras = horasExtras;
    }

    public String getLineaProduccion() { return lineaProduccion; }
    public void setLineaProduccion(String lineaProduccion) { this.lineaProduccion = lineaProduccion; }

    public int getHorasExtras() { return horasExtras; }
    public void setHorasExtras(int horasExtras) { this.horasExtras = horasExtras; }

    @Override
    public String tipo() { return "Operario"; }

    @Override
    public String toFileString() {
        // Operario;id;nombre;edad;salario;lineaProduccion;horasExtras
        return String.format("%s;%d;%s;%d;%.2f;%s;%d",
                tipo(), getId(), getNombre().replace(";", ","), getEdad(), getSalario(),
                lineaProduccion.replace(";", ","), horasExtras);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.printf("Tipo: Operario | Línea: %s | Horas extras: %d%n", lineaProduccion, horasExtras);
    }
}
