package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio13FrecuenciaTest {

    @Test void repetidos(){assertEquals(3,Ejercicio13Frecuencia.frecuencia(new int[]{2,1,2,3,2},2));}
    @Test void ausente(){assertEquals(0,Ejercicio13Frecuencia.frecuencia(new int[]{1,2,3},9));}
    @Test void negativos(){assertEquals(2,Ejercicio13Frecuencia.frecuencia(new int[]{-1,0,-1},-1));}
    @Test void vacio(){assertEquals(0,Ejercicio13Frecuencia.frecuencia(new int[]{},4));}
    @Test void nulo(){assertThrows(IllegalArgumentException.class,()->Ejercicio13Frecuencia.frecuencia(null,1));}

}
