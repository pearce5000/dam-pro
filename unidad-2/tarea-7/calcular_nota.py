#!/usr/bin/env python3
"""Corrector automático de Tarea 7: 120 pruebas y 10 bloques JavaDoc."""
from pathlib import Path
import re
import xml.etree.ElementTree as ET
BASE=Path(__file__).resolve().parent
PAQUETE='es.dampro.unidad2.tarea7'
DEFINICIONES={
    'AnalizadorFecha': ('analizarFecha','String',['fecha']),
    'CalculadoraEdad': ('calcularEdad','Period',['nacimiento', 'fechaActual']),
    'CalculadoraVencimientos': ('calcularVencimiento','LocalDate',['fecha', 'dias', 'meses', 'anios']),
    'ValidadorFechas': ('validarFecha','LocalDate',['texto']),
    'CuentaAtrasEvento': ('calcularDiasRestantes','long',['hoy', 'evento']),
    'CalculadoraJornada': ('calcularTiempoTrabajado','Duration',['entrada', 'salida', 'descansoMinutos']),
    'CalculadoraViaje': ('calcularLlegada','LocalDateTime',['salida', 'horas', 'minutos']),
    'ComprobadorReservas': ('haySolapamiento','boolean',['inicio1', 'fin1', 'inicio2', 'fin2']),
    'ProximoCumpleanios': ('calcularProximoCumpleanios','LocalDate',['nacimiento', 'hoy']),
    'ConversorZonasHorarias': ('convertirZona','ZonedDateTime',['fechaOrigen', 'zonaDestino'])
}

def doc_antes(codigo,patron):
    m=re.search(r'/\*\*(?P<doc>.*?)\*/\s*'+patron,codigo,re.S)
    return m.group('doc') if m else ''

def etiqueta(doc,tag,nombre=None):
    for linea in doc.splitlines():
        t=re.sub(r'^\s*\*\s?', '',linea).strip()
        m=re.fullmatch(r'@'+tag+r'\s+(.+)',t)
        if m:
            valor=m.group(1).strip()
            if nombre:
                x=valor.split(None,1)
                if len(x)==2 and x[0]==nombre and x[1].strip():return True
            elif valor:return True
    return False

def doc_puntos(clase,metodo,ret,params):
    path=BASE/'src/main/java'/Path(*PAQUETE.split('.'))/(clase+'.java')
    if not path.is_file():return 0,4+len(params)
    s=path.read_text(encoding='utf-8')
    dc=doc_antes(s,r'public\s+final\s+class\s+'+clase+r'\b')
    firma=r'public\s+static\s+'+ret+r'\s+'+metodo+r'\s*\('
    dm=doc_antes(s,firma)
    checks=[etiqueta(dc,'author'), etiqueta(dc,'version'),etiqueta(dm,'return')]
    checks.extend(etiqueta(dm,'param',p) for p in params)
    # descripción sustantiva no vacía en clase y método (aparte de etiquetas)
    def descripcion(doc):
        return any(t and not t.startswith('@') and not t.startswith('TODO') for t in (re.sub(r'^\s*\*\s?','',x).strip() for x in doc.splitlines()))
    checks.append(descripcion(dc) and descripcion(dm))
    return sum(checks),len(checks)

def casos(clase):
    f=BASE/'target/surefire-reports'/f'TEST-{PAQUETE}.{clase}Test.xml'
    if not f.exists():return 0
    try:
        root=ET.parse(f).getroot();ok=set()
        for t in root.iter('testcase'):
            n=t.get('name','')
            if re.fullmatch(r'caso\d\d',n) and not any(x.tag.split('}')[-1] in ('failure','error','skipped') for x in t):ok.add(n)
        return len(ok.intersection({f'caso{i:02}' for i in range(1,13)}))
    except (OSError,ET.ParseError):return 0

def main():
    total=0.0
    salida=['TAREA 7 · CORRECCIÓN AUTOMÁTICA','Funcionalidad: 8 puntos · JavaDoc: 2 puntos','']
    md=['# Rúbrica Tarea 7','', '| Clase | Tests | Funcionalidad /0.80 | JavaDoc /0.20 | Total /1.00 |','|---|---:|---:|---:|---:|']
    for clase,(metodo,ret,params) in DEFINICIONES.items():
        n=casos(clase);d,m=doc_puntos(clase,metodo,ret,params);nf=.8*n/12;nd=.2*d/m;total+=nf+nd
        salida.append(f'{clase}: {n}/12 tests ({nf:.3f}/0.800) · JavaDoc {d}/{m} ({nd:.3f}/0.200) · subtotal {nf+nd:.3f}/1.000')
        md.append(f'| {clase} | {n}/12 | {nf:.3f} | {nd:.3f} | {nf+nd:.3f} |')
    salida.extend(['',f'NOTA AUTOMÁTICA: {total:.2f}/10.00','Revisión docente: contenido de Javadoc, legibilidad, restricciones y Main.'])
    md.extend([f'| **TOTAL** | | | | **{total:.2f}/10.00** |','', 'La puntuación de JavaDoc es por presencia de etiquetas y descripción. La calidad se revisa manualmente.'])
    (BASE/'target').mkdir(exist_ok=True)
    (BASE/'target/notas_por_bloques.txt').write_text('\n'.join(salida)+'\n',encoding='utf8')
    (BASE/'target/rubrica.md').write_text('\n'.join(md)+'\n',encoding='utf8')
    print('\n'.join(salida))
if __name__=='__main__':main()
