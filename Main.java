package maquila;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Ajusta rutas según tu proyecto. En NetBeans puedes poner la carpeta "data" en la raíz del proyecto
        String rutaEmpleados = "data/empleados.txt";
        String rutaProductos = "data/productos.txt";

        Scanner sc = new Scanner(System.in);
        Controlador ctrl = new Controlador(rutaEmpleados, rutaProductos, sc);

        int opc;
        do {
            System.out.println("===== SISTEMA MAQUILA =====");
            System.out.println("1. CRUD Empleados");
            System.out.println("2. CRUD Productos");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            try {
                opc = Integer.parseInt(sc.nextLine());
            } catch (Exception e) { opc = -1; }
            switch (opc) {
                case 1 -> menuEmpleados(ctrl, sc);
                case 2 -> menuProductos(ctrl, sc);
                case 3 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opc != 3);

        sc.close();
    }

    private static void menuEmpleados(Controlador ctrl, Scanner sc) {
        int op;
        do {
            System.out.println("=== Empleados ===");
            System.out.println("1. Crear");
            System.out.println("2. Listar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Volver");
            System.out.print("Opción: ");
            try { op = Integer.parseInt(sc.nextLine()); } catch (Exception e) { op = -1; }
            switch (op) {
                case 1 -> ctrl.crearEmpleadoMenu();
                case 2 -> ctrl.listarEmpleados();
                case 3 -> ctrl.actualizarEmpleadoMenu();
                case 4 -> ctrl.eliminarEmpleadoMenu();
                case 5 -> {}
                default -> System.out.println("Opción inválida.");
            }
        } while (op != 5);
    }

    private static void menuProductos(Controlador ctrl, Scanner sc) {
        int op;
        do {
            System.out.println("=== Productos ===");
            System.out.println("1. Crear");
            System.out.println("2. Listar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Volver");
            System.out.print("Opción: ");
            try { op = Integer.parseInt(sc.nextLine()); } catch (Exception e) { op = -1; }
            switch (op) {
                case 1 -> ctrl.crearProductoMenu();
                case 2 -> ctrl.listarProductos();
                case 3 -> ctrl.actualizarProductoMenu();
                case 4 -> ctrl.eliminarProductoMenu();
                case 5 -> {}
                default -> System.out.println("Opción inválida.");
            }
        } while (op != 5);
    }
}
