package Unidad1y2.Factorial;

import java.math.BigInteger;

// El tipo de dato BigInteger en Java no tiene un límite práctico establecido por el lenguaje. 
// Su única restricción real es la memoria disponible en tu computadora

public class Factorial {

    public static BigInteger factorial(int n) {
        // Caso base
        if (n < 1)
            return BigInteger.ONE;

        // Caso recursivo
        return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }

    public static void main(String[] args) {
        // El factorial de 35 no se puede realizar en tipo de dato como:
        // int que llegan hasta 2,147,483,647
        // long que llegan hasta 9,223,372,036,854,775,807
        // Para ello, implemente BigInteger para valores mucho más grandes.
        // 35! = 10,333,147,966,386,144,929,666,513,375,232,000,000,000

        System.out.println(factorial(35));
    }

}
