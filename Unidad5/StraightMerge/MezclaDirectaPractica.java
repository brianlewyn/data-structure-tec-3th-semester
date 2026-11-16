package Unidad5.StraightMerge;

// ==============================================================================
// LIBRERIAS NATIVAS DE JAVA (Ya vienen incluidas, no hay que crearlas)
// ==============================================================================

import java.io.BufferedReader; // Sirve para leer archivos de texto linea por linea rapido
import java.io.FileReader;     // Abre la conexion de lectura hacia un archivo en el disco
import java.io.FileWriter;     // Abre la conexion de escritura hacia un archivo en el disco
import java.io.PrintWriter;    // Nos deja escribir texto con .println() directo en el archivo
import java.io.IOException;    // Atrapa errores si el archivo no existe o falla el disco

public class MezclaDirectaPractica {

    /**
     * Este metodo agarra dos archivos auxiliares (F1 y F2) que ya traen bloques
     * ordenados de tamano L, los va comparando frente a frente y los guarda
     * ya mezclados y ordenados en un archivo de salida.
     */
    public static void intercalarBloques(String archivoF1, String archivoF2, String archivoSalida, int L) {

        // El "try-with-resources" abre los 3 archivos y los cierra solito al terminar
        try (
            BufferedReader lector1 = new BufferedReader(new FileReader(archivoF1));
            BufferedReader lector2 = new BufferedReader(new FileReader(archivoF2));
            PrintWriter escritor = new PrintWriter(new FileWriter(archivoSalida))
        ) {
            // Leemos el primer numero de cada archivo (el frente de cada fila)
            String linea1 = lector1.readLine();
            String linea2 = lector2.readLine();

            // Contadores para llevar la cuenta de cuantos numeros hemos sacado del bloque L actual
            int elementosEscritos1 = 0;
            int elementosEscritos2 = 0;

            // CASO 1: Todavia quedan elementos por comparar en AMBOS bloques de tamano L
            while ((linea1 != null && elementosEscritos1 < L) && (linea2 != null && elementosEscritos2 < L)) {

                // Convertimos el texto leido del archivo a numero entero para poder compararlo
                int val1 = Integer.parseInt(linea1);
                int val2 = Integer.parseInt(linea2);

                // TODO 1: Escribe la condicion para saber si el numero de F1 es menor o igual al de F2
                if (val1 <= val2) {
                    escritor.println(val1);          // Guardamos el de F1 en la salida
                    linea1 = lector1.readLine();     // Avanzamos al siguiente numero de F1
                    elementosEscritos1++;            // Aumentamos el contador del bloque 1
                } else {
                    // TODO 2: Si el menor fue el de F2, haz exactamente lo mismo pero con F2
                    escritor.println(val2);
                    linea2 = lector2.readLine();
                    elementosEscritos2++;
                }

            }

            // CASO 2: El bloque de F2 ya se acabo (llego a L), asi que vaciamos lo que sobro de F1
            while (linea1 != null && elementosEscritos1 < L) {
                escritor.println(linea1);
                linea1 = lector1.readLine();
                elementosEscritos1++;
            }

            // CASO 3: El bloque de F1 ya se acabo primero, asi que vaciamos lo que sobro de F2
            while (linea2 != null && elementosEscritos2 < L) {
                escritor.println(linea2);
                linea2 = lector2.readLine();
                elementosEscritos2++;
            }

            System.out.println("Bloque intercalado con exito!");

        } catch (IOException e) {
            // Si no creaste f1.txt o f2.txt antes de correr el programa, caera aqui
            System.out.println("Error en E/S de archivos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Para probarlo: crea manualmente "f1.txt" y "f2.txt" en la carpeta de tu proyecto
        // con un numero por renglon, y corre el programa para ver como genera "f3.txt".
        String base = "./Unidad5/StraightMerge/";
        intercalarBloques(base+"f1.txt", base+"f2.txt", base+"f3.txt", 5);
    }
}

















