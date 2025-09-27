package maquila;

public class Empleado {
    private int id;
    private String nombre;
    private int edad;
    private double salario;

    public Empleado() {}

    public Empleado(int id, String nombre, int edad, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    // Getters y setters (encapsulamiento)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    // Método que se sobrescribirá en las subclases (polimorfismo)
    public String tipo() {
        return "Empleado";
    }

    // Representación en línea para guardar en archivo (CSV simple)
    public String toFileString() {
        // Formato general: Empleado;id;nombre;edad;salario;campoExtra1;campoExtra2
        return String.format("%s;%d;%s;%d;%.2f;;", tipo(), id, nombre.replace(";", ","), edad, salario);
    }

    public void mostrarInfo() {
        System.out.printf("ID:%d | %s | Edad:%d | Salario:%.2f%n", id, nombre, edad, salario);
    }
}
