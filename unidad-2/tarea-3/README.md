# Unidad 02 · Tarea 3 — Simulador de ahorro personal

**Módulo:** Programación — 1.º DAM  
**Entorno:** IntelliJ IDEA, Java 21, Maven y GitHub  
**Sistemas operativos:** Windows (Git Bash) y Debian (Bash)  
**Carpeta de trabajo:** `~/git/dam-pro/`

> **Documento del profesor:** guarda este archivo en la carpeta de la tarea con el nombre exacto `README.md`. No borres el enunciado. Al finalizar, añade tus explicaciones y pruebas en una sección al final.

---

# Paso 1. Verificar el repositorio y crear el proyecto Maven

## 1.1. Comprobar si existe el repositorio en GitHub

1. Abre <https://github.com> y entra en tu cuenta.
2. Comprueba que tienes un repositorio **público** llamado `dam-pro`.
3. Si ya existe, **no crees otro**: conserva todas las unidades y tareas anteriores.
4. Si no existe, pulsa **New repository**, escribe `dam-pro`, marca **Public**, activa **Add a README file** y pulsa **Create repository**.
5. Identifica su URL HTTPS: `https://github.com/TU_USUARIO/dam-pro.git`.

## 1.2. Abrir la terminal desde IntelliJ IDEA

1. Abre IntelliJ IDEA; utiliza **View → Tool Windows → Terminal** (`Alt + F12`).
2. En Windows, configura **Git Bash** en **File → Settings → Tools → Terminal**. Ruta habitual: `"C:\Program Files\Git\bin\bash.exe" --login -i`.
3. En Debian utiliza `/bin/bash`.
4. Comprueba Git y tu identidad:

```bash
git --version
git config --global user.name
git config --global user.email
```

Si faltan los datos de autor, configúralos con tu nombre y correo:

```bash
git config --global user.name "Nombre Apellidos"
git config --global user.email "correo@example.com"
```

Si Git no está instalado, instala Git para Windows desde <https://git-scm.com/downloads/win>, o en Debian ejecuta `sudo apt update` y `sudo apt install git`.

## 1.3. Verificar la copia local; clonar solo si hace falta

Todos los proyectos se guardan en la carpeta `git` del directorio personal. En Debian suele ser `/home/alumno/git/dam-pro`; en Windows, Git Bash suele mostrar `/c/Users/Usuario/git/dam-pro`.

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

Confirma que `origin` apunta a **tu** repositorio. Si `git status` indica que no estás en un repositorio Git, no borres ni sobrescribas la carpeta; consulta al profesor.

**Si no aparece `dam-pro`:** clona el que existe en GitHub:

```bash
git clone https://github.com/TU_USUARIO/dam-pro.git
cd dam-pro
git status
git remote -v
```

Sustituye `TU_USUARIO` por tu usuario real. **No ejecutes `git init` dentro de ninguna tarea**: todo pertenece al único repositorio `dam-pro`.

## 1.4. Comprobar la rama y sincronizar

Desde la raíz de `dam-pro`:

```bash
pwd
git branch --show-current
git status
git fetch origin
git log --oneline HEAD..origin/main
git pull --ff-only origin main
git status
```

La rama de esta práctica es `main`. Si tienes modificaciones locales pendientes, guarda o revisa su estado antes de `pull`; si aparece un error de integración, **no uses `push --force`, `reset --hard` ni borres archivos**. Consulta al profesor.

**Recuerda:** `fetch` descarga información remota sin incorporar los cambios a tus archivos; `pull` descarga e integra los cambios.

## 1.5. Abrir el repositorio y comprobar la unidad

1. En IntelliJ IDEA selecciona **File → Open** y abre `git/dam-pro`.
2. En el panel **Project**, busca `unidad-02`.
3. Si no existe, haz clic derecho sobre `dam-pro` → **New → Directory** → escribe `unidad-02`.
4. Dentro de la unidad comprueba si existe `README.md`.
5. Si no existe, créalo mediante **New → File** y escribe:

```markdown
# Unidad 02 - Fundamentos de Java

## Descripción

Ejercicios de programación básica en Java.

## Índice de tareas

| Tarea | Descripción | Estado |
|---|---|---|
```

Si ya existe, **no reemplaces su contenido** y conserva las tareas anteriores.

## 1.6. Crear el proyecto Maven desde IntelliJ IDEA

**La estructura Maven se crea desde el IDE, no con `mkdir` ni con comandos Maven.**

1. Comprueba si ya existe `unidad-02/tarea3`. Si contiene `pom.xml`, abre ese proyecto en lugar de recrearlo.
2. Si no existe, selecciona **File → New → Project**.
3. Elige lenguaje **Java** y sistema de construcción **Maven** (según la versión, Maven puede aparecer como tipo de proyecto).
4. En **Name** escribe `tarea3`.
5. En **Location** selecciona `git/dam-pro/unidad-02`; revisa que el proyecto final quede exactamente en `git/dam-pro/unidad-02/tarea3`, **no en `tarea3/tarea3`**.
6. Selecciona **JDK 21**. Si no está instalado, utiliza la opción de descargarlo desde IntelliJ IDEA.
7. Si solicita datos Maven, indica **GroupId** `es.dam` y **ArtifactId** `tarea3`.
8. Si aparece **Create Git repository**, desactívalo: ya existe el Git de `dam-pro`.
9. Pulsa **Create**; si es necesario, abre el proyecto en otra ventana. Espera a que Maven cargue sus dependencias.
10. Desde el panel Project, añade el archivo `README.md` entregado en Moodle a la raíz de `tarea3`, junto al `pom.xml`.

La estructura esperada es:

```text
git/
└── dam-pro/
    ├── README.md
    └── unidad-02/
        ├── README.md
        ├── tarea1/                   (conservar)
        └── tarea3/
            ├── README.md
            ├── pom.xml
            └── src/
                └── main/
                    └── java/
                        └── Main.java  (se creará en el paso 2)
```

Si IntelliJ crea un paquete como `es.dam`, coloca `Main.java` dentro del subdirectorio de ese paquete y conserva `package es.dam;` al principio de la clase.

## 1.7. Actualizar el índice de tareas

En `unidad-02/README.md` conserva todas las entradas anteriores y añade, **sin duplicarla**, la línea:

```markdown
| [Tarea 3](tarea3/) | Simulador de ahorro personal | En desarrollo |
```

Revisa que el enlace relativo funcione en GitHub. El estado cambiará a **Completada** solo cuando el programa esté probado.

## 1.8. Primer commit: estructura, pom.xml y enunciado

Desde la terminal situada en la **raíz de `dam-pro`** (si estás en la carpeta del proyecto Maven, ejecuta `cd ../..`):

```bash
git status
git add unidad-02/README.md
git add unidad-02/tarea3/README.md
git add unidad-02/tarea3/pom.xml
git diff --cached
git commit -m "build: preparar tarea3 unidad 02"
git push origin main
git status
```

Comprueba en GitHub que la carpeta, el `pom.xml`, el README y el enlace del índice se ven correctamente. Si no hay modificaciones, Git no permitirá crear un commit: no generes commits vacíos.

---

# Paso 2. Desarrollo del ejercicio: Simulador de ahorro personal

## Objetivos

- Repetir aportaciones con un bucle **`do-while`** que se ejecute al menos una vez.
- Utilizar `Scanner` y los tipos `String`, `int` y `float`.
- Emplear acumuladores, contadores y condicionales para validar importes.
- Mantener el proyecto Maven dentro del mismo repositorio `dam-pro` y actualizar el índice.
- Registrar y publicar avances en GitHub durante el desarrollo.

## 2.1. Enunciado

Una persona desea controlar sus ahorros. Tu aplicación deberá pedir su nombre (`String`) y la cantidad inicial de dinero (`float`). A continuación solicitará **al menos una aportación** y preguntará si quiere introducir otra. Seguirá mientras responda `S` o `s`; si responde `N` o `n`, mostrará un resumen.

**La repetición de aportaciones debe realizarse obligatoriamente con `do-while`.** No uses arrays, listas, clases adicionales ni ventanas gráficas.

## 2.2. Ejemplo de ejecución

```text
====================================
       SIMULADOR DE AHORRO
====================================

Introduce tu nombre: Marta
¿Cuánto dinero tienes ahorrado? 100

Hola, Marta.
Introduce una cantidad para ahorrar: 25
Aportación registrada. Ahorro actual: 125.00 euros

¿Deseas realizar otra aportación? (S/N): S
Introduce una cantidad para ahorrar: 50
Aportación registrada. Ahorro actual: 175.00 euros

¿Deseas realizar otra aportación? (S/N): S
Introduce una cantidad para ahorrar: 10
Aportación registrada. Ahorro actual: 185.00 euros

¿Deseas realizar otra aportación? (S/N): N

====================================
         RESUMEN DEL AHORRO
====================================
Usuario: Marta
Ahorro inicial: 100.00 euros
Aportaciones realizadas: 3
Total aportado: 85.00 euros
Ahorro final: 185.00 euros
```

## 2.3. Requisitos obligatorios

| Elemento | Aplicación |
|---|---|
| `Scanner` | Todas las lecturas de teclado |
| `String` | Nombre y respuesta S/N |
| `float` | Ahorro inicial, aportaciones, suma y ahorro final |
| `int` | Contador de aportaciones válidas |
| `do-while` | Solicitar y repetir aportaciones |
| `if` | Comprobar que las cantidades son positivas |
| `equalsIgnoreCase` | Aceptar mayúsculas y minúsculas |

- El ahorro inicial debe ser **mayor o igual a cero**; si es negativo, vuelve a solicitarlo (puedes emplear otro bucle para esta validación).
- Cada aportación debe ser **mayor que cero**. Si es cero o negativa, vuelve a solicitar una aportación válida **sin contarla**, ni preguntar aún si se desea continuar.
- Tras cada aportación válida muestra el ahorro actual.
- El resumen debe distinguir el dinero inicial, el total añadido, el contador y el saldo final.
- Se puede suponer que las entradas numéricas están bien formadas; no se exige gestionar texto donde se esperan números.
- En la lectura de decimales, utiliza el separador aceptado por `Scanner` según tu configuración regional. Al combinar `nextFloat()` y `nextLine()`, recuerda consumir los saltos de línea pendientes si es necesario.

## 2.4. Crear Main.java desde el IDE

1. Abre el proyecto Maven `tarea3` en IntelliJ IDEA.
2. En **Project**, haz clic derecho en `src/main/java` (o en el paquete que has creado) → **New → Java Class** → `Ahorro`.
3. Incluye el método `main` y comienza a partir de este esqueleto. **No se ofrece la solución completa**:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Pedir nombre y ahorro inicial.
        // Preparar acumuladores y contador.
        // Repetir aportaciones mediante do-while.
        // Mostrar resumen.

        teclado.close();
    }
}
```

Si IntelliJ ha creado un paquete, conserva la línea `package ...;` encima de los imports.

## 2.5. Implementación por fases y commits

**Fase A: lectura de datos iniciales.** Solicita y muestra el nombre y el ahorro inicial. Cuando funcione, realiza el **segundo commit**, desde la raíz de `dam-pro`:

```bash
git status
git add unidad-02/tarea3/src/
git diff --cached
git commit -m "feat: leer datos iniciales de ahorro"
git push origin main
```

**Fase B: aportaciones repetidas.** Declara `totalAportado` (`float`) y un contador `int`. Construye un `do-while` que realice una primera aportación, muestre el ahorro y permita decidir si continuar. Cuando funcione, realiza el **tercer commit**:

```bash
git status
git add unidad-02/tarea3/src/
git diff --cached
git commit -m "feat: registrar aportaciones con do-while"
git push origin main
```

**Fase C: validaciones y resumen.** Rechaza ahorro inicial negativo y aportaciones no positivas; comprueba que las aportaciones inválidas no alteran los contadores. Añade el resumen al final. Realiza el **cuarto commit**:

```bash
git status
git add unidad-02/tarea3/src/
git diff --cached
git commit -m "feat: validar cantidades y resumir ahorro"
git push origin main
```

**No hagas todos los commits al final:** confirma y publica cada fase cuando realmente esté implementada.

## 2.6. Pruebas obligatorias

Ejecuta `Main.main()` desde IntelliJ IDEA y verifica:

| Prueba | Entrada | Resultado esperado |
|---|---|---|
| 1 | Inicial 100; aportación 20; N | Saldo final 120; 1 aportación |
| 2 | Inicial 50; aportaciones 10, 15; N | Final 75; 2 aportaciones |
| 3 | Inicial 0; aportación 30; N | Final 30 |
| 4 | Aportación -10 y después 5 | Ignora -10, suma 5 una sola vez |
| 5 | Aportación 0 y después 8 | Ignora 0, cuenta 8 |
| 6 | Respuesta `s` y después `n` | Repite una vez y finalmente sale |
| 7 | Ahorro inicial -4 y después 10 | Vuelve a solicitar valor; comienza con 10 |

En la terminal del proyecto Maven también puedes utilizar `mvn compile` si Maven está disponible. No subas `target/` ni archivos `.class`.

Comprueba el `.gitignore` en la raíz de `dam-pro`: debe contener `**/target/`, `*.class`, `.idea/` y `*.iml` (sin borrar reglas existentes). Si lo modificas, incorpóralo al siguiente commit.

## 2.7. Documentar pruebas y actualizar el índice

Al **final** de `unidad-02/tarea3/README.md`, añade una sección titulada `## Desarrollo y pruebas del alumno`. Redacta con tus palabras cómo funciona `do-while`, cómo cuentas aportaciones válidas y qué resultados dieron las pruebas. Explica al menos una dificultad técnica o decisión adoptada.

En `unidad-02/README.md` cambia únicamente la entrada correspondiente a la tarea 3:

```markdown
| [Tarea 3](tarea3/) | Simulador de ahorro personal | Completada |
```

**Quinto commit**, desde la raíz de `dam-pro`:

```bash
git status
git add unidad-02/tarea3/README.md
git add unidad-02/README.md
git diff --cached
git commit -m "docs: finalizar tarea 3 y actualizar indice"
git push origin main
git status
git log --oneline -6
```

Si cambiaste `.gitignore`, añádelo con `git add .gitignore` antes del commit.


---

# Paso 3. Si termina el tiempo de clase: guardar y continuar en casa

**Obligatorio:** si termina la clase y tu programa no está acabado, debes **subir todo el código desarrollado a GitHub antes de salir**, incluso si todavía no compila o le faltan funciones. Completa la tarea desde casa.

## 3.1. Antes de salir del aula

1. Guarda los archivos desde IntelliJ IDEA.
2. Mantén la tarea como **En desarrollo** en el índice, si aún no está terminada.
3. Abre la terminal en la raíz de `dam-pro` y ejecuta:

```bash
git status
git add unidad-02/README.md unidad-02/tarea3/
git diff --cached
git commit -m "wip: guardar avance tarea3 para continuar en casa"
git push origin main
git status
```

`wip` significa *work in progress*. Usa este commit **solo si hay cambios pendientes**; si Git dice que no hay cambios para confirmar, revisa que el último commit ya se haya publicado.

4. Entra en GitHub y verifica que se muestra tu último commit y el código que llevas hecho.

## 3.2. Continuar desde casa

1. Abre IntelliJ IDEA; si en ese ordenador no existe `~/git/dam-pro`, clona el repositorio según el apartado 1.3.
2. Abre la terminal en la raíz del repositorio y sincroniza:

```bash
git status
git fetch origin
git log --oneline HEAD..origin/main
git pull --ff-only origin main
```

3. Abre el proyecto Maven `unidad-02/tarea3`, completa el código y ejecuta las pruebas que faltan.
4. Documenta los resultados y actualiza el índice a **Completada** únicamente al finalizar.
5. Publica los últimos cambios:

```bash
git status
git add unidad-02/README.md unidad-02/tarea3/
git diff --cached
git commit -m "feat: completar tarea3 desde casa"
git push origin main
git status
```

Si ya habías realizado un commit con ese contenido, no hagas un commit vacío: usa un mensaje que describa los cambios reales.

> **Un archivo que solo existe en el ordenador no está entregado**. El profesor comprobará lo publicado en GitHub.

---

# Paso 4. Entrega en Moodle

Publica en Moodle el enlace público directo a tu carpeta:

```text
https://github.com/TU_USUARIO/dam-pro/tree/main/unidad-02/tarea3
```

El profesor revisará la estructura Maven, el `pom.xml`, el código, las pruebas documentadas, el `README.md` completo, el índice actualizado y el historial de commits progresivos. El ejercicio debe desarrollarse desde IntelliJ IDEA en Windows con Git Bash o en Debian con Bash.

## Criterios de evaluación

| Criterio | Puntuación |
|---|---:|
| Repositorio, Maven y README correctamente preparados | 1 |
| Índice de la unidad actualizado | 1 |
| Uso de `Scanner`, `String`, `int` y `float` | 1,5 |
| Repetición correcta mediante `do-while` | 2 |
| Validación de cantidades | 1,5 |
| Acumulador, contador y resumen | 1,5 |
| Pruebas y documentación | 0,5 |
| Commits progresivos y publicación | 1 |
| **Total** | **10** |

## Ampliación voluntaria

Solicita una meta de ahorro (`float`) y muestra cuánto falta para alcanzarla después de cada aportación. Si la meta se alcanza, felicita al usuario. Realiza un commit adicional: `feat: incorporar meta de ahorro`.
