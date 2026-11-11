package Unidad5.ShellSort;

/**
 * Clase que implementa el algoritmo de ordenamiento Shellsort.
 * Es una optimizacion del ordenamiento por insercion que compara elementos
 * separados por intervalos (gaps) mayores a uno, reduciendolos progresivamente.
 */
public class ShellSort {

    // Contadores para medir la complejidad temporal
    public static long comparaciones = 0;
    public static long intercambios = 0;

    public static void reiniciarContadores() {
        comparaciones = 0;
        intercambios = 0;
    }

    /**
     * Ordena un arreglo de enteros de forma ascendente usando Shellsort.
     */
    public static void ordenar(int[] arr) {
        int n = arr.length;

        // 1. Reduccion del salto: Empieza en n/2 y se divide entre 2 en cada vuelta hasta 0
        for (int intervalo = n / 2; intervalo > 0; intervalo /= 2) {

            // 2. Recorrido tipo insercion pero saltando segun el 'intervalo' actual
            for (int i = intervalo; i < n; i++) {
                int temp = arr[i]; // Elemento que vamos a acomodar
                int j = i;

                while (j >= intervalo) {
                    comparaciones++;
                    if (arr[j - intervalo] > temp) {
                        arr[j] = arr[j - intervalo];
                        j -= intervalo;
                        intercambios++;
                    } else {
                        break;
                    }
                }

                // Insertamos el valor temporal en el hueco que quedo libre
                arr[j] = temp;
                // intercambios++;
            }
        }
    }

    public static void imprimirArreglo(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
