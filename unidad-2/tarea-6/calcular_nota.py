#!/usr/bin/env python3
"""Califica tarea-6 usando XML de JUnit y JavaDoc del código del alumnado.
No modifica código fuente. La claridad de nombres se comprueba además por el profesorado.
"""
from pathlib import Path
import re
import unicodedata
import xml.etree.ElementTree as ET

RAIZ = Path(__file__).resolve().parent
INFORMES = RAIZ / 'target' / 'surefire-reports'
FUENTES = RAIZ / 'src' / 'main' / 'java' / 'es' / 'dampro' / 'unidad2' / 'tarea6'
ALGORITMOS = {
    'InvertirCadena': ('invertir', ['invertir', 'inverso', 'invertida', 'reves']),
    'Palindromo': ('esPalindromo', ['palindromo', 'igual', 'simetrico']),
    'ContadorVocales': ('contarVocales', ['vocales', 'vocal']),
    'SumaDigitos': ('sumarDigitos', ['digitos', 'suma']),
    'MayorNumero': ('obtenerMayor', ['mayor', 'maximo']),
    'BinarioDecimal': ('convertirBinario', ['binario', 'decimal']),
    'Factorial': ('calcularFactorial', ['factorial', 'producto']),
    'NumeroPrimo': ('esPrimo', ['primo', 'divisores']),
    'EcuacionCuadratica': ('calcularDiscriminante', ['discriminante', 'cuadratica']),
    'MediaNumeros': ('calcularMedia', ['media', 'aritmetica']),
}
TOTAL_TESTS_ALGORITMO = 12
TOTAL_TESTS_MAIN = 4


def normalizar(texto):
    sin_acentos = unicodedata.normalize('NFD', texto.lower())
    return ''.join(caracter for caracter in sin_acentos if unicodedata.category(caracter) != 'Mn')


def pruebas_ejecutadas():
    pruebas = {}
    if not INFORMES.exists():
        return pruebas
    for archivo in INFORMES.glob('TEST-*.xml'):
        try:
            raiz = ET.parse(archivo).getroot()
        except ET.ParseError:
            continue
        clase = raiz.attrib.get('name', '').split('.')[-1]
        for caso in raiz.iter('testcase'):
            nombre = caso.attrib.get('name', '').split('(')[0]
            ok = not any(elemento.tag in ('error', 'failure', 'skipped') for elemento in caso)
            pruebas.setdefault(clase, {})[nombre] = ok
    return pruebas


def puntuacion_javadoc(clase, metodo, terminos):
    """Devuelve puntos (clase /0.4, método /0.6) y observaciones."""
    archivo = FUENTES / f'{clase}.java'
    if not archivo.is_file():
        return 0.0, 0.0, 'Archivo no encontrado'
    codigo = archivo.read_text(encoding='utf-8')
    coincidencia_clase = re.search(r'(/\*\*(?:(?!\*/)[\s\S])*\*/)?\s*public\s+final\s+class\s+' + re.escape(clase) + r'\b', codigo)
    bloque_clase = (coincidencia_clase.group(1) or '') if coincidencia_clase else ''
    texto_clase = normalizar(bloque_clase)
    clase_ok = ('TODO' not in bloque_clase and len(re.sub(r'[^\w]+', ' ', texto_clase).strip()) >= 35
                and any(termino in texto_clase for termino in terminos))
    # El JavaDoc debe estar directamente antes del método; no se puntúan comentarios de otras declaraciones.
    regex = (r'(/\*\*(?:(?!\*/)[\s\S])*\*/)?\s*public\s+static\s+[\w\[\]]+\s+'
             + re.escape(metodo) + r'\s*\(([^)]*)\)')
    coincidencia_metodo = re.search(regex, codigo)
    if not coincidencia_metodo:
        return .4 if clase_ok else 0.0, 0.0, 'No se encuentra método público con firma prevista'
    bloque = coincidencia_metodo.group(1) or ''
    parametros = [p.strip().split()[-1] for p in coincidencia_metodo.group(2).split(',') if p.strip()]
    descripcion = re.split(r'@(?:param|return|throws|see|since)\b', bloque, maxsplit=1)[0]
    descripcion_norm = normalizar(descripcion)
    # Descripción (0.30), parámetros (0.15), retorno (0.10) y vocabulario (0.05).
    metodo_pts = 0.0
    if 'TODO' not in bloque and len(re.sub(r'[^\w]+', ' ', descripcion_norm).strip()) >= 45:
        metodo_pts += .30
    if 'TODO' not in bloque and all(re.search(r'@param\s+'+re.escape(p)+r'\b', bloque) for p in parametros):
        metodo_pts += .15
    if 'TODO' not in bloque and '@return' in bloque:
        metodo_pts += .10
    if 'TODO' not in bloque and any(re.search(r'\b'+re.escape(t)+r'\b', descripcion_norm) for t in terminos):
        metodo_pts += .05
    return .4 if clase_ok else 0.0, metodo_pts, ''


def main():
    resultados = pruebas_ejecutadas()
    lineas = ['=== DAM-PRO · UNIDAD 2 · TAREA-6 ===', 'Comando: mvn clean verify -Pnota',
              '', '=== ALGORITMOS (8,00 puntos) ===']
    puntos_algoritmos = 0.0
    for clase in ALGORITMOS:
        ejecutadas = resultados.get(f'{clase}Test', {})
        correctas = sum(ejecutadas.values())
        puntos = .8 * min(correctas, TOTAL_TESTS_ALGORITMO) / TOTAL_TESTS_ALGORITMO
        puntos_algoritmos += puntos
        lineas.append(f'{clase}: {correctas}/{TOTAL_TESTS_ALGORITMO} pruebas; {puntos:.2f}/0.80')

    lineas.extend(['', '=== DOCUMENTACIÓN JAVADOC (1,00 punto) ==='])
    puntos_documentacion = 0.0
    for clase, (metodo, terminos) in ALGORITMOS.items():
        puntos_clase, puntos_metodo, nota = puntuacion_javadoc(clase, metodo, terminos)
        puntos = (puntos_clase + puntos_metodo) / 10
        puntos_documentacion += puntos
        lineas.append(f'{clase}: clase {puntos_clase:.2f}/0.40; función {puntos_metodo:.2f}/0.60; aporta {puntos:.2f}/0.10' + (f' ({nota})' if nota else ''))

    main_tests = resultados.get('MainTest', {})
    main_correctos = sum(main_tests.values())
    puntos_main = min(main_correctos, TOTAL_TESTS_MAIN) / TOTAL_TESTS_MAIN
    lineas.extend(['', '=== PROGRAMA PRINCIPAL (1,00 punto) ===',
                    f'Main: {main_correctos}/{TOTAL_TESTS_MAIN} pruebas; {puntos_main:.2f}/1.00'])
    total = round(puntos_algoritmos + puntos_documentacion + puntos_main, 2)
    lineas.extend(['', f'NOTA AUTOMÁTICA: {total:.2f}/10.00',
                   'Revisión docente: claridad y significado de variables, legibilidad y autoría del código.',
                   'Las pruebas ausentes, omitidas o con error no suman puntos.', ''])
    informe = '\n'.join(lineas)
    carpeta = RAIZ / 'target'
    carpeta.mkdir(exist_ok=True)
    (carpeta / 'notas_por_bloques.txt').write_text(informe, encoding='utf-8')
    print(informe)
    return 0


if __name__ == '__main__':
    raise SystemExit(main())
