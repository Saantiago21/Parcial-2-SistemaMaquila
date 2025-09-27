package maquila;

public class Supervisor extends Empleado {
    private String departamento;
    private double bono;

    public Supervisor() { super(); }

    public Supervisor(int id, String nombre, int edad, double salario, String departamento, double bono) {
        super(id, nombre, edad, salario);
        this.departamento = departamento;
        this.bono = bono;
    }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public double getBono() { return bono; }
    public void setBono(double bono) { this.bono = bono; }

    @Override
    public String tipo() { return "Supervisor"; }

    @Override
    public String toFileString() {
        // Supervisor;id;nombre;edad;salario;departamento;bono
        return String.format("%s;%d;%s;%d;%.2f;%s;%.2f",
                tipo(), getId(), getNombre().replace(";", ","), getEdad(), getSalario(),
                departamento.replace(";", ","), bono);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.printf("Tipo: Supervisor | Departamento: %s | Bono: %.2f%n", departamento, bono);
    }
}
