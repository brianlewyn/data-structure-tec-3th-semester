# Bubble Sort

Bubble Sort es un algoritmo de ordenamiento simple basado en comparaciones. Recorre repetidamente la lista, compara elementos adyacentes y los intercambia si están en el orden incorrecto.

Se usa principalmente con fines educativos. En producción, es preferible usar Quick Sort o Merge Sort.

# ¿Cómo clonar el repositorio?

Guarda el proyecto en una carpeta de tu preferencia (ej. `Documents`). Luego, debes abrir la línea de comandos en esa ubicación y ejecutar los siguientes comandos. El primero sirve para clonar el repositorio, y el segundo es para entrar al proyecto.

```
git clone https://github.com/brianlewyn/data-structure-tec-3th-semester.git
cd data-structure-tec-3th-semester
```

# ¿Cómo compilar y ejecutar el proyecto?

El código corre usando la versión 27 de Java. Además, las siguientes líneas se deben ejecutar desde PowerShell. La primera línea es para compilar los archivos Java en archivos .class; la siguiente línea ejecuta esos archivos.

```powershell
javac .\Unidad5\BubbleSort\*.java
java Unidad5.BubbleSort.Main
```

Esto es lo que debería imprimir en consola:

```powershell

 ---------- Ejemplo de Clase ---------- 

Arreglo original: [6, 1, 5, 8, 3, 2, 7, 4]

Número de comparaciones: 25
Número de intercambios: 14

Arreglo ordenado: [1, 2, 3, 4, 5, 6, 7, 8]

 ---------- Mejor Caso ---------- 

Arreglo original: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Número de comparaciones: 9
Número de intercambios: 0

Arreglo ordenado: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

 ---------- Caso Promedio ---------- 

Arreglo original: [6, 1, 10, 5, 8, 3, 2, 9, 7, 4]

Número de comparaciones: 42
Número de intercambios: 23

Arreglo ordenado: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

 ---------- Peor Caso ---------- 

Arreglo original: [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]

Número de comparaciones: 45
Número de intercambios: 45

Arreglo ordenado: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
```