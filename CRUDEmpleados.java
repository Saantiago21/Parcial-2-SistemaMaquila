package maquila;

import java.util.*;
import java.io.*;

public class CRUDEmpleados {
    private String rutaArchivo;

    public CRUDEmpleados(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        // crea el archivo si no existe
        try {
            new File(rutaArchivo).createNewFile();
        } catch (IOException e) { /* no crítico */ }
    }

    // Leer todos los empleados del archivo
    public List<Empleado> leerEmpleados() {
        List<Empleado> lista = new ArrayList<>();
        List<String> lineas = ArchivoUtil.leerLineas(rutaArchivo);
        for (String ln : lineas) {
            // Formato: Tipo;id;nombre;edad;salario;campoA;campoB
            String[] parts = ln.split(";", -1);
            if (parts.length < 5) continue;
            String tipo = parts[0];
            try {
                int id = Integer.parseInt(parts[1]);
                String nombre = parts[2];
                int edad = Integer.parseInt(parts[3]);
                double salario = Double.parseDouble(parts[4]);

                if ("Operario".equalsIgnoreCase(tipo)) {
                    String lineaProd = parts.length > 5 ? parts[5] : "";
                    int horas = parts.length > 6 && !parts[6].isEmpty() ? Integer.parseInt(parts[6]) : 0;
                    Operario o = new Operario(id, nombre, edad, salario, lineaProd, horas);
                    lista.add(o);
                } else if ("Supervisor".equalsIgnoreCase(tipo)) {
                    String dept = parts.length > 5 ? parts[5] : "";
                    double bono = parts.length > 6 && !parts[6].isEmpty() ? Double.parseDouble(parts[6]) : 0.0;
                    Supervisor s = new Supervisor(id, nombre, edad, salario, dept, bono);
                    lista.add(s);
                } else {
                    Empleado e = new Empleado(id, nombre, edad, salario);
                    lista.add(e);
                }
            } catch (NumberFormatException ex) {
                // salto de línea mal formada
            }
        }
        return lista;
    }

    // Guardar (append) un empleado al archivo
    public void crearEmpleado(Empleado e) {
        ArchivoUtil.appendLinea(rutaArchivo, e.toFileString());
    }

    // Actualizar: recibir lista actualizada y reescribir archivo
    public void guardarTodos(List<Empleado> lista) {
        List<String> lineas = new ArrayList<>();
        for (Empleado e : lista) lineas.add(e.toFileString());
        ArchivoUtil.escribirTodo(rutaArchivo, lineas);
    }

    // Buscar por id
    public Empleado buscarPorId(int id) {
        for (Empleado e : leerEmpleados()) if (e.getId() == id) return e;
        return null;
    }

    // Eliminar por id
    public boolean eliminarPorId(int id) {
        List<Empleado> todos = leerEmpleados();
        boolean removed = todos.removeIf(e -> e.getId() == id);
        if (removed) guardarTodos(todos);
        return removed;
    }
}
