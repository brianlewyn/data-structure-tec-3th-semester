# Straight Merge

# ¿Cómo clonar el repositorio?

Guarda el proyecto en una carpeta de tu preferencia (ej. `Documents`). Luego, debes abrir la línea de comandos en esa ubicación y ejecutar los siguientes comandos. El primero sirve para clonar el repositorio, y el segundo es para entrar al proyecto:

```
git clone https://github.com/brianlewyn/data-structure-tec-3th-semester.git
cd data-structure-tec-3th-semester
```

# ¿Cómo compilar y ejecutar el proyecto?

## Forma manual

El código corre usando la versión 27 de Java. Además, las siguientes líneas se deben ejecutar desde PowerShell. Desde la carpeta `data-structure-tec-3th-semester`, ejecuta lo siguiente: 

La primera línea es para compilar los archivos Java en archivos `.class`; la siguiente línea ejecuta esos archivos desde el archivo principal (ej. `MezclaDirectaPractica`):

```powershell
javac .\Unidad5\StraightMerge\MezclaDirectaPractica.java
java Unidad5.StraightMerge.MezclaDirectaPractica
```

## IDE IntelliJ

Crea un proyecto Java usando la versión 27 de Java. Copia dentro de la ruta `src` todo lo que hay dentro de la carpeta `data-structure-tec-3th-semester`, es decir, asegurate de que sea la ruta de esta forma: `src/Unidad5/StraightMerge/*` (el `*` es para hacer referencia a todo lo que haya en la carpeta `StraightMerge`).

Una vez hecho lo anterior, cambia el valor de la variable `base` con la ruta absoluta de la carpeta donde se encuentran los archivos `f1.txt` y `f2.txt`; si no haces esto, al ejectuar el archivo java `MezclaDirectaPractica`, en consola mostrará que no logro encontrar el archivo, esto ocurre porque IntelliJ compila archivos java y los guarda en la carpeta `out`; luego los ejecuta usando una ruta absoluta, como tu solo los tienes escritos con esa ruta, nunca lo encontrará.

Sigue está imagen para actualizar la variable `base`:
![Imagen de como escribir la varaible `base`](IDE.png)

## Resultados

Resultados en consola

```
Bloque intercalado con exito!
```

Resultados en el archivo `f3.txt`

```
10
20
30
40
50
60
70
80
90
100
```