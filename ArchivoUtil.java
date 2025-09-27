package maquila;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUtil {

    // Escribe una lista de líneas en un archivo (sobrescribe)
    public static void escribirTodo(String ruta, List<String> lineas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false))) {
            for (String l : lineas) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error escribirTodo: " + e.getMessage());
        }
    }

    // Añade una línea al final del archivo
    public static void appendLinea(String ruta, String linea) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true))) {
            bw.write(linea);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error appendLinea: " + e.getMessage());
        }
    }

    // Lee todo el archivo y devuelve lista de líneas
    public static List<String> leerLineas(String ruta) {
        List<String> lineas = new ArrayList<>();
        File f = new File(ruta);
        if (!f.exists()) return lineas;
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String s;
            while ((s = br.readLine()) != null) {
                if (!s.trim().isEmpty()) lineas.add(s);
            }
        } catch (IOException e) {
            System.out.println("Error leerLineas: " + e.getMessage());
        }
        return lineas;
    }
}
