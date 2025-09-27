package maquila;

import java.util.*;

public class CRUDProductos {
    private String ruta;

    public CRUDProductos(String ruta) {
        this.ruta = ruta;
        try { new java.io.File(ruta).createNewFile(); } catch (Exception e) {}
    }

    public List<Producto> leerProductos() {
        List<Producto> lista = new ArrayList<>();
        List<String> lineas = ArchivoUtil.leerLineas(ruta);
        for (String l : lineas) {
            String[] p = l.split(";", -1);
            if (p.length >= 5 && "Producto".equalsIgnoreCase(p[0])) {
                try {
                    int id = Integer.parseInt(p[1]);
                    String nombre = p[2];
                    int cantidad = Integer.parseInt(p[3]);
                    double precio = Double.parseDouble(p[4]);
                    lista.add(new Producto(id, nombre, cantidad, precio));
                } catch (NumberFormatException ex) {}
            }
        }
        return lista;
    }

    public void crearProducto(Producto pr) {
        ArchivoUtil.appendLinea(ruta, pr.toFileString());
    }

    public void guardarTodos(List<Producto> lista) {
        List<String> lineas = new ArrayList<>();
        for (Producto p : lista) lineas.add(p.toFileString());
        ArchivoUtil.escribirTodo(ruta, lineas);
    }

    public Producto buscarPorId(int id) {
        for (Producto p : leerProductos()) if (p.getIdProducto() == id) return p;
        return null;
    }

    public boolean eliminarPorId(int id) {
        List<Producto> todos = leerProductos();
        boolean removed = todos.removeIf(p -> p.getIdProducto() == id);
        if (removed) guardarTodos(todos);
        return removed;
    }
}
