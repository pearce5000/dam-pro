package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio09EliminarDuplicadosTest {
    @Test
    void repetidosIntercalados() {
        assertArrayEquals(new int[]{2, 1, 3}, Ejercicio09EliminarDuplicados.sinDuplicados(new int[]{2,1,2,3,1}));
    }

    @Test
    void todosIguales() {
        assertArrayEquals(new int[]{4}, Ejercicio09EliminarDuplicados.sinDuplicados(new int[]{4,4,4}));
    }

    @Test
    void sinDuplicados() {
        assertArrayEquals(new int[]{1,2,3}, Ejercicio09EliminarDuplicados.sinDuplicados(new int[]{1,2,3}));
    }

    @Test
    void arrayVacio() {
        assertArrayEquals(new int[]{}, Ejercicio09EliminarDuplicados.sinDuplicados(new int[]{}));
    }

    @Test
    void negativosYCero() {
        assertArrayEquals(new int[]{0,-1,2}, Ejercicio09EliminarDuplicados.sinDuplicados(new int[]{0,-1,0,2,-1}));
    }

}
