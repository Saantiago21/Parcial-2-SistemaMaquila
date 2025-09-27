# Sistema de Gestión de Maquila

## Descripción del Proyecto
Este proyecto es un sistema de gestión para una maquila, desarrollado en **Java**, que permite manejar información de empleados, productos y operaciones internas de la empresa.  
Se implementan funcionalidades de **CRUD** para empleados y productos, así como la gestión de operarios y supervisores.

El proyecto incluye:
- Gestión de empleados: alta, baja, modificación y consulta de datos.  
- Gestión de productos: alta, baja, modificación y consulta de inventario.  
- Control de operarios y supervisores, diferenciando roles y permisos.  
- Almacenamiento de información en archivos de texto plano mediante la clase `ArchivoUtil`.  
- Registro de operaciones y actualización automática de datos persistentes.  

---

## Estructura del Proyecto
- `ArchivoUtil.java` → Clase para leer, escribir y agregar líneas en archivos de texto, facilitando la persistencia de datos.  
- `Controlador.java` → Clase principal de control de flujo y coordinación entre las operaciones del sistema.  
- `CRUDEmpleados.java` → Funcionalidades de alta, baja, modificación y consulta de empleados.  
- `CRUDProductos.java` → Funcionalidades de alta, baja, modificación y consulta de productos.  
- `Empleado.java` → Clase que representa a un empleado con sus atributos y métodos relacionados.  
- `Operario.java` → Subclase de `Empleado` para empleados con rol operativo.  
- `Supervisor.java` → Subclase de `Empleado` para supervisores con permisos especiales.  
- `Producto.java` → Clase que representa un producto con sus atributos y métodos.  
- `Main.java` → Clase principal que inicia la aplicación y permite interacción con el usuario.

---

## Tecnologías Utilizadas
- Java → Lenguaje de programación principal.  
- Archivos de texto → Persistencia de datos mediante lectura y escritura de archivos planos (`.txt`).  
- Programación orientada a objetos → Uso de clases, herencia y encapsulamiento para modelar empleados y productos.

---

## Instalación y Uso

### 1. Compilar el Proyecto
En la terminal o IDE de Java, ubicarse en la carpeta raíz del proyecto y ejecutar:

```bash
javac *.java
```

### 2. Ejecutar el Proyecto
```bash
java Main
```

### 3. Uso del Sistema
- **Gestión de empleados**: crear, modificar, eliminar y consultar empleados.  
- **Gestión de productos**: crear, modificar, eliminar y consultar productos.  
- **Roles diferenciados**: operarios y supervisores tienen permisos específicos.  
- Todos los cambios se guardan automáticamente en archivos de texto para mantener persistencia.

---

## Autor
Proyecto desarrollado por Jeremias Otzoy, para fines educativos y como ejercicio de programación orientada a objetos en Java.
