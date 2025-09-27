package maquila;

import java.util.List;
import java.util.Scanner;

public class Controlador {
    private CRUDEmpleados crudEmpleados;
    private CRUDProductos crudProductos;
    private Scanner sc;

    public Controlador(String rutaEmpleados, String rutaProductos, Scanner sc) {
        this.crudEmpleados = new CRUDEmpleados(rutaEmpleados);
        this.crudProductos = new CRUDProductos(rutaProductos);
        this.sc = sc;
    }

    // ******** Empleados ********
    public void crearEmpleadoMenu() {
        System.out.println("Crear empleado - Elija tipo: 1 Operario, 2 Supervisor, 3 Empleado simple");
        int tipo = leerInt();
        System.out.print("ID: "); int id = leerInt();
        System.out.print("Nombre: "); String nombre = sc.nextLine();
        System.out.print("Edad: "); int edad = leerInt();
        System.out.print("Salario: "); double salario = leerDouble();

        if (tipo == 1) {
            System.out.print("Linea de producción: "); String linea = sc.nextLine();
            System.out.print("Horas extras: "); int horas = leerInt();
            Operario o = new Operario(id, nombre, edad, salario, linea, horas);
            crudEmpleados.crearEmpleado(o);
        } else if (tipo == 2) {
            System.out.print("Departamento: "); String dept = sc.nextLine();
            System.out.print("Bono: "); double bono = leerDouble();
            Supervisor s = new Supervisor(id, nombre, edad, salario, dept, bono);
            crudEmpleados.crearEmpleado(s);
        } else {
            Empleado e = new Empleado(id, nombre, edad, salario);
            crudEmpleados.crearEmpleado(e);
        }
        System.out.println("Empleado creado correctamente.");
    }

    public void listarEmpleados() {
        List<Empleado> lista = crudEmpleados.leerEmpleados();
        if (lista.isEmpty()) System.out.println("No hay empleados registrados.");
        for (Empleado e : lista) e.mostrarInfo();
    }

    public void actualizarEmpleadoMenu() {
        System.out.print("Ingrese ID del empleado a actualizar: "); int id = leerInt();
        List<Empleado> lista = crudEmpleados.leerEmpleados();
        Empleado encontrado = null;
        for (Empleado e : lista) if (e.getId() == id) { encontrado = e; break; }
        if (encontrado == null) { System.out.println("No encontrado."); return; }

        System.out.println("Empleado encontrado:");
        encontrado.mostrarInfo();
        System.out.print("Nuevo nombre (enter para mantener): "); String nom = sc.nextLine();
        if (!nom.isEmpty()) encontrado.setNombre(nom);
        System.out.print("Nueva edad (0 para mantener): "); int ed = leerIntAllowEmpty();
        if (ed > 0) encontrado.setEdad(ed);
        System.out.print("Nuevo salario (0 para mantener): "); double sal = leerDoubleAllowEmpty();
        if (sal > 0) encontrado.setSalario(sal);

        // Si es Operario o Supervisor, pedir campos extra
        if (encontrado instanceof Operario) {
            Operario o = (Operario) encontrado;
            System.out.print("Nueva linea (enter para mantener): ");
            String lin = sc.nextLine();
            if (!lin.isEmpty()) o.setLineaProduccion(lin);
            System.out.print("Horas extras (negativo para mantener): ");
            int h = leerIntAllowEmpty();
            if (h >= 0) o.setHorasExtras(h);
        } else if (encontrado instanceof Supervisor) {
            Supervisor s = (Supervisor) encontrado;
            System.out.print("Nuevo departamento (enter para mantener): ");
            String d = sc.nextLine();
            if (!d.isEmpty()) s.setDepartamento(d);
            System.out.print("Nuevo bono (0 para mantener): ");
            double b = leerDoubleAllowEmpty();
            if (b > 0) s.setBono(b);
        }

        crudEmpleados.guardarTodos(lista);
        System.out.println("Empleado actualizado.");
    }

    public void eliminarEmpleadoMenu() {
        System.out.print("ID a eliminar: "); int id = leerInt();
        boolean ok = crudEmpleados.eliminarPorId(id);
        System.out.println(ok ? "Eliminado." : "No se encontró ID.");
    }

    // ******** Productos ********
    public void crearProductoMenu() {
        System.out.print("ID producto: "); int id = leerInt();
        System.out.print("Nombre producto: "); String nombre = sc.nextLine();
        System.out.print("Cantidad: "); int cantidad = leerInt();
        System.out.print("Precio unitario: "); double precio = leerDouble();
        Producto p = new Producto(id, nombre, cantidad, precio);
        crudProductos.crearProducto(p);
        System.out.println("Producto creado.");
    }

    public void listarProductos() {
        List<Producto> lp = crudProductos.leerProductos();
        if (lp.isEmpty()) System.out.println("No hay productos.");
        for (Producto p : lp) p.mostrarInfo();
    }

    public void actualizarProductoMenu() {
        System.out.print("ID producto a actualizar: "); int id = leerInt();
        List<Producto> lp = crudProductos.leerProductos();
        Producto encontrado = null;
        for (Producto p : lp) if (p.getIdProducto() == id) { encontrado = p; break; }
        if (encontrado == null) { System.out.println("No encontrado."); return; }

        System.out.print("Nuevo nombre (enter para mantener): "); String nombre = sc.nextLine();
        if (!nombre.isEmpty()) encontrado.setNombre(nombre);
        System.out.print("Nueva cantidad (-1 para mantener): "); int c = leerIntAllowEmpty();
        if (c >= 0) encontrado.setCantidad(c);
        System.out.print("Nuevo precio (0 para mantener): "); double pr = leerDoubleAllowEmpty();
        if (pr > 0) encontrado.setPrecioUnitario(pr);

        crudProductos.guardarTodos(lp);
        System.out.println("Producto actualizado.");
    }

    public void eliminarProductoMenu() {
        System.out.print("ID producto a eliminar: "); int id = leerInt();
        boolean ok = crudProductos.eliminarPorId(id);
        System.out.println(ok ? "Producto eliminado." : "ID no encontrado.");
    }

    // Lectura segura de enteros
    private int leerInt() {
        while (true) {
            try {
                String s = sc.nextLine();
                return Integer.parseInt(s.trim());
            } catch (Exception e) {
                System.out.print("Número inválido. Intente de nuevo: ");
            }
        }
    }

    // Permite entrada vacía (enter) devuelve -1 o 0 según contexto
    private int leerIntAllowEmpty() {
        try {
            String s = sc.nextLine();
            if (s.trim().isEmpty()) return -1;
            return Integer.parseInt(s.trim());
        } catch (Exception e) { return -1; }
    }

    private double leerDouble() {
        while (true) {
            try {
                String s = sc.nextLine();
                return Double.parseDouble(s.trim());
            } catch (Exception e) {
                System.out.print("Número inválido. Intente de nuevo: ");
            }
        }
    }

    private double leerDoubleAllowEmpty() {
        try {
            String s = sc.nextLine();
            if (s.trim().isEmpty()) return 0.0;
            return Double.parseDouble(s.trim());
        } catch (Exception e) { return 0.0; }
    }
}
