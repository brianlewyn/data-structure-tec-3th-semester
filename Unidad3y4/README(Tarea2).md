# Colas en Java: Estáticas y Dinámicas

Tres implementaciones de colas en Java, cada una en su propio paquete.

## Descripción de los paquetes

### 1. ColaEstatica
Implementación de una cola FIFO usando un arreglo de tamaño fijo. El índice `fin` solo avanza hacia adelante, por lo que no reutiliza los espacios liberados por `dequeue()`. Cuando `fin` llega al final del arreglo, la cola se reporta como llena aunque haya espacio libre al inicio.

### 2. ColaEstaticaCircular
Versión mejorada de la cola estática. Los índices `frente` y `fin` avanzan de forma circular con el operador `%`, reutilizando los espacios liberados por `dequeue()`. Usa una variable `tamaño` para distinguir entre cola llena y cola vacía.

### 3. ColaDinamica
Implementación con nodos enlazados. No tiene capacidad fija: crece y decrece según se necesite. Usa las referencias `frente` y `fin` para insertar y eliminar en O(1) sin desperdiciar memoria.

## Estructura de carpetas
```
Unidad3y4/
├── ColaEstatica/
│ ├── ColaEstatica.java
│ └── Main.java
│
├── ColaEstaticaCircular/
│ ├── ColaEstaticaCircular.java
│ └── Main.java
│
├── ColaDinamica/
│ ├── ColaDinamica.java
│ └── Main.java
│
└── PilaDinamica/
  └── Nodo.java
```

## Salidas esperadas

### ColaEstatica - 'Unidad3y4.ColaEstatica.Main'
```
>> Insertando 10, 20 y 30...
Entro a la fila: 10
Entro a la fila: 20
Entro a la fila: 30
Estado actual: Fila actual: 10 20 30 

>> Atendiendo un elemento...
Atendido y fuera: 10
Estado actual: Fila actual: 20 30 

>> Intentando insertar 40 (debería fallar)...
Error: La cola esta llena.
Estado actual: Fila actual: 20 30 

>> Atendiendo los elementos restantes...
Atendido y fuera: 20
Atendido y fuera: 30
Estado final: La cola esta vacia!
```

### ColaEstaticaCircular - 'Unidad3y4.ColaEstaticaCircular.Main'
```
Estado actual: Fila actual: 10 20 30 40 50 

>> Atendiendo dos elementos...
Atendido y fuera: 10
Atendido y fuera: 20
Estado actual: Fila actual: 30 40 50 

>> Insertando 60 y 70 (reutilizando espacio)...
Entro a la fila: 60
Entro a la fila: 70
Estado actual: Fila actual: 30 40 50 60 70 

>> Consultando el frente...
Valor al frente de la cola: 30

>> Vaciando la cola por completo...
Atendido y fuera: 30
Atendido y fuera: 40
Atendido y fuera: 50
Atendido y fuera: 60
Atendido y fuera: 70

Estado final: La cola esta vacia!
¿Está vacía? true
```

### ColaDinamica - 'Unidad3y4.ColaDinamica.Main'
```
>> Insertando 10, 20, 30, 40 y 50...
Estado actual: Frente -> [10] [20] [30] [40] [50]  <- Fin

>> Atendiendo dos elementos...
Atendido: 10
Atendido: 20
Estado actual: Frente -> [30] [40] [50]  <- Fin

>> Insertando 60 y 70...
Estado actual: Frente -> [30] [40] [50] [60] [70]  <- Fin

>> Consultando frente y tamaño...
Valor al frente de la cola: 30
Tamaño de la cola dinámica: 5

>> Vaciando la cola por completo...
Estado final: La cola esta vacia!
¿Está vacía? true
```
