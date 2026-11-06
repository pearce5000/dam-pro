# TAREA 7 — Algoritmos de fechas y horas en Java

**Unidad 2 · Java 21 · Maven · JUnit 5 · API java.time**

## Objetivo

Implementar diez algoritmos independientes para crear, interpretar, transformar y comparar fechas y horas en Java. La práctica desarrolla también documentación técnica con JavaDoc. **Cada algoritmo es una clase diferente** y deberá respetar exactamente su firma pública. Referencia teórica: https://codelearnacademy.github.io/java/leccion02/16-fechas/

## Rúbrica (10 puntos)

Cada algoritmo vale **1,00 punto**: **0,80** por 12 pruebas funcionales independientes y **0,20** por documentación JavaDoc. Total: **120 pruebas = 8,00 puntos**; JavaDoc = **2,00 puntos**. Cada prueba correcta suma 0,80/12 puntos para su clase. Los criterios de JavaDoc tienen el mismo valor dentro de cada clase: `@author`, `@version`, `@param` de cada parámetro, `@return`, y descripción sustantiva de clase y método. La valoración automática verifica presencia y ubicación; el profesor revisará el contenido.

| Algoritmo | Clase | Funcionalidad | JavaDoc | Total |
|---:|---|---:|---:|---:|
| 1 | `AnalizadorFecha` | 0,80 | 0,20 | **1,00** |
| 2 | `CalculadoraEdad` | 0,80 | 0,20 | **1,00** |
| 3 | `CalculadoraVencimientos` | 0,80 | 0,20 | **1,00** |
| 4 | `ValidadorFechas` | 0,80 | 0,20 | **1,00** |
| 5 | `CuentaAtrasEvento` | 0,80 | 0,20 | **1,00** |
| 6 | `CalculadoraJornada` | 0,80 | 0,20 | **1,00** |
| 7 | `CalculadoraViaje` | 0,80 | 0,20 | **1,00** |
| 8 | `ComprobadorReservas` | 0,80 | 0,20 | **1,00** |
| 9 | `ProximoCumpleanios` | 0,80 | 0,20 | **1,00** |
| 10 | `ConversorZonasHorarias` | 0,80 | 0,20 | **1,00** |
| **TOTAL** | | **8,00** | **2,00** | **10,00** |

## Restricciones y criterios comunes

1. Conserva el paquete `es.dampro.unidad2.tarea7` y los nombres, tipos, orden y parámetros de todas las firmas.
2. No uses `java.util.Date`, `Calendar` ni librerías externas de fechas; trabaja con `java.time`.
3. Los métodos devuelven resultados y **no** imprimen ni leen teclado; el método `Main.main` presenta las demostraciones.
4. Debes completar los JavaDoc de clases y métodos con `@author`, `@version`, `@param` para cada argumento y `@return` para cada resultado. Escribe descripciones significativas.
5. No modifiques los tests, el corrector ni el POM. El código del alumnado trae valores provisionales que debes sustituir.
6. Todos los intervalos de horas están en **un mismo día** excepto donde se usa `LocalDateTime`. Fechas y horas locales no se consideran instantes globales sin zona.
7. Se admite `IllegalArgumentException` en los algoritmos 2, 6, 7, 8 y 9 ante entradas inconsistentes según los casos detallados. El algoritmo 4 debe lanzar `DateTimeParseException` para cadenas inválidas.
8. Implementa `Main.main` mostrando al menos una ejecución de cada clase y su etiqueta; también debes documentar `Main` con JavaDoc, aunque no se puntúa automáticamente.
9. JavaDoc: las etiquetas deben estar en comentarios `/** ... */` justo antes de la clase o método; no sirven comentarios `//`.
10. Para comprobar y calificar, usa `mvn test` y `mvn clean verify -Pnota`; la rúbrica se genera en `target/notas_por_bloques.txt` y `target/rubrica.md`.

## Ejercicios y firmas obligatorias

### 1. AnalizadorFecha

**Firma:** `public static String analizarFecha(LocalDate fecha)`

Indica fecha ISO, día de la semana (enum en inglés), posición en el año, bisiesto y longitud del mes. Devuelve una única cadena `AAAA-MM-DD|DAY_OF_WEEK|DIA_DEL_ANIO|true/false|DIAS_MES`.

**Ejemplo:** Para `29/02/2024` devuelve `2024-02-29|THURSDAY|60|true|29`.

### 2. CalculadoraEdad

**Firma:** `public static Period calcularEdad(LocalDate nacimiento, LocalDate fechaActual)`

Calcula la edad exacta en años, meses y días mediante `Period` para una fecha de referencia. Si el nacimiento es posterior a esa fecha, lanza `IllegalArgumentException`.

**Ejemplo:** Para `20/05/2000` y `06/11/2026`: `P26Y5M17D`.

### 3. CalculadoraVencimientos

**Firma:** `public static LocalDate calcularVencimiento(LocalDate fecha, int dias, int meses, int anios)`

Calcula un vencimiento aplicando primero años, luego meses y finalmente días (en ese orden). Admite desplazamientos negativos; delega los ajustes de fin de mes a `LocalDate`.

**Ejemplo:** `31/01/2026 + 1 mes` produce `28/02/2026`.

### 4. ValidadorFechas

**Firma:** `public static LocalDate validarFecha(String texto)`

Interpreta estrictamente texto **dd/MM/uuuu** con dos dígitos de día y mes y cuatro de año. Fecha imposible o cadena incorrecta → `DateTimeParseException`. Utiliza `ResolverStyle.STRICT`.

**Ejemplo:** `29/02/2024` válida; `29/02/2025`, `31/04/2026` y `1/01/2026` inválidas.

### 5. CuentaAtrasEvento

**Firma:** `public static long calcularDiasRestantes(LocalDate hoy, LocalDate evento)`

Calcula días naturales con signo hasta un evento: positivo si falta, cero si es hoy, negativo si ya sucedió.

**Ejemplo:** `01/12/2026` a `25/12/2026` produce `24`.

### 6. CalculadoraJornada

**Firma:** `public static Duration calcularTiempoTrabajado(LocalTime entrada, LocalTime salida, int descansoMinutos)`

Jornada dentro del mismo día: salida estrictamente posterior a entrada; descuento en minutos no negativo y que no exceda la duración. En caso contrario `IllegalArgumentException`. Devuelve `Duration`.

**Ejemplo:** De 08:30 a 17:00, restando 30 minutos, produce `PT8H`.

### 7. CalculadoraViaje

**Firma:** `public static LocalDateTime calcularLlegada(LocalDateTime salida, long horas, long minutos)`

Suma una duración no negativa en horas y minutos a una fecha y hora de salida; si alguna cantidad es negativa, `IllegalArgumentException`. Devuelve `LocalDateTime`.

**Ejemplo:** `15/06/2026 22:30 + 5h45` = `16/06/2026 04:15`.

### 8. ComprobadorReservas

**Firma:** `public static boolean haySolapamiento(LocalDateTime inicio1, LocalDateTime fin1, LocalDateTime inicio2, LocalDateTime fin2)`

Comprueba si dos reservas del tipo **[inicio, fin)** se cruzan. Cada fin debe ser posterior a su inicio (`IllegalArgumentException` en caso contrario). Dos reservas que solo se tocan en un extremo **no** solapan.

**Ejemplo:** 10:00–11:30 con 11:00–12:00 → `true`; con 11:30–12:00 → `false`.

### 9. ProximoCumpleanios

**Firma:** `public static LocalDate calcularProximoCumpleanios(LocalDate nacimiento, LocalDate hoy)`

Devuelve la fecha del próximo cumpleaños **incluido hoy**. Si el nacimiento es futuro, `IllegalArgumentException`. Para nacimientos el 29/02, usa 28/02 en años no bisiestos.

**Ejemplo:** Nacido 20/05/2000, hoy 06/11/2026 → `20/05/2027`.

### 10. ConversorZonasHorarias

**Firma:** `public static ZonedDateTime convertirZona(ZonedDateTime fechaOrigen, ZoneId zonaDestino)`

Convierte una reunión a otra zona horaria preservando el mismo instante; emplea `withZoneSameInstant`, no sumas manuales de horas.

**Ejemplo:** `15/01/2026 12:00 Atlantic/Canary` → `15/01/2026 13:00 Europe/Madrid`.

## Ejemplo de documentación (NO pertenece a la evaluación)

```java
/**
 * Convierte temperaturas entre unidades.
 * @author Nombre y apellidos
 * @version 1.0
 */
public final class ConversorTemperatura {
    /**
     * Calcula grados Fahrenheit a partir de grados Celsius.
     * @param celsius temperatura de entrada
     * @return temperatura equivalente en Fahrenheit
     */
    public static int convertir(int celsius) {
        return celsius * 9 / 5 + 32;
    }
}
```

## Demostración y entrega

Debes implementar `Main.main(String[] args)` con diez ejemplos e imprimir una línea por clase. Entrega el proyecto completo **sin modificar pruebas ni `calcular_nota.py`**. Los métodos de la plantilla devuelven valores provisionales y, por tanto, los tests no estarán inicialmente aprobados.

Comandos útiles:

```bash
mvn test
mvn clean verify -Pnota
```

**Atención:** `-Pnota` permite que se genere la rúbrica aun cuando fallen los tests funcionales; no convierte las pruebas fallidas en aprobadas. La calidad y la autoría real de los JavaDoc se revisarán manualmente.
