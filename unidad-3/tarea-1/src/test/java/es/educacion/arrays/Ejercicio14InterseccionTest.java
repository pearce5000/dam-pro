package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio14InterseccionTest {

    @Test void comunes(){assertArrayEquals(new int[]{3,2},Ejercicio14Interseccion.interseccion(new int[]{3,1,2,3,2},new int[]{2,3,7}));}
    @Test void ninguno(){assertArrayEquals(new int[]{},Ejercicio14Interseccion.interseccion(new int[]{1},new int[]{2}));}
    @Test void vacios(){assertArrayEquals(new int[]{},Ejercicio14Interseccion.interseccion(new int[]{},new int[]{1,2}));}
    @Test void negativos(){assertArrayEquals(new int[]{-1,0},Ejercicio14Interseccion.interseccion(new int[]{-1,0,-1,8},new int[]{0,-1}));}
    @Test void nulo(){assertThrows(IllegalArgumentException.class,()->Ejercicio14Interseccion.interseccion(null,new int[]{1}));}

}
