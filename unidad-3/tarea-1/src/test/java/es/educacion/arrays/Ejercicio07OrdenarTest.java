package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio07OrdenarTest {
    @Test
    void desordenado() {
        assertArrayEquals(new int[]{1, 3, 5}, Ejercicio07Ordenar.ordenar(new int[]{5, 1, 3}));
    }

    @Test
    void negativosYRepetidos() {
        assertArrayEquals(new int[]{-4, -4, 0, 9}, Ejercicio07Ordenar.ordenar(new int[]{9, -4, 0, -4}));
    }

    @Test
    void yaOrdenado() {
        assertArrayEquals(new int[]{1, 2, 3}, Ejercicio07Ordenar.ordenar(new int[]{1, 2, 3}));
    }

    @Test
    void arrayVacio() {
        assertArrayEquals(new int[]{}, Ejercicio07Ordenar.ordenar(new int[]{}));
    }

    @Test
    void noModificaOriginal() {
        int[] entrada = {3, 1, 2}; int[] salida = Ejercicio07Ordenar.ordenar(entrada); assertArrayEquals(new int[]{3, 1, 2}, entrada); assertNotSame(entrada, salida);
    }

}
