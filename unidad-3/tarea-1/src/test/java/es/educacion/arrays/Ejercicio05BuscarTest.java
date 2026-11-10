package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio05BuscarTest {
    @Test
    void enPrimeraPosicion() {
        assertEquals(0, Ejercicio05Buscar.buscar(new int[]{7, 2, 5}, 7));
    }

    @Test
    void enUltimaPosicion() {
        assertEquals(2, Ejercicio05Buscar.buscar(new int[]{7, 2, 5}, 5));
    }

    @Test
    void noEncontrado() {
        assertEquals(-1, Ejercicio05Buscar.buscar(new int[]{7, 2, 5}, 9));
    }

    @Test
    void primeraAparicion() {
        assertEquals(1, Ejercicio05Buscar.buscar(new int[]{3, 8, 8, 9}, 8));
    }

    @Test
    void arrayVacio() {
        assertEquals(-1, Ejercicio05Buscar.buscar(new int[]{}, 1));
    }

}
