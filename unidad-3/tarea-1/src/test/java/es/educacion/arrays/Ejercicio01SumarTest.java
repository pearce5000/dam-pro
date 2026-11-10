package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio01SumarTest {
    @Test
    void sumaPositivos() {
        assertEquals(12, Ejercicio01Sumar.sumar(new int[]{2, 4, 6}));
    }

    @Test
    void sumaNegativos() {
        assertEquals(-8, Ejercicio01Sumar.sumar(new int[]{-3, -5}));
    }

    @Test
    void sumaMixtos() {
        assertEquals(0, Ejercicio01Sumar.sumar(new int[]{-7, 2, 5}));
    }

    @Test
    void arrayVacio() {
        assertEquals(0, Ejercicio01Sumar.sumar(new int[]{}));
    }

    @Test
    void arrayNulo() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio01Sumar.sumar(null));
    }

}
