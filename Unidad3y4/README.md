# 📚 Pilas en Java: Estática y Dinámica

Este proyecto contiene dos implementaciones clásicas del **Tipo de Dato Abstracto (TAD) Pila** en Java, usando el principio **LIFO** (*Last In, First Out* — el último en entrar es el primero en salir):

- **`PilaSimple`** → Pila **estática** (almacenamiento contiguo en memoria).
- **`PilaDinamica`** → Pila **dinámica** (almacenamiento por nodos enlazados).

Ambas implementaciones se encuentran dentro del paquete `Unidad3y4` y comparten la misma interfaz de operaciones: `push`, `pop`, `peek`, `show`, `isEmpty` (y `isFull` solo en la estática).

---

## 🧠 1. Estructura y diferencias conceptuales

### 🔹 Pila Estática (almacenamiento contiguo en memoria)

Se implementa sobre un **arreglo de tamaño fijo** (`int[] datos = new int[5]`). Todos los elementos viven en **posiciones contiguas** de memoria y se accede a ellos mediante un **índice** llamado `tope`.

- **Ventajas:**
  - Acceso rápido (O(1)) a cualquier posición.
  - Uso de memoria predecible y sencillo.
- **Desventajas:**
  - Tamaño **fijo**: si se llena, ocurre **overflow**.
  - Si se dimensiona muy grande, se desperdicia memoria.

```
Índice:   0    1    2    3    4
        +----+----+----+----+----+
datos:  | 10 | 20 | 30 |    |    |
        +----+----+----+----+----+
                       ^
                     tope = 2
```

### 🔹 Pila Dinámica (nodos enlazados)

Se implementa con **nodos** dispersos en memoria (no contiguos). Cada nodo guarda un `dato` y una **referencia** (`siguiente`) al nodo que está debajo. Solo se mantiene una referencia llamada `cima`.

- **Ventajas:**
  - **Crece dinámicamente** mientras haya memoria disponible (no hay overflow práctico).
  - Uso eficiente de memoria (se reserva nodo por nodo).
- **Desventajas:**
  - Mayor consumo por nodo (dato + referencia).
  - **No** permite acceso aleatorio: solo recorrido secuencial.

```
cima
  |
  v
+------+------+    +------+------+    +------+------+
|  30  |  o---+--> |  20  |  o---+--> |  10  | null |
+------+------+    +------+------+    +------+------+
```

### 📊 Tabla comparativa

| Característica        | Pila Estática          | Pila Dinámica              |
|-----------------------|------------------------|----------------------------|
| Base de almacenamiento| Arreglo contiguo       | Nodos enlazados            |
| Capacidad             | Fija (ej. 5)           | Ilimitada (según memoria)  |
| Referencia de control | `int tope`             | `Nodo cima`                |
| Overflow              | Sí (arreglo lleno)     | No aplica                  |
| Underflow             | Sí (`tope == -1`)      | Sí (`cima == null`)        |
| Acceso aleatorio      | Sí (`datos[i]`)        | No (solo secuencial)       |
| Complejidad push/pop  | O(1)                   | O(1)                       |

---

## ⚙️ 2. Compilación y ejecución

### 📁 Estructura de carpetas esperada

```
Unidad3y4/
├── PilaSimple/
│   ├── Main.java
│   └── PilaSimple.java
└── PilaDinamica/
    ├── Main.java
    ├── Nodo.java
    └── PilaDinamica.java
```

### 🖥️ Opción A — Desde la terminal

1. Abrir la terminal en la **raíz del proyecto** (la carpeta que contiene `Unidad3y4/`).
2. Compilar **ambos paquetes**:

   ```bash
   javac Unidad3y4/PilaSimple/*.java
   javac Unidad3y4/PilaDinamica/*.java
   ```

3. Ejecutar la **pila estática**:

   ```bash
   java Unidad3y4.PilaSimple.Main
   ```

4. Ejecutar la **pila dinámica**:

   ```bash
   java Unidad3y4.PilaDinamica.Main
   ```

> 💡 Nota: si usas Windows y el comando `javac` no es reconocido, verifica que el JDK esté en el `PATH` o usa la ruta completa, por ejemplo: `"C:\Program Files\Java\jdk-XX\bin\javac"`.

### 🧩 Opción B — Desde un IDE (IntelliJ IDEA, Eclipse, VS Code, NetBeans)

1. Abrir el proyecto en el IDE.
2. Verificar que el **JDK** esté configurado (Java 8 o superior).
3. Localizar la clase `Main` dentro del paquete `Unidad3y4.PilaSimple` y hacer clic derecho → **Run 'Main'**.
4. Repetir con `Main` dentro del paquete `Unidad3y4.PilaDinamica`.

---

## 🧪 3. Ejemplos de ejecución

### 🔸 3.1 Pila Estática — `Unidad3y4.PilaSimple.Main`

Salida por consola (texto plano):

```text
=== Estado inicial ===
¿Esta vacia? true
¿Esta llena? false
Pila estatica (Fondo -> Cima): [VACIA]

=== Peek con pila vacia ===
Pila vacia! No hay cima que consultar.

=== Pop con pila vacia ===
Pila vacia! No se puede sacar.

=== Insertando elementos ===
Metiste: 10
Metiste: 20
Metiste: 30
Metiste: 40
Metiste: 50
Pila estatica (Fondo -> Cima): 10 20 30 40 50 

=== Verificando pila llena ===
¿Esta llena? true

=== Intentando push en pila llena ===
Pila llena! No se pudo insertar: 60

=== Peek en la cima ===
Consultaste: 50

=== Sacando elementos ===
Sacaste: 50
Sacaste: 40
Pila estatica (Fondo -> Cima): 10 20 30 

=== Vaciar la pila por completo ===
Sacaste: 30
Sacaste: 20
Sacaste: 10
¿Esta vacia? true
Pila estatica (Fondo -> Cima): [VACIA]

=== Pop en pila vacia ===
Pila vacia! No se puede sacar.
```

### 🔸 3.2 Pila Dinámica — `Unidad3y4.PilaDinamica.Main`

Salida por consola (texto plano):

```text
=== ESTADO INICIAL ===
¿Esta vacia? true
Pila Dinamica (Cima -> Fondo): [VACIA]

=== PEEK CON PILA VACIA ===
Pila dinamica vacia! No hay cima que consultar.

=== POP CON PILA VACIA ===
Pila dinamica vacia! No se puede sacar.

=== INSERTANDO ELEMENTOS (PUSH) ===
Pila Dinamica (Cima -> Fondo): 50 40 30 20 10 

=== PEEK EN LA CIMA ===
Consultaste: 50

=== SACANDO ELEMENTOS (POP) ===
Sacaste de la pila: 50
Sacaste de la pila: 40
Pila Dinamica (Cima -> Fondo): 30 20 10 

=== VACIANDO LA PILA ===
Sacaste de la pila: 30
Sacaste de la pila: 20
Sacaste de la pila: 10

=== VERIFICANDO ESTADO FINAL ===
¿Esta vacia? true
Pila Dinamica (Cima -> Fondo): [VACIA]

=== POP EN PILA VACIA ===
Pila dinamica vacia! No se puede sacar.
```

---

## 🧭 4. Conclusión

- La **pila estática** es ideal cuando se conoce de antemano el número máximo de elementos y se busca eficiencia en memoria y acceso.
- La **pila dinámica** es preferible cuando el número de elementos es variable o desconocido, sacrificando un poco de memoria por nodo a cambio de flexibilidad total.
- Ambas comparten la misma interfaz (`push`, `pop`, `peek`, `show`, `isEmpty`), lo que demuestra el poder de la **abstracción** en estructuras de datos.
