# DAM-PRO · Unidad 2 · Tarea 6 — Algoritmia Java

**Objetivo:** desarrollar diez algoritmos sobre cadenas, conversiones numéricas, clases envolventes y métodos de `Math`. El proyecto se entrega en Java 21, Maven.

## Reglas para el alumnado

- Implementa el método público de cada clase **sin cambiar su nombre, parámetros ni tipo de retorno**.
- Utiliza **nombres significativos** para variables, parámetros y constantes; evita `x`, `a1` o `tmp` salvo coeficientes matemáticos justificados.
- **Documenta cada clase y cada método con JavaDoc**, incluyendo una descripción útil, los parámetros (`@param`) y el retorno (`@return`).
- Construye un `Main` que ejecute los diez métodos con ejemplos y muestre **diez líneas**, con las etiquetas `InvertirCadena:`, `Palindromo:`, `ContadorVocales:`, `SumaDigitos:`, `MayorNumero:`, `BinarioDecimal:`, `Factorial:`, `NumeroPrimo:`, `EcuacionCuadratica:` y `MediaNumeros:` en ese orden.
- No uses `Scanner` ni imprimas en los métodos de algoritmia. Devuelve el valor calculado. No uses `StringBuilder.reverse()` para resolver la inversión de texto.
- Si la referencia es `null`, el texto es vacío cuando se exige un número o hay valores fuera del dominio indicado, lanza `IllegalArgumentException`. Para texto numérico mal formado se admite `NumberFormatException`.
- Los métodos con `double` se evaluarán con tolerancia numérica, no como cadenas formateadas.

## Algoritmos obligatorios

| Clase | Firma | Resultado y comportamiento esperado | Ejemplo |
|---|---|---|---|
| `InvertirCadena` | `String invertir(String texto)` | Invierte todos los caracteres, conservando espacios y mayúsculas. | `"Hola"` → `"aloH"` |
| `Palindromo` | `boolean esPalindromo(String texto)` | Comprueba si se lee igual de ambos lados; ignora espacios y mayúsculas, no signos ni tildes; texto vacío no es palíndromo. | `"Ana"` → `true` |
| `ContadorVocales` | `int contarVocales(String texto)` | Cuenta a, e, i, o, u, vocales con tilde y ü, en ambas cajas; ignora el resto. | `"Murciélago"` → `5` |
| `SumaDigitos` | `int sumarDigitos(String numero)` | Suma los dígitos de un entero positivo indicado como texto. | `"5832"` → `18` |
| `MayorNumero` | `int obtenerMayor(String numeros)` | Extrae el mayor entero de una lista separada por comas; admite negativos y espacios alrededor. | `"12,-5,89"` → `89` |
| `BinarioDecimal` | `int convertirBinario(String binario)` | Convierte una cadena formada por ceros y unos a decimal; rechaza otros caracteres y desbordamientos. | `"1011"` → `11` |
| `Factorial` | `int calcularFactorial(String numero)` | Calcula el factorial de un entero entre 0 y 12 (ambos incluidos). | `"5"` → `120` |
| `NumeroPrimo` | `boolean esPrimo(String numero)` | Decide si el número recibido como texto es primo; los menores que 2 no lo son. | `"17"` → `true` |
| `EcuacionCuadratica` | `double calcularDiscriminante(String a, String b, String c)` | Convierte tres coeficientes reales finitos y calcula `b² - 4ac`; `a` debe ser distinto de cero. | `("1","-5","6")` → `1.0` |
| `MediaNumeros` | `double calcularMedia(String numeros)` | Calcula la media de una lista no vacía de enteros separados por comas, con espacios opcionales; no redondees el resultado. | `"10,20,30,40"` → `25.0` |

## Programa principal

El alumnado debe crear un `main...` pedir datos de prueba  y mostrar los diez resultados con llamadas reales a los métodos. El formato de los valores numéricos es libre; para las etiquetas se utiliza el formato indicado. Cada ejemplo debe producir una línea no vacía.


**Calidad del código:** el profesorado revisará también el uso de nombres significativos, la legibilidad y la correcta estructuración. Un método que imprime el resultado en lugar de devolverlo no cumple su contrato. Los test son parte de la evaluación, no una solución del ejercicio.
