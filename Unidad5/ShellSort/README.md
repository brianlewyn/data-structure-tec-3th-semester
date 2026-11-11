# Shell Sort

Quick Sort es un algoritmo de ordenamiento altamente eficiente basado en divide y vencerás. Funciona seleccionando un elemento "pivote" y particionando el arreglo alrededor de él.

# ¿Cómo clonar el repositorio?

Guarda el proyecto en una carpeta de tu preferencia (ej. `Documents`). Luego, debes abrir la línea de comandos en esa ubicación y ejecutar los siguientes comandos. El primero sirve para clonar el repositorio, y el segundo es para entrar al proyecto:

```
git clone https://github.com/brianlewyn/data-structure-tec-3th-semester.git
cd data-structure-tec-3th-semester
```

# ¿Cómo compilar y ejecutar el proyecto?

El código corre usando la versión 27 de Java. Además, las siguientes líneas se deben ejecutar desde PowerShell. La primera línea es para compilar los archivos Java en archivos `.class`; la siguiente línea ejecuta esos archivos desde el archivo principal (ej. `Main`):

```powershell
javac .\Unidad5\ShellSort\*.java
java Unidad5.ShellSort.Main
```

Esto es lo que debería imprimir en consola:

```
======== Ejemplo de Arreglo de Clase (n=8) ========

Arreglo original: [6, 1, 5, 8, 3, 2, 7, 4]
Arreglo ordenado: [1, 2, 3, 4, 5, 6, 7, 8]

Comparaciones:       22
Intercambios:        8

======== Mejor Caso Teórico (n=10) ========

Arreglo original: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Arreglo ordenado: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Comparaciones:       22
Intercambios:        0

======== Caso Promedio (Muestra Aleatoria) (n=10) ========

Arreglo original: [7, 3, 9, 1, 5, 8, 2, 10, 4, 6]
Arreglo ordenado: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Comparaciones:       32
Intercambios:        15

======== Peor caso teórico (n=10) ========

Arreglo original: [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Arreglo ordenado: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Comparaciones:       27
Intercambios:        13

```