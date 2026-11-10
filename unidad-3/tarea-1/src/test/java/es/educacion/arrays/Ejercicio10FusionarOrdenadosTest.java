package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio10FusionarOrdenadosTest {
    @Test
    void intercalados() {
        assertArrayEquals(new int[]{1,2,3,4,5}, Ejercicio10FusionarOrdenados.fusionar(new int[]{1,3,5}, new int[]{2,4}));
    }

    @Test
    void conRepetidos() {
        assertArrayEquals(new int[]{1,2,2,2,3}, Ejercicio10FusionarOrdenados.fusionar(new int[]{1,2,2}, new int[]{2,3}));
    }

    @Test
    void primeroVacio() {
        assertArrayEquals(new int[]{3,4}, Ejercicio10FusionarOrdenados.fusionar(new int[]{}, new int[]{3,4}));
    }

    @Test
    void ambosVacios() {
        assertArrayEquals(new int[]{}, Ejercicio10FusionarOrdenados.fusionar(new int[]{}, new int[]{}));
    }

    @Test
    void negativos() {
        assertArrayEquals(new int[]{-5,-3,-2,0,4}, Ejercicio10FusionarOrdenados.fusionar(new int[]{-5,-2,4}, new int[]{-3,0}));
    }

}
