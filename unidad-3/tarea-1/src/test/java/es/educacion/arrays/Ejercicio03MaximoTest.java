package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio03MaximoTest {
    @Test
    void maximoEnMedio() {
        assertEquals(9, Ejercicio03Maximo.maximo(new int[]{1, 9, 4}));
    }

    @Test
    void todosNegativos() {
        assertEquals(-2, Ejercicio03Maximo.maximo(new int[]{-8, -2, -5}));
    }

    @Test
    void repetidos() {
        assertEquals(7, Ejercicio03Maximo.maximo(new int[]{7, 7, 3}));
    }

    @Test
    void unElemento() {
        assertEquals(42, Ejercicio03Maximo.maximo(new int[]{42}));
    }

    @Test
    void arrayVacio() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio03Maximo.maximo(new int[]{}));
    }

}
