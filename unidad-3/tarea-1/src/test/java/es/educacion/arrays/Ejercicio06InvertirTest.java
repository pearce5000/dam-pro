package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio06InvertirTest {
    @Test
    void tresElementos() {
        assertArrayEquals(new int[]{3, 2, 1}, Ejercicio06Invertir.invertir(new int[]{1, 2, 3}));
    }

    @Test
    void pares() {
        assertArrayEquals(new int[]{4, 3, 2, 1}, Ejercicio06Invertir.invertir(new int[]{1, 2, 3, 4}));
    }

    @Test
    void unElemento() {
        assertArrayEquals(new int[]{6}, Ejercicio06Invertir.invertir(new int[]{6}));
    }

    @Test
    void arrayVacio() {
        assertArrayEquals(new int[]{}, Ejercicio06Invertir.invertir(new int[]{}));
    }

    @Test
    void noModificaOriginal() {
        int[] entrada = {1, 2, 3}; int[] salida = Ejercicio06Invertir.invertir(entrada); assertArrayEquals(new int[]{1, 2, 3}, entrada); assertNotSame(entrada, salida);
    }

}
