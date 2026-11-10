package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio11ContarParesTest {

    @Test void mezcla(){assertEquals(3, Ejercicio11ContarPares.contarPares(new int[]{2,3,0,-4,7}));}
    @Test void ninguno(){assertEquals(0, Ejercicio11ContarPares.contarPares(new int[]{1,3,5}));}
    @Test void todos(){assertEquals(3, Ejercicio11ContarPares.contarPares(new int[]{-2,4,8}));}
    @Test void vacio(){assertEquals(0, Ejercicio11ContarPares.contarPares(new int[]{}));}
    @Test void nulo(){assertThrows(IllegalArgumentException.class,()->Ejercicio11ContarPares.contarPares(null));}

}
