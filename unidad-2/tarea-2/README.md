# Unidad 02 · Tarea 2 — Conversor de medidas interactivo

**Módulo:** Programación — 1.º de Desarrollo de Aplicaciones Multiplataforma (DAM)  
**Entorno:** IntelliJ IDEA, Java 21, Maven y GitHub  
**Sistemas operativos:** Windows (Git Bash) y Debian (Bash)  
**Ubicación de entrega:** `git/dam-pro/unidad-02/tarea2/`

## Objetivos

Al finalizar esta tarea deberás ser capaz de:

- Verificar si existe el repositorio remoto `dam-pro` y crear uno si es necesario.
- Comprobar si existe la copia local y clonarla cuando sea necesario, sin borrar tareas anteriores.
- Crear un proyecto Java **Maven desde IntelliJ IDEA** dentro del repositorio.
- Leer datos con `Scanner` y utilizar `String`, `int` y `float`.
- Repetir un menú mediante un bucle **`while`** hasta que el usuario elija salir.
- Seleccionar distintas operaciones mediante `switch` o `if-else`.
- Validar distancias negativas, contar las conversiones correctas y mostrar un resumen.
- Mantener actualizado el índice de `unidad-02/README.md` y publicar avances progresivos con Git.

> **Importante:** este documento es el enunciado proporcionado por el profesor. Guárdalo como `unidad-02/tarea2/README.md`. **No elimines ni reemplaces sus instrucciones**: al terminar, añade al final tu apartado de desarrollo y pruebas.

---

# Paso 1. Verificación del repositorio y creación del proyecto Maven

## 1.1. Comprobar el repositorio en GitHub

1. Abre <https://github.com> e inicia sesión.
2. Busca en tus repositorios uno llamado **`dam-pro`**.
3. **Si existe**, reutilízalo. No crees otro ni borres las unidades o tareas anteriores.
4. **Si no existe**, pulsa **New repository** y configura:
    - **Repository name:** `dam-pro`.
    - **Description:** `Repositorio de Programación de DAM`.
    - **Visibility:** `Public`.
    - Marca **Add a README file**.
    - Pulsa **Create repository**.
5. Identifica la URL HTTPS de tu repositorio: `https://github.com/TU_USUARIO/dam-pro.git`.

## 1.2. Abrir la terminal de IntelliJ IDEA

1. Abre IntelliJ IDEA.
2. Abre **View → Tool Windows → Terminal** (`Alt + F12`).
3. En **Windows**, utiliza Git Bash. Si debes configurarlo: **File → Settings → Tools → Terminal**, con la ruta habitual `"C:\Program Files\Git\bin\bash.exe" --login -i`.
4. En **Debian**, utiliza Bash (`/bin/bash`).
5. Comprueba Git:

```bash
git --version
```

Si no está instalado, en Windows descárgalo desde <https://git-scm.com/downloads/win>. En Debian:

```bash
sudo apt update
sudo apt install git -y
```

Si aún no tienes configurada tu identidad Git, utiliza tus datos:

```bash
git config --global user.name "Nombre Apellidos"
git config --global user.email "tu-correo@example.com"
```

## 1.3. Comprobar la copia local y clonar si hace falta

La ubicación común es la carpeta `git` del directorio personal:

- **Windows (Git Bash):** normalmente `/c/Users/TU_USUARIO_WINDOWS/git/dam-pro`.
- **Debian:** normalmente `/home/alumno/git/dam-pro` si el usuario de la máquina virtual es `alumno`.

Ejecuta:

```bash
cd ~
mkdir -p git
cd git
pwd
ls
```

**Si aparece `dam-pro`:**

```bash
cd dam-pro
git status
git remote -v
```

Asegúrate de que `origin` apunta a **tu** repositorio de GitHub. Si la carpeta existe pero `git status` indica que no es un repositorio Git, **no borres nada**: consulta al profesor.

**Si no aparece `dam-pro`:**

```bash
git clone https://github.com/TU_USUARIO/dam-pro.git
cd dam-pro
git status
git remote -v
```

Sustituye `TU_USUARIO` por tu usuario real. Si acabas de crear el repositorio en GitHub, al principio puede contener únicamente el README principal.

> **No ejecutes `git init` dentro de `unidad-02` ni de `tarea2`**. Ambas carpetas forman parte del repositorio principal `dam-pro`.

## 1.4. Comprobar la rama y sincronizar

Todos los comandos de este apartado se ejecutan desde la raíz de `dam-pro`:

```bash
pwd
git branch --show-current
git status
git fetch origin
git log --oneline HEAD..origin/main
git pull --ff-only origin main
git status
```

La actividad utiliza `main`. Si tu rama tiene otro nombre, consulta al profesor. Si `git pull --ff-only` falla o tienes cambios locales pendientes, **no fuerces ni elimines archivos**: revisa la situación antes de continuar.

**Observa la diferencia:** `git fetch` descarga información sobre los cambios remotos sin integrarlos en la rama local; `git pull` descarga e integra los cambios.

## 1.5. Abrir el repositorio en IntelliJ IDEA

1. Selecciona **File → Open**.
2. Abre la carpeta `git/dam-pro`.
3. Comprueba que el panel **Project** muestra su README principal y las unidades existentes.
4. Comprueba que dispones del **JDK 21**. Si IntelliJ lo solicita, selecciónalo o descárgalo desde el asistente.

## 1.6. Comprobar la unidad 02

En el panel **Project**:

1. Comprueba si existe `unidad-02`. Si no existe, haz clic derecho en `dam-pro` → **New → Directory** y crea `unidad-02`.
2. Si existe, **no borres ni sustituyas** su contenido. La `tarea1` debe conservarse.
3. Comprueba si existe `unidad-02/README.md`. Si no, créalo desde **New → File** con este contenido inicial:

```markdown
# Unidad 02 - Fundamentos de Java

## Descripción

Ejercicios de programación básica en Java.

## Índice de tareas

| Tarea | Descripción | Estado |
|---|---|---|
```

Si ya existe, conserva su descripción y su tabla de tareas.

## 1.7. Crear el proyecto Maven `tarea2` desde IntelliJ IDEA

**Debes crear la estructura Maven utilizando el asistente de IntelliJ IDEA; no con `mkdir` ni copiando la carpeta de otra tarea.**

1. Comprueba si ya existe `unidad-02/tarea2`.
2. Si contiene un `pom.xml`, abre el proyecto existente: **no lo vuelvas a crear**.
3. Si no existe, selecciona **File → New → Project**.
4. Elige **Java** como lenguaje y **Maven** como sistema de construcción. Según la versión de IntelliJ, Maven puede aparecer como tipo de proyecto.
5. Introduce **Name:** `tarea2`.
6. En **Location**, selecciona `git/dam-pro/unidad-02` y **comprueba que el directorio final será `git/dam-pro/unidad-02/tarea2`**, no `tarea2/tarea2`.
7. Selecciona **JDK 21**.
8. Si aparece la configuración de Maven, utiliza **GroupId:** `es.dam` y **ArtifactId:** `tarea2`.
9. Si aparece la opción **Create Git repository**, **desactívala**.
10. Pulsa **Create**. Si IntelliJ pregunta cómo abrir el proyecto, puedes abrirlo en otra ventana conservando abierta la ventana de `dam-pro`.
11. Espera a que Maven cargue el proyecto.

La estructura mínima será:

```text
git/
└── dam-pro/
    ├── README.md
    └── unidad-02/
        ├── README.md
        ├── tarea1/                 (se conserva)
        └── tarea2/
            ├── README.md
            ├── pom.xml
            └── src/
                └── main/
                    └── java/
                        └── Main.java
```

**`Main.java` se creará en el Paso 2.** Si IntelliJ ha configurado un paquete (por ejemplo `es.dam`), crea `Main.java` dentro de ese paquete; no es necesario usar el paquete por defecto.

## 1.8. Incorporar el README de Moodle y actualizar el índice

1. Descarga este documento `README.md` desde Moodle.
2. Guárdalo en `unidad-02/tarea2/README.md`, junto al `pom.xml` de la tarea. No lo sustituyas por el README de otra tarea.
3. Abre `unidad-02/README.md` y añade esta fila bajo `## Índice de tareas`:

```markdown
| [Tarea 2](tarea2/) | Conversor de medidas interactivo | En desarrollo |
```

Conserva la fila de `tarea1` y de cualquier otra tarea. Si la fila de `tarea2` ya aparece, actualiza su estado sin duplicarla. Guarda los cambios.

## 1.9. Primer commit: estructura y documentación

Abre la terminal en la raíz de `dam-pro` (si estás dentro de `tarea2`, regresa con `cd ../..`). Ejecuta uno por uno:

```bash
git status
git add unidad-02/README.md
git add unidad-02/tarea2/README.md
git add unidad-02/tarea2/pom.xml
git diff --cached
git commit -m "build: preparar tarea 2 unidad 02"
git push origin main
git status
```

Si Git indica que no hay cambios que confirmar, comprueba los archivos. No crees commits vacíos. Entra en GitHub y verifica que el README, el `pom.xml` y el enlace del índice están publicados.

---

# Paso 2. Desarrollo del ejercicio: Conversor de medidas interactivo

## 2.1. Enunciado

Una empresa de transporte necesita un programa de consola que permita convertir distintas unidades de distancia. El programa debe solicitar el nombre del usuario y mostrar un menú con estas opciones:

1. **Kilómetros a metros**.
2. **Metros a centímetros**.
3. **Kilómetros a millas**.
4. **Salir**.

**La novedad respecto de la tarea 1 es utilizar un bucle `while`:** el usuario podrá seguir realizando conversiones sin volver a ejecutar el programa. No sabemos de antemano cuántas conversiones realizará.

El programa debe contar las conversiones correctas. Solo terminará cuando el usuario elija **4. Salir**.

## 2.2. Ejemplo de ejecución

```text
====================================
         CONVERSOR DAM-PRO
====================================

Introduce tu nombre: Laura

Bienvenida/o, Laura.

1. Kilómetros a metros
2. Metros a centímetros
3. Kilómetros a millas
4. Salir

Selecciona una opción: 1
Introduce los kilómetros: 2.5
Resultado: 2500.0 metros
Conversión realizada correctamente.

1. Kilómetros a metros
2. Metros a centímetros
3. Kilómetros a millas
4. Salir

Selecciona una opción: 3
Introduce los kilómetros: 10
Resultado: 6.21371 millas
Conversión realizada correctamente.

1. Kilómetros a metros
2. Metros a centímetros
3. Kilómetros a millas
4. Salir

Selecciona una opción: 4

====================================
Usuario: Laura
Conversiones realizadas: 2
Gracias por utilizar DAM-PRO.
====================================
```

**Decimales:** el separador decimal de `Scanner` depende de la configuración regional de tu equipo. Si utiliza coma, escribe `2,5`; si utiliza punto, escribe `2.5`. Puedes configurar una región explícitamente si te lo indica el profesor.

## 2.3. Fórmulas de conversión

| Conversión | Fórmula |
|---|---|
| Kilómetros a metros | `metros = kilometros * 1000` |
| Metros a centímetros | `centimetros = metros * 100` |
| Kilómetros a millas | `millas = kilometros * 0.621371` |

Para la tercera operación recuerda utilizar una constante compatible con `float`, por ejemplo `0.621371f`, si guardas el resultado en ese tipo.

## 2.4. Requisitos técnicos obligatorios

| Elemento | Uso obligatorio |
|---|---|
| `Scanner` | Leer todos los datos por teclado |
| `String` | Guardar el nombre del usuario |
| `int` | Guardar la opción y el número de conversiones |
| `float` | Guardar distancias y resultados |
| `while` | Repetir el menú hasta elegir la opción 4 |
| `if-else` o `switch` | Ejecutar la conversión seleccionada |
| Contador | Sumar 1 después de cada conversión válida |
| Condiciones | Rechazar cantidades negativas y opciones inexistentes |
| `System.out.println()` | Mostrar resultados y mensajes |

Condiciones que debe cumplir el programa:

- El menú se mostrará **como mínimo una vez** y volverá a aparecer después de cada operación, salvo al seleccionar **Salir**.
- Una opción distinta de 1, 2, 3 o 4 mostrará `Opción no válida` y devolverá al menú.
- Si se introduce una distancia negativa, **solicita de nuevo la cantidad** hasta que sea mayor o igual que cero. Puedes utilizar un `while` adicional para esta validación.
- Un valor de cero es válido: su conversión debe ser cero.
- El contador solo aumentará al realizar una conversión correcta; no contará opciones inválidas ni intentos con distancias negativas.
- Al salir se mostrarán el nombre y el número de conversiones correctas.
- Para esta tarea puedes suponer que cuando se solicita un número, el usuario introduce un dato numérico con un formato válido. La recuperación de entradas no numéricas se estudiará más adelante.
- No utilices arrays, colecciones, interfaces gráficas ni librerías externas.

## 2.5. Crear `Main.java` desde IntelliJ IDEA

1. Abre el proyecto Maven `tarea2`.
2. Busca `src/main/java` desde el panel **Project**.
3. Haz clic derecho en `java` o en el paquete existente → **New → Java Class**.
4. Escribe **Main**.
5. Añade el método `main` y utiliza esta estructura inicial **sin solución completa**:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // 1. Solicitar el nombre del usuario.
        // 2. Declarar opción y contador de conversiones.
        // 3. Crear el bucle while del menú.
        // 4. Seleccionar y realizar cada conversión.
        // 5. Validar las distancias negativas.
        // 6. Mostrar el resumen al salir.

        teclado.close();
    }
}
```

Si IntelliJ ha creado la clase dentro de un paquete, conserva su declaración `package ...;` por encima de los imports.

## 2.6. Programar por fases

**Fase A — Nombre y menú inicial.** Solicita el nombre (`String`), declara la opción (`int`) y el contador (`int`, inicialmente 0). Muestra un menú de cuatro opciones. Comprueba que los datos se leen correctamente.

**Fase B — Conversiones.** Implementa las tres fórmulas utilizando `float`. Para elegir una operación utiliza `switch` o `if-else`. Comprueba primero que los resultados matemáticos son correctos.

**Fase C — Repetición y validaciones.** Envuelve el menú en un `while` que siga activo mientras la opción no sea 4. Añade los mensajes de opción inválida y la solicitud repetida de distancias negativas. Incrementa el contador únicamente tras una conversión válida. Al salir, muestra el resumen final.

> **Haz cada commit al terminar su fase, antes de empezar la siguiente.** Un historial con todos los commits hechos al final no demuestra el desarrollo progresivo.

## 2.7. Segundo commit: lectura del usuario y menú

Cuando funcione la **Fase A**, desde la raíz de `dam-pro`:

```bash
git status
git add unidad-02/tarea2/src/
git diff --cached
git commit -m "feat: implementar menu de conversiones"
git push origin main
```

## 2.8. Tercer commit: las tres conversiones

Cuando funcione la **Fase B**:

```bash
git status
git add unidad-02/tarea2/src/
git diff --cached
git commit -m "feat: implementar conversiones de medidas"
git push origin main
```

## 2.9. Cuarto commit: `while`, validaciones y contador

Cuando funcione la **Fase C**:

```bash
git status
git add unidad-02/tarea2/src/
git diff --cached
git commit -m "feat: validar datos y repetir conversiones"
git push origin main
```

## 2.10. Ejecutar y realizar las pruebas

En IntelliJ IDEA, abre `Main.java` y elige **Run 'Main.main()'**. Comprueba **todas** estas situaciones:

| Prueba | Entrada | Resultado esperado |
|---|---|---|
| 1 | Opción 1: 3 km | 3000 metros |
| 2 | Opción 2: 2,5 m | 250 centímetros |
| 3 | Opción 3: 10 km | Aproximadamente 6,21371 millas |
| 4 | Opción 1: -5 km | Mensaje de error y nueva solicitud de distancia |
| 5 | Opción 2: 0 m | 0 centímetros y conversión contada |
| 6 | Opción 8 | Mensaje de opción no válida, sin aumentar el contador |
| 7 | Opción 4 | El programa finaliza y muestra el resumen |
| 8 | Tres conversiones válidas | Contador final igual a 3 |

Puedes ejecutar la compilación Maven desde la ventana **Maven** de IntelliJ. Si tienes Maven disponible en la terminal, desde `unidad-02/tarea2` puedes ejecutar `mvn compile`. **No subas** al repositorio archivos compilados ni el directorio `target/`.

Comprueba el archivo `.gitignore` de la raíz `dam-pro`. Si no existe, créalo desde IntelliJ IDEA. Asegúrate de que contiene estas reglas (sin eliminar las que ya tenga):

```gitignore
**/target/
*.class
.idea/
*.iml
```

Si has tenido que cambiar `.gitignore`, incluye ese cambio en un commit de documentación o crea un commit separado.

## 2.11. Documentar las pruebas y actualizar el índice

**No elimines el enunciado anterior.** Añade al final de `unidad-02/tarea2/README.md` y completa con tus propias palabras:

```markdown
## Desarrollo y pruebas del alumno

### Cómo funciona mi programa

Explica cómo has utilizado Scanner, String, int,
float, el bucle while y el contador.

### Validaciones implementadas

Explica qué hace el programa si escribes una opción
incorrecta o una distancia negativa.

### Pruebas realizadas

Describe los datos introducidos y los resultados
obtenidos en las ocho pruebas obligatorias.

### Dificultades y soluciones

Explica alguna dificultad y cómo la resolviste.
```

En `unidad-02/README.md`, cambia **solo la fila de la tarea 2** a:

```markdown
| [Tarea 2](tarea2/) | Conversor de medidas interactivo | Completada |
```

No borres la tarea 1 ni las demás entradas.

## 2.12. Quinto commit: documentación final

Desde la raíz de `dam-pro`:

```bash
git status
git add unidad-02/tarea2/README.md
git add unidad-02/README.md
git diff --cached
git commit -m "docs: finalizar tarea 2 y actualizar indice"
git push origin main
git status
git log --oneline -7
```

Si has modificado `.gitignore`, añádelo con `git add .gitignore` **antes del commit**. No hace falta añadirlo si ya estaba correctamente configurado.

Comprueba en GitHub que están publicados el README, el `pom.xml`, el código y el índice actualizado.

---

# Paso 3. ¿Qué hacer si termina el tiempo de clase?

**Si no terminas la tarea durante la clase, es obligatorio publicar en GitHub todo lo que hayas realizado, aunque el programa todavía esté incompleto, y terminarlo en casa.** No dejes los cambios solo en el ordenador del aula.

## 3.1. Antes de abandonar el aula

1. Guarda el código y la documentación desde IntelliJ IDEA.
2. Abre la terminal en la raíz de `git/dam-pro`.
3. Comprueba los cambios y guarda el trabajo pendiente:

```bash
git status
git add unidad-02/README.md unidad-02/tarea2/
git diff --cached
git commit -m "wip: guardar avance de tarea 2 para continuar en casa"
git push origin main
git status
```

`wip` significa *work in progress* (trabajo en progreso). Haz este commit **solo si hay cambios pendientes**. Si no los hay, verifica que tu último commit ya esté publicado en GitHub.

4. Mantén el estado **En desarrollo** en `unidad-02/README.md` si la tarea aún no funciona correctamente.
5. Accede a GitHub y comprueba que aparece el último commit y tu código actualizado.

## 3.2. Continuar desde casa

1. Abre IntelliJ IDEA en tu ordenador de casa.
2. Si no tienes una copia del repositorio, sigue el **Paso 1.3** para clonarlo.
3. Desde la raíz de `dam-pro`, sincroniza:

```bash
git status
git fetch origin
git log --oneline HEAD..origin/main
git pull --ff-only origin main
```

4. Abre el proyecto Maven `unidad-02/tarea2`.
5. Completa las fases pendientes, ejecuta todas las pruebas y documenta el resultado.
6. Cambia el índice a **Completada** cuando el programa funcione.
7. Registra y publica los cambios que hayas realizado desde casa:

```bash
git status
git add unidad-02/README.md unidad-02/tarea2/
git diff --cached
git commit -m "feat: terminar tarea 2 desde casa"
git push origin main
git status
```

Si has completado únicamente documentación, utiliza un mensaje `docs:` que describa esos cambios. No realices commits vacíos.

> **Recuerda:** un archivo guardado únicamente en el ordenador **no constituye una entrega**. El profesor revisará la versión publicada en GitHub.

---

# Paso 4. Entrega en Moodle

Entrega en la actividad de Moodle el enlace público directo a tu tarea:

```text
https://github.com/TU_USUARIO/dam-pro/tree/main/unidad-02/tarea2
```

Sustituye `TU_USUARIO` por tu nombre de usuario real de GitHub.

El profesor comprobará:

- El proyecto Maven, el `pom.xml` y el código Java.
- El funcionamiento del menú y del bucle `while`.
- Las conversiones, validaciones y el contador.
- El `README.md` de la tarea, con el enunciado original y la documentación de tus pruebas.
- El índice de `unidad-02/README.md`, con las tareas anteriores conservadas.
- Los commits progresivos y los `push` al repositorio.
- La publicación de los avances si has terminado parte del trabajo desde casa.

## Criterios de evaluación

| Criterio | Puntuación |
|---|---:|
| Repositorio preparado, proyecto Maven y README | 1 punto |
| Índice de tareas actualizado | 1 punto |
| Uso correcto de `Scanner`, `String`, `int` y `float` | 1,5 puntos |
| Tres conversiones correctas | 2 puntos |
| Menú repetitivo mediante `while` | 2 puntos |
| Validaciones y contador de conversiones | 1 punto |
| Pruebas y presentación de resultados | 0,5 puntos |
| Commits progresivos y publicación en GitHub | 1 punto |
| **Total** | **10 puntos** |

## Ampliación voluntaria

Si terminas antes, añade al menú una quinta opción para **convertir centímetros a pulgadas**, utilizando `pulgadas = centimetros / 2.54`. Desplaza la opción **Salir** al número 5, actualiza las validaciones y documenta una prueba de la nueva conversión. Realiza un commit independiente con el mensaje:

```bash
git add unidad-02/tarea2/src/
git commit -m "feat: ampliar conversor con centimetros a pulgadas"
git push origin main
```

