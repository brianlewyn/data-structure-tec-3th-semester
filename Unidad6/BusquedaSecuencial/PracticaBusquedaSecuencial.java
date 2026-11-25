package Unidad6.BusquedaSecuencial;

public class PracticaBusquedaSecuencial {

    public static int busquedaSecuencial(int[] arr, int clave) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == clave) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] calificaciones = {78, 92, 65, 88, 95, 70};

        int pos1 = busquedaSecuencial(calificaciones, 88);  // Esperado: 3
        int pos2 = busquedaSecuencial(calificaciones, 100); // Esperado: -1

        System.out.println("Posicion de 88: " + pos1);
        System.out.println("Posicion de 100: " + pos2);
    }

}