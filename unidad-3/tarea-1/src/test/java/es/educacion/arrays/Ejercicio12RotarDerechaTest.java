package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio12RotarDerechaTest {

    @Test void una(){assertArrayEquals(new int[]{4,1,2,3},Ejercicio12RotarDerecha.rotar(new int[]{1,2,3,4},1));}
    @Test void vueltas(){assertArrayEquals(new int[]{3,1,2},Ejercicio12RotarDerecha.rotar(new int[]{1,2,3},4));}
    @Test void cero(){assertArrayEquals(new int[]{1,2},Ejercicio12RotarDerecha.rotar(new int[]{1,2},0));}
    @Test void vacio(){assertArrayEquals(new int[]{},Ejercicio12RotarDerecha.rotar(new int[]{},17));}
    @Test void negativos(){assertThrows(IllegalArgumentException.class,()->Ejercicio12RotarDerecha.rotar(new int[]{1,2},-1));}

}
