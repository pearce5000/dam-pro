package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio02MediaTest {
    @Test
    void mediaEntera() {
        assertEquals(6.0, Ejercicio02Media.media(new int[]{4, 6, 8}), 1e-9);
    }

    @Test
    void mediaDecimal() {
        assertEquals(7.5, Ejercicio02Media.media(new int[]{7, 8}), 1e-9);
    }

    @Test
    void unElemento() {
        assertEquals(10.0, Ejercicio02Media.media(new int[]{10}), 1e-9);
    }

    @Test
    void arrayVacio() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio02Media.media(new int[]{}));
    }

    @Test
    void arrayNulo() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio02Media.media(null));
    }

}
