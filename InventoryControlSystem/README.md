# Sistema de Control de Inventario

## Integrantes del Equipo

- 257O00081 - Mejía Mora Brayan
- 257O01401 - Laura Irais Garcia Saavedra
- 257O01304 - Manuel Alejando Adrian Contreras

## Instrucciones de ejecución (basada en la versión java 27)

1. Abrir la terminal en la raíz de proyecto (la carpeta que contiene nombre `src`).

2. Compilar el paquete `InventoryControlSystem`:

```sh
javac InventoryControlSystem/*java
```

3. Ejecutar el paquete `InventoryControlSystem`:

```sh
java InventoryControlSystem.Main
```

## Descripción del proyecto

El proyecto está construido a partir de las siguientes clases:

```
InventoryControlSystem/
├── BinarySearchTree.java
├── ConsoleUI.java
├── Main.java
├── Node.java
├── Product.java
├── README.md
└── Project - InventoryControlSystem (Estructura de Datos).pdf
```

### Product

Modela un producto del inventario. Es la unidad de información que se almacena en el árbol. Contiene tres atributos públicos: `name` (nombre, usado como clave de ordenamiento), `stock` (cantidad disponible) y `price` (precio unitario).

Incluye dos métodos de presentación:
- `show()`: imprime el producto en una sola línea con formato de columnas alineadas (nombre, stock y precio). Se usa en el listado completo del inventario.
- `showDetails()`: imprime el producto en formato de ficha, con encabezado, nombre, stock y precio. Se usa al consultar un producto individual.

> **Responsabilidad:** representar los datos de un producto y saber cómo mostrarse.

---

### Node

Representa un nodo del árbol binario de búsqueda. Es una clase auxiliar que encapsula la estructura interna del árbol.

Contiene:
- `product`: referencia al `Product` almacenado en ese nodo.
- `left`: referencia al hijo izquierdo (productos con nombre menor).
- `right`: referencia al hijo derecho (productos con nombre mayor).

El constructor inicializa los hijos en `null`. Los atributos son públicos para que `BinarySearchTree` pueda manipular la estructura directamente.

> **Responsabilidad:** ser el eslabón que conecta los productos dentro del árbol.

---

### BinarySearchTree

Implementa el árbol binario de búsqueda (BST) que organiza el inventario. Es el núcleo lógico del sistema.

Operaciones principales:
- `insert(Product)`: inserta un producto ordenándolo por nombre. Si el nombre ya existe, actualiza `stock` y `price` en lugar de duplicar el nodo.
- `search(String)`: busca un producto por nombre y lo devuelve, o `null` si no existe.
- `delete(String)`: elimina un producto por nombre y **devuelve el producto eliminado** (o `null` si no existía). Maneja los tres casos clásicos de eliminación en un BST: nodo hoja, nodo con un hijo y nodo con dos hijos (usando el sucesor in-order).
- `isEmpty()`: indica si el árbol no tiene nodos.
- `show()`: recorre el árbol in-order (izquierda → raíz → derecha) para listar los productos en orden alfabético. Maneja el caso de inventario vacío.

Las operaciones recursivas se apoyan en métodos privados (`insertNode`, `searchNode`, `deleteNode`, `minorNode`, `showNode`) para mantener la API pública limpia y ocultar el manejo del `root`.

> **Responsabilidad:** implementar la estructura de datos y toda la lógica de inserción, búsqueda, eliminación y recorrido.

---

### ConsoleUI

Encapsula toda la interacción con el usuario por consola: menús, lectura de datos y mensajes. Su objetivo es que `Main` no se contamine con detalles de presentación.

Responsabilidades:
- **Menú:** `showMenu()` presenta las opciones y `readOption()` lee y normaliza la opción elegida.
- **Lectura de datos:** `readNewProduct()` solicita nombre, stock y precio para crear un `Product`; `readProductName(actionLabel)` solicita un nombre con un encabezado contextual.
- **Validación de entrada:** `readInt()` y `readDouble()` reintentan si el usuario ingresa un valor no numérico, evitando que el programa se cierre por una `NumberFormatException`.
- **Mensajes:** `printNotFound()`, `printDeleted()`, `printInvalidOption()`, `printGoodbye()` y `printHeader()` centralizan los textos mostrados al usuario.

Mantiene un `Scanner` compartido, inyectado desde `Main` por constructor.

> **Responsabilidad:** ser la única clase que habla con el usuario (entrada y salida por consola).

---

### Main

Punto de entrada del sistema y orquestador del flujo principal. No contiene lógica de negocio ni de presentación: solo **decide qué hacer** según la opción del usuario.

Flujo:
1. Crea una instancia de `BinarySearchTree` (el inventario), un `Scanner` y un `ConsoleUI`.
2. En un bucle `do-while`, muestra el menú, lee la opción y ejecuta la acción correspondiente mediante un `switch`:
   - `a` → lee un producto y lo inserta en el árbol.
   - `b` → busca un producto por nombre y muestra sus detalles o un mensaje de "no encontrado".
   - `c` → elimina un producto y muestra el producto eliminado o un mensaje de "no encontrado".
   - `d` → muestra el inventario completo.
   - `e` → imprime mensaje de despedida y sale del bucle.
   - `default` → notifica opción inválida.
3. Cierra el `Scanner` al finalizar.

> **Responsabilidad:** coordinar el ciclo de vida de la aplicación conectando la UI con la estructura de datos.