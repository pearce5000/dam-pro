package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio08CopiarRangoTest {
    @Test
    void rangoIntermedio() {
        assertArrayEquals(new int[]{20, 30}, Ejercicio08CopiarRango.copiarRango(new int[]{10,20,30,40}, 1, 3));
    }

    @Test
    void rangoCompleto() {
        assertArrayEquals(new int[]{5, 6}, Ejercicio08CopiarRango.copiarRango(new int[]{5, 6}, 0, 2));
    }

    @Test
    void rangoVacio() {
        assertArrayEquals(new int[]{}, Ejercicio08CopiarRango.copiarRango(new int[]{5, 6}, 1, 1));
    }

    @Test
    void indiceNegativo() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio08CopiarRango.copiarRango(new int[]{5,6}, -1, 1));
    }

    @Test
    void finFueraDeRango() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio08CopiarRango.copiarRango(new int[]{5,6}, 0, 3));
    }

}
