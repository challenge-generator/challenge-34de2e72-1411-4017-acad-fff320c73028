# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/test/resources/features/security_validation.feature` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/pragma/loansecurity/runners/RunSecurityTests.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/pragma/loansecurity/steps/SecurityValidationSteps.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/pragma/loansecurity/tasks/ScanForVulnerabilities.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/pragma/loansecurity/questions/VulnerabilityResults.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/pragma/loansecurity/interactions/CallApi.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/pragma/loansecurity/models/SecurityReport.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/pragma/loansecurity/exceptions/SecurityValidationException.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/pragma/loansecurity/utils/SecurityValidator.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/pragma/loansecurity/utils/JwtUtils.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `checklists/owasp_security_checklist.md` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `reports/security_report_sample.md` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/pragma/loansecurity/config/SecurityConfig.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/pragma/loansecurity/interactions/Authenticate.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Archivos que la arquitectura del reto declara y no estan

Creálos con implementacion real, en la capa que les corresponde:

- `RunCucumberTest.java`

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/test/java/com/pragma/loansecurity/utils/SecurityValidator.java` — `org.owasp.encoder`: El import org.owasp.encoder.Encode pertenece a org.owasp.encoder, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/pragma/loansecurity/config/SecurityConfig.java` — `org.springframework.stereotype`: El import org.springframework.stereotype.Component pertenece a org.springframework.stereotype, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `pom.xml` — `org.owasp.zap:zap-clientapi@1.12.0`: org.owasp.zap:zap-clientapi declara la version 1.12.0, pero Maven Central respondio que esa version no existe. Es una version inventada: reemplazala por una version publicada real, o si no se conoce con certeza, usa el mecanismo centralizado del ecosistema (BOM/parent/platform/version catalog) y no declares una version individual.
- `pom.xml` — `net.serenity-bdd:serenity-bdd-bom@4.1.6`: net.serenity-bdd:serenity-bdd-bom declara la version 4.1.6, pero Maven Central respondio que esa version no existe. Es una version inventada: reemplazala por una version publicada real, o si no se conoce con certeza, usa el mecanismo centralizado del ecosistema (BOM/parent/platform/version catalog) y no declares una version individual.

## Como saber que terminaste

```bash
mvn clean test-compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Calidad de Software, Especialidad Automatizador, Tecnología QA Security, Senior

### Brecha de conocimiento
Realiza validaciones mínimas de seguridad conforme al marco de OWASP 2017-2021 y socializa los resultados en los proyectos, apoyado en el checklist diseñado para este propósito.

### Misión / candidato
Candidato con experiencia como automatizador QA, enfocado en garantizar la calidad y seguridad de los proyectos.

### Reto
- Tema: Ejecución de Pruebas de Seguridad
- Seniority: senior-l2
- Tipo: practical
- Título: Implementación de Validaciones de Seguridad en Proyectos
- Tiempo estimado: 2 semanas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Identificación de Vulnerabilidades — objetivo: Identificar las vulnerabilidades de seguridad presentes en el sistema de gestión de préstamos. — entregable (NO resolver): Lista de vulnerabilidades identificadas en el sistema.
- Fase 2: Diseño de Pruebas de Seguridad — objetivo: Diseñar pruebas de seguridad para validar las vulnerabilidades identificadas. — entregable (NO resolver): Conjunto de pruebas de seguridad diseñadas para validar las vulnerabilidades identificadas.
- Fase 3: Ejecución y Socialización de Resultados — objetivo: Ejecutar las pruebas de seguridad y socializar los resultados en los proyectos. — entregable (NO resolver): Informe de resultados de las pruebas de seguridad socializado en los proyectos.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.pragma</groupId>
    <artifactId>loansecurity</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <serenity.version>4.1.6</serenity.version>
        <cucumber.version>7.15.0</cucumber.version>
        <junit.version>5.10.2</junit.version>
        <restassured.version>5.4.0</restassured.version>
        <selenium.version>4.22.0</selenium.version>
        <lombok.version>1.18.30</lombok.version>
        <owasp.zap.version>1.12.0</owasp.zap.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>net.serenity-bdd</groupId>
                <artifactId>serenity-bdd-bom</artifactId>
                <version>${serenity.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <!-- Serenity BDD -->
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-core</artifactId>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-junit5</artifactId>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-cucumber</artifactId>
        </dependency>

        <!-- OWASP ZAP -->
        <dependency>
            <groupId>org.owasp.zap</groupId>
            <artifactId>zap-clientapi</artifactId>
            <version>${owasp.zap.version}</version>
        </dependency>

        <!-- Cucumber -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>${cucumber.version}</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit-platform-engine</artifactId>
            <version>${cucumber.version}</version>
        </dependency>

        <!-- JUnit 5 -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>${junit.version}</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>${junit.version}</version>
            <scope>runtime</scope>
        </dependency>

        <!-- Rest Assured -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>${restassured.version}</version>
        </dependency>

        <!-- Selenium -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>${selenium.version}</version>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>${lombok.version}</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.2.5</version>
                <configuration>
                    <includes>
                        <include>**/*Test.java</include>
                        <include>**/*Tests.java</include>
                        <include>**/Run*.java</include>
                    </includes>
                </configuration>
            </plugin>
            <plugin>
                <groupId>net.serenity-bdd</groupId>
                <artifactId>serenity-maven-plugin</artifactId>
                <version>${serenity.version}</version>
                <executions>
                    <execution>
                        <id>serenity-reports</id>
                        <phase>post-integration-test</phase>
                        <goals>
                            <goal>aggregate</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/test/java/com/pragma/loansecurity/models/SecurityReport.java ===
package com.pragma.loansecurity.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Modelo de datos para estructurar los resultados de las pruebas de seguridad.
 * Contiene información sobre vulnerabilidades detectadas, severidad y recomendaciones.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecurityReport {
    private String scanId;
    private String targetUrl;
    private String scanDate;
    private List<Vulnerability> vulnerabilities;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Vulnerability {
        private String id;
        private String name;
        private String description;
        private String severity;
        private String solution;
        private List<String> references;
        private String cweId;
        private String risk;
    }
}

// === ARCHIVO: src/test/java/com/pragma/loansecurity/runners/RunCucumberTest.java ===
package com.pragma.loansecurity.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Runner de Cucumber con integración de Serenity BDD para la ejecución
 * de pruebas de seguridad basadas en el marco OWASP 2017-2021.
 * 
 * Este runner configura la ejecución de escenarios Gherkin con reporte
 * detallado de Serenity para visualización de resultados de seguridad.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {
        "com.pragma.loansecurity.steps",
        "com.pragma.loansecurity.interactions",
        "com.pragma.loansecurity.hooks"
    },
    plugin = {
        "pretty",
        "html:target/cucumber/serenity-report.html",
        "json:target/cucumber/serenity-report.json",
        "junit:target/cucumber/serenity-report.xml"
    },
    tags = "not @wip",
    strict = true,
    monochrome = false
)
public class RunCucumberTest {
    
    /**
     * Constructor por defecto requerido por JUnit para la ejecución del runner.
     * La configuración de las opciones de Cucumber se realiza mediante anotaciones
     * en la clase, permitiendo la integración con Serenity para la generación
     * de reportes HTML y JSON con evidencia visual de cada paso ejecutado.
     * 
     * La configuración de features indica que todos los archivos .feature
     * encontrados en el directorio src/test/resources/features serán
     * considerados para ejecución, permitiendo la organización de pruebas
     * de seguridad por categoría (SQL Injection, XSS, OWASP Top 10, etc.).
     * 
     * El paquete glue especifica las ubicaciones de los step definitions,
     * interacciones personalizadas y hooks de Serenity que conectan los
     * pasos Gherkin con las implementaciones de tareas y preguntas del
     * patrón Screenplay.
     * 
     * Los plugins configurados generan múltiples formatos de reporte para
     * facilitar la integración con pipelines de CI/CD y herramientas de
     * gestión de calidad como JIRA XRAY o Azure DevOps Test Plans.
     */
    public RunCucumberTest() {
        super();
    }
}

// === ARCHIVO: src/test/resources/config/serenity.conf ===
webdriver {
  driver = chrome
  auto.download = true
  wait.for.timeout = 10000
  chrome.switches = "--no-sandbox,--disable-dev-shm-usage,--disable-gpu,--headless"
}

serenity {
  test.root.directories = "src/test/resources/features"
  take.screenshots = AFTER_EACH_STEP
  compress.screenshots = false
  report.show.related.issues = true
  
  rest {
    base.url = "http://localhost:8080"
    timeout = 30000
    retry.enabled = true
    retry.attempts = 3
    proxy.enabled = false
  }
}

environments {
  default = "local"
  
  local {
    webdriver.base.url = "http://localhost:8080"
    api.base.url = "http://localhost:8080/api"
    zap.proxy.host = "localhost"
    zap.proxy.port = 8080
    zap.api.key = ""
    zap.spider.max.depth = 5
    zap.spider.max.children = 100
    zap.ascan.max.duration = 60
  }
  
  dev {
    webdriver.base.url = "https://dev.loansecurity.pragma.com.co"
    api.base.url = "https://dev.loansecurity.pragma.com.co/api"
    zap.proxy.host = "zap-dev.pragma.com.co"
    zap.proxy.port = 8080
    zap.api.key = "${ZAP_API_KEY}"
    zap.spider.max.depth = 10
    zap.spider.max.children = 500
    zap.ascan.max.duration = 120
  }
  
  qa {
    webdriver.base.url = "https://qa.loansecurity.pragma.com.co"
    api.base.url = "https://qa.loansecurity.pragma.com.co/api"
    zap.proxy.host = "zap-qa.pragma.com.co"
    zap.proxy.port = 8080
    zap.api.key = "${ZAP_API_KEY}"
    zap.spider.max.depth = 10
    zap.spider.max.children = 500
    zap.ascan.max.duration = 180
  }
  
  prod {
    webdriver.base.url = "https://loansecurity.pragma.com.co"
    api.base.url = "https://loansecurity.pragma.com.co/api"
    zap.proxy.host = "zap-prod.pragma.com.co"
    zap.proxy.port = 8080
    zap.api.key = "${ZAP_API_KEY}"
    zap.spider.max.depth = 15
    zap.spider.max.children = 1000
    zap.ascan.max.duration = 300
  }
}

zap {
  integration.enabled = true
  api.url = "http://localhost:8080"
  api.key = ""
  spider.enabled = true
  active.scan.enabled = true
  passive.scan.enabled = true
  report.format = JSON
  alert.threshold = HIGH
  
  exclusions {
    urls = [
      ".*\\.css",
      ".*\\.js",
      ".*\\.png",
      ".*\\.jpg",
      ".*\\.woff2",
      "/health",
      "/actuator/.*"
    ]
  }
  
  authentication {
    enabled = true
    login.url = "/auth/login"
    username.field = "username"
    password.field = "password"
    session.header = "Authorization"
  }
}

reporting {
  output.formats = ["HTML", "JSON"]
  history.enabled = true
  history.directory = "target/site/serenity"
  
  security {
    include.zap.report = true
    vulnerability.severity.colors = {
      "HIGH": "#FF0000",
      "MEDIUM": "#FFA500",
      "LOW": "#FFFF00",
      "INFORMATIONAL": "#ADD8E6"
    }
  }
}

// === ARCHIVO: src/test/resources/features/security_validation.feature ===
#language: es
Característica: Validacion de Seguridad en Sistema de Prestamos
  Como tester de seguridad
  Necesito ejecutar pruebas de vulnerabilidad sobre el sistema de gestion de prestamos
  Para identificar y documentar debilidades de seguridad antes de produccion

  # Superficie de practica: completar con escenarios basados en OWASP Top 10 2017-2021
  # El sistema bajo prueba es un sistema de gestion de prestamos para entidad financiera
  # Los actores principales son: originador de creditos, motor antifraude, buró de riesgos, core bancario

  @security @owasp-a1 @sql-injection
  Escenario: Validar proteccion contra inyeccion SQL en endpoint de consulta de prestamos
    Dado que el sistema esta disponible
    Cuando realizo una peticion con payload malicioso contendo "' OR '1'='1"
    Entonces el sistema debe rechazar la peticion con codigo de error
    Y debe registrar el intento en logs de seguridad

  @security @owasp-a2 @broken-auth
  Escenario: Validar proteccion contra autenticacion debil en acceso a prestamos
    Dado que el sistema esta disponible
    Cuando intento autenticarme con credenciales por defecto "admin"
    Entonces el sistema debe rechazar la autenticacion
    Y debe implementar politica de bloqueo despues de 3 intentos fallidos

  @security @owasp-a3 @sensitive-data
  Escenario: Validar proteccion de datos sensibles en respuestas de API
    Dado que el sistema procesa solicitudes de prestamo
    Cuando consulto los detalles de un prestamo
    Entonces los datos sensibles deben estar cifrados
    Y no deben exponerse en logs o respuestas sin cifrar

  @security @owasp-a4 @xxe
  Escenario: Validar proteccion contra XXE en procesamiento de documentos
    Dado que el sistema acepta documentos XML para validacion de prestamos
    Cuando envio un documento con entidades externas maliciosas
    Entonces el sistema debe rechazar el documento
    Y debe registrar el intento de ataque

  @security @owasp-a5 @broken-access-control
  Escenario: Validar control de acceso en consulta de prestamos de otros usuarios
    Dado que estoy autenticado como usuario con rol de cliente
    Cuando intento acceder a prestamos de otro usuario mediante manipulacion de ID
    Entonces el sistema debe denegar el acceso
    Y debe registrar el intento de acceso no autorizado

  @security @owasp-a6 @security-misconfiguration
  Escenario: Validar que endpoints de diagnostico no expongan informacion sensible
    Dado que el sistema esta desplegado
    Cuando accedo al endpoint de health check
    Entonces no debe exponer informacion de configuracion interna
    Y no debe mostrar stack traces en respuestas de error

  @security @owasp-a7 @xss
  Escenario: Validar proteccion contra XSS en campos de formulario de prestamo
    Dado que el sistema permite registro de solicitudes de prestamo
    Cuando ingreso codigo JavaScript en campos de texto "<script>alert(1)</script>"
    Entonces el sistema debe sanitizar o rechazar el input
    Y debe escapar caracteres especiales en respuestas

  @security @owasp-a8 @deserialization
  Escenario: Validar proteccion contra deserializacion insegura
    Dado que el sistema procesa objetos serializados
    Cuando recibo un payload serializado malicioso
    Entonces el sistema debe validar y rechazar objetos no confiables
    Y debe usar serializacion segura o JSON

  @security @owasp-a9 @vulnerable-components
  Escenario: Validar que componentes terceros no tengan vulnerabilidades conocidas
    Dado que el sistema utiliza librerias externas
    Cuando realizo el analisis de dependencias
    Entonces no deben existir vulnerabilidades con severidad alta o critica
    Y todas las librerias deben estar actualizadas

  @security @owasp-a10 @logging
  Escenario: Validar que logs no contengan informacion sensible
    Dado que el sistema procesa solicitudes de prestamo
    Cuando realizo operaciones con datos de clientes
    Entonces los logs no deben contener numeros de identificacion completos
    Y no deben contener tokens de sesion o contraseñas

  @security @rate-limiting
  Escenario: Validar proteccion contra ataques de fuerza bruta
    Dado que el sistema ofrece endpoint de autenticacion
    Cuando realizo mas de 10 intentos de login en un minuto
    Entonces el sistema debe implementar limitacion de tasa
    Y debe bloquear temporalmente las requests del origen

  @security @api-security
  Escenario: Validar que API REST implementa buenas practicas de seguridad
    Dado que consumo los endpoints de la API de prestamos
    Cuando realizo peticines sin headers de seguridad
    Entonces la API debe requerir Content-Type
    Y debe implementar CORS con origenes confiables
    Y debe设置了Headers de seguridad (X-Content-Type-Options, X-Frame-Options)

// === ARCHIVO: src/test/java/com/pragma/loansecurity/runners/RunSecurityTests.java ===
package com.pragma.loansecurity.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

/**
 * Runner para ejecutar pruebas de seguridad basadas en OWASP.
 *
 * Superficie de practica: este archivo debe ser completado por el estudiante
 * para integrar correctamente OWASP ZAP con Serenity BDD y generar reportes.
 *
 * Configuracion base: JUnit 5 + Cucumber + Serenity BDD
 *
 * Para ejecutar: mvn test -Dtest=RunSecurityTests
 */
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.pragma.loansecurity.steps"},
    tags = "@security",
    plugin = {
        "pretty",
        "json:target/cucumber-reports/security-cucumber.json",
        "html:target/cucumber-reports/security-cucumber.html"
    },
    monochrome = true
)
public class RunSecurityTests extends CucumberWithSerenity {

    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        core.addListener(new RunListener() {
            @Override
            public void testRunStarted(Description description) {
                System.out.println("========================================");
                System.out.println("Iniciando suite de pruebas de seguridad");
                System.out.println("OWASP 2017-2021 Validation");
                System.out.println("========================================");
            }

            @Override
            public void testRunFinished(Result result) {
                System.out.println("========================================");
                System.out.println("Suite de pruebas de seguridad finalizada");
                System.out.println("Tests ejecutados: " + result.getRunCount());
                System.out.println("Fallidos: " + result.getFailureCount());
                System.out.println("Ignorados: " + result.getIgnoreCount());
                System.out.println("========================================");

                if (result.wasSuccessful()) {
                    System.out.println("RESULTADO: TODAS LAS PRUEBAS DE SEGURIDAD PASARON");
                } else {
                    System.out.println("RESULTADO: SE DETECTARON FALLOS EN PRUEBAS DE SEGURIDAD");
                    result.getFailures().forEach(failure -> {
                        System.out.println("  - " + failure.getMessage());
                    });
                }
            }
        });

        core.run(RunSecurityTests.class);
    }
}

// === ARCHIVO: src/test/java/com/pragma/loansecurity/steps/SecurityValidationSteps.java ===
package com.pragma.loansecurity.steps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entao;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

public class SecurityValidationSteps {

    @Dado("que el usuario {actor} tiene acceso al sistema de gestión de préstamos")
    public void queElUsuarioTieneAccesoAlSistema(Actor actor) {
        // Stub: El estudiante debe implementar la verificación de acceso
    }

    @Cuando("el usuario {actor} ejecuta un escaneo de vulnerabilidades")
    public void elUsuarioEjecutaEscaneoDeVulnerabilidades(Actor actor) {
        // Stub: El estudiante debe implementar la tarea de escaneo
    }

    @Y("el escaneo se realiza contra la URL {string}")
    public void elEscaneoSeRealizaContraLaURL(String targetUrl) {
        // Stub: El estudiante debe configurar el target del escaneo
    }

    @Entao("el sistema debe mostrar las vulnerabilidades identificadas")
    public void elSistemaDebeMostrarLasVulnerabilidadesIdentificadas() {
        // Stub: El estudiante debe implementar la validación de resultados
    }

    @Y("el informe debe incluir vulnerabilidades críticas")
    public void elInformeDebeIncluirVulnerabilidadesCriticas() {
        // Stub: El estudiante debe verificar el nivel de criticidad
    }

    @Y("la cantidad de vulnerabilidades debe ser mayor a {int}")
    public void laCantidadDeVulnerabilidadesDebeSerMayorA(int cantidad) {
        // Stub: El estudiante debe implementar la verificación de cantidad
    }

    @Dado("que el sistema de gestión de préstamos procesa {int} solicitudes por segundo")
    public void queElSistemaProcesaSolicitudesPorSegundo(int solicitudes) {
        // Stub: El estudiante debe configurar el volumen de prueba
    }

    @Cuando("el usuario {actor} ejecuta pruebas de rendimiento de seguridad")
    public void elUsuarioEjecutaPruebasDeRendimiento(Actor actor) {
        // Stub: El estudiante debe implementar las pruebas de carga
    }

    @Entao("el tiempo de respuesta debe ser menor a {int} milisegundos")
    public void elTiempoDeRespuestaDebeSerMenorA(int milisegundos) {
        // Stub: El estudiante debe verificar el SLA
    }

    @Y("la disponibilidad debe ser del {string}")
    public void laDisponibilidadDebeSerDel(String porcentaje) {
        // Stub: El estudiante debe validar el uptime
    }
}

// === ARCHIVO: src/test/java/com/pragma/loansecurity/tasks/ScanForVulnerabilities.java ===
package com.pragma.loansecurity.tasks;

import net.serenitybdd.core.time.StopWatch;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.questions.ResponseQuestion;
import org.owasp.zap.clientapi.ZapClient;
import org.owasp.zap.clientapi.ZapSpider;
import org.owasp.zap.clientapi.ZapAscan;

import java.time.Duration;

public class ScanForVulnerabilities implements Task {

    private final String targetUrl;
    private final String scanType;
    private final int maxDuration;

    public ScanForVulnerabilities(String targetUrl, String scanType, int maxDuration) {
        this.targetUrl = targetUrl;
        this.scanType = scanType;
        this.maxDuration = maxDuration;
    }

    public static ScanForVulnerabilities against(String targetUrl) {
        return new ScanForVulnerabilities(targetUrl, "ACTIVE", 300);
    }

    public static ScanForVulnerabilities withType(String targetUrl, String scanType) {
        return new ScanForVulnerabilities(targetUrl, scanType, 300);
    }

    public ScanForVulnerabilities withMaxDuration(int seconds) {
        return new ScanForVulnerabilities(targetUrl, scanType, seconds);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Stub: El estudiante debe implementar la lógica de escaneo con OWASP ZAP
        // Pasos esperados:
        // 1. Inicializar el cliente ZAP
        // 2. Configurar el spider para descubrir endpoints
        // 3. Ejecutar el escaneo activo
        // 4. Recolectar los resultados
        // 5. Almacenar el informe para validación posterior
    }

    public static ScanForVulnerabilities withSpiderScan(String targetUrl) {
        return new ScanForVulnerabilities(targetUrl, "SPIDER", 180);
    }

    public static ScanForVulnerabilities withActiveScan(String targetUrl) {
        return new ScanForVulnerabilities(targetUrl, "ACTIVE", 600);
    }

    public static ScanForVulnerabilities withAjaxScan(String targetUrl) {
        return new ScanForVulnerabilities(targetUrl, "AJAX", 300);
    }
}

// === ARCHIVO: src/test/java/com/pragma/loansecurity/questions/VulnerabilityResults.java ===
package com.pragma.loansecurity.questions;


import com.pragma.loansecurity.models.Vulnerability;
import com.pragma.loansecurity.models.SecurityReport;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.util.List;
import java.util.stream.Collectors;

public class VulnerabilityResults implements Question<List<SecurityReport.Vulnerability>> {

    private final String filterBySeverity;

    public VulnerabilityResults(String filterBySeverity) {
        this.filterBySeverity = filterBySeverity;
    }

    public static Question<List<SecurityReport.Vulnerability>> found() {
        return new VulnerabilityResults(null);
    }

    public static Question<List<SecurityReport.Vulnerability>> critical() {
        return new VulnerabilityResults("CRITICAL");
    }

    public static Question<List<SecurityReport.Vulnerability>> high() {
        return new VulnerabilityResults("HIGH");
    }

    public static Question<List<SecurityReport.Vulnerability>> withSeverity(String severity) {
        return new VulnerabilityResults(severity);
    }

    @Override
    public List<SecurityReport.Vulnerability> answeredBy(Actor actor) {
        // Stub: El estudiante debe implementar la lógica de extracción de resultados
        // Pasos esperados:
        // 1. Obtener la última respuesta del API
        // 2. Deserializar el informe de seguridad
        // 3. Aplicar filtro por severidad si aplica
        // 4. Retornar la lista de vulnerabilidades
        return null;
    }

    public static Question<Integer> count() {
        return new Question<Integer>() {
            @Override
            public Integer answeredBy(Actor actor) {
                // Stub: Contar vulnerabilidades encontradas
                return 0;
            }
        };
    }

    public static Question<Boolean> hasVulnerabilities() {
        return actor -> {
            // Stub: Verificar si hay vulnerabilidades
            return false;
        };
    }

    public static Question<Boolean> meetsSla(double targetUptime) {
        return actor -> {
            // Stub: Verificar cumplimiento de SLA
            return false;
        };
    }

    public static Question<Double> responseTime() {
        return actor -> {
            // Stub: Obtener tiempo de respuesta promedio
            return 0.0;
        };
    }
}

// === ARCHIVO: src/test/java/com/pragma/loansecurity/interactions/CallApi.java ===
package com.pragma.loansecurity.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class CallApi implements Interaction {

    private final String endpoint;
    private final String method;
    private final Map<String, String> headers;
    private final String body;

    public CallApi(String endpoint, String method, Map<String, String> headers, String body) {
        this.endpoint = endpoint;
        this.method = method;
        this.headers = headers;
        this.body = body;
    }

    public static CallApiBuilder to(String endpoint) {
        return new CallApiBuilder(endpoint);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        String baseUrl = CallAnApi.as(actor).getBaseUri();
        String fullUrl = baseUrl + endpoint;

        Response response;

        switch (method.toUpperCase()) {
            case "GET":
                response = io.restassured.RestAssured.given()
                        .headers(headers != null ? headers : new HashMap<>())
                        .when()
                        .get(fullUrl);
                break;
            case "POST":
                response = io.restassured.RestAssured.given()
                        .headers(headers != null ? headers : new HashMap<>())
                        .body(body)
                        .contentType("application/json")
                        .when()
                        .post(fullUrl);
                break;
            case "PUT":
                response = io.restassured.RestAssured.given()
                        .headers(headers != null ? headers : new HashMap<>())
                        .body(body)
                        .contentType("application/json")
                        .when()
                        .put(fullUrl);
                break;
            case "DELETE":
                response = io.restassured.RestAssured.given()
                        .headers(headers != null ? headers : new HashMap<>())
                        .when()
                        .delete(fullUrl);
                break;
            default:
                throw new IllegalArgumentException("Método HTTP no soportado: " + method);
        }

        actor.remember("lastResponse", response);
    }

    public static class CallApiBuilder {
        private final String endpoint;
        private String method = "GET";
        private Map<String, String> headers = new HashMap<>();
        private String body;

        public CallApiBuilder(String endpoint) {
            this.endpoint = endpoint;
        }

        public CallApiBuilder withMethod(String method) {
            this.method = method;
            return this;
        }

        public CallApiBuilder withHeaders(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public CallApiBuilder withBody(String body) {
            this.body = body;
            return this;
        }

        public CallApi build() {
            return Instrumented.instanceOf(CallApi.class)
                    .withProperties(endpoint, method, headers, body);
        }
    }
}

// === ARCHIVO: src/test/java/com/pragma/loansecurity/exceptions/SecurityValidationException.java ===
package com.pragma.loansecurity.exceptions;

public class SecurityValidationException extends RuntimeException {

    private final String vulnerabilityType;
    private final String severity;
    private final String targetEndpoint;

    public SecurityValidationException(String message) {
        super(message);
        this.vulnerabilityType = "UNKNOWN";
        this.severity = "INFO";
        this.targetEndpoint = "UNKNOWN";
    }

    public SecurityValidationException(String message, Throwable cause) {
        super(message, cause);
        this.vulnerabilityType = "UNKNOWN";
        this.severity = "INFO";
        this.targetEndpoint = "UNKNOWN";
    }

    public SecurityValidationException(String message, String vulnerabilityType, String severity) {
        super(message);
        this.vulnerabilityType = vulnerabilityType;
        this.severity = severity;
        this.targetEndpoint = "UNKNOWN";
    }

    public SecurityValidationException(String message, String vulnerabilityType, String severity, String targetEndpoint) {
        super(message);
        this.vulnerabilityType = vulnerabilityType;
        this.severity = severity;
        this.targetEndpoint = targetEndpoint;
    }

    public SecurityValidationException(String message, String vulnerabilityType, String severity, String targetEndpoint, Throwable cause) {
        super(message, cause);
        this.vulnerabilityType = vulnerabilityType;
        this.severity = severity;
        this.targetEndpoint = targetEndpoint;
    }

    public String getVulnerabilityType() {
        return vulnerabilityType;
    }

    public String getSeverity() {
        return severity;
    }

    public String getTargetEndpoint() {
        return targetEndpoint;
    }

    public boolean isCritical() {
        return "CRITICAL".equalsIgnoreCase(severity) || "HIGH".equalsIgnoreCase(severity);
    }

    public static SecurityValidationException forInjection(String endpoint) {
        return new SecurityValidationException(
                "Posible inyección detectada en el endpoint: " + endpoint,
                "SQL_INJECTION",
                "HIGH",
                endpoint
        );
    }

    public static SecurityValidationException forXss(String endpoint) {
        return new SecurityValidationException(
                "Posible Cross-Site Scripting (XSS) detectado en: " + endpoint,
                "XSS",
                "HIGH",
                endpoint
        );
    }

    public static SecurityValidationException forSensitiveDataExposure(String endpoint) {
        return new SecurityValidationException(
                "Exposición de datos sensibles detectada en: " + endpoint,
                "SENSITIVE_DATA_EXPOSURE",
                "CRITICAL",
                endpoint
        );
    }

    public static SecurityValidationException forAuthenticationFailure(String endpoint) {
        return new SecurityValidationException(
                "Fallo en autenticación detectado en: " + endpoint,
                "AUTHENTICATION_FAILURE",
                "MEDIUM",
                endpoint
        );
    }
}

// === ARCHIVO: src/test/java/com/pragma/loansecurity/utils/SecurityValidator.java ===
package com.pragma.loansecurity.utils;

import com.pragma.loansecurity.exceptions.SecurityValidationException;
import io.restassured.response.Response;
import org.owasp.encoder.Encode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SecurityValidator {

    private static final List<String> OWASP_2017_CATEGORIES = Arrays.asList(
            "A1:2017-Injection",
            "A2:2017-Broken Authentication",
            "A3:2017-Sensitive Data Exposure",
            "A4:2017-XML External Entities (XXE)",
            "A5:2017-Broken Access Control",
            "A6:2017-Security Misconfiguration",
            "A7:2017-Cross-Site Scripting (XSS)",
            "A8:2017-Insecure Deserialization",
            "A9:2017-Using Components with Known Vulnerabilities",
            "A10:2017-Insufficient Logging & Monitoring"
    );

    private static final List<String> OWASP_2021_CATEGORIES = Arrays.asList(
            "A01:2021-Broken Access Control",
            "A02:2021-Cryptographic Failures",
            "A03:2021-Injection",
            "A04:2021-Insecure Design",
            "A05:2021-Security Misconfiguration",
            "A06:2021-Vulnerable and Outdated Components",
            "A07:2021-Identification and Authentication Failures",
            "A08:2021-Software and Data Integrity Failures",
            "A09:2021-Security Logging and Monitoring Failures",
            "A10:2021-Server-Side Request Forgery"
    );

    private static final Pattern SQL_INJECTION_PATTERN = Pattern.compile(
            "(?i)(union.*select|select.*from|insert.*into|delete.*from|drop.*table|' or '1'='1|--)"
    );

    private static final Pattern XSS_PATTERN = Pattern.compile(
            "(?i)(<script|javascript:|onerror=|onload=|alert\(|document\.|eval\()"
    );

    private static final Pattern COMMAND_INJECTION_PATTERN = Pattern.compile(
            "(?i)(;|\||`|\$\(|&&|\|\|)"
    );

    private static final List<String> SENSITIVE_HEADERS = Arrays.asList(
            "Authorization",
            "Cookie",
            "Set-Cookie",
            "X-API-Key",
            "X-Auth-Token"
    );

    public static void validateResponseHeaders(Response response) {
        Map<String, String> headers = response.getHeaders().asMap();

        if (!headers.containsKey("X-Content-Type-Options")) {
            throw SecurityValidationException.forSensitiveDataExposure("Missing X-Content-Type-Options header");
        }

        if (!headers.containsKey("X-Frame-Options")) {
            throw SecurityValidationException.forSensitiveDataExposure("Missing X-Frame-Options header");
        }

        if (!headers.containsKey("Strict-Transport-Security")) {
            throw SecurityValidationException.forSensitiveDataExposure("Missing HSTS header");
        }

        if (!headers.containsKey("Content-Security-Policy")) {
            throw SecurityValidationException.forSensitiveDataExposure("Missing CSP header");
        }
    }

    public static void validatePayloadSecurity(String payload) {
        if (payload == null || payload.isEmpty()) {
            return;
        }

        if (SQL_INJECTION_PATTERN.matcher(payload).find()) {
            throw SecurityValidationException.forInjection("Input payload");
        }

        if (XSS_PATTERN.matcher(payload).find()) {
            throw SecurityValidationException.forXss("Input payload");
        }

        if (COMMAND_INJECTION_PATTERN.matcher(payload).find()) {
            throw new SecurityValidationException(
                    "Posible inyección de comandos detectada",
                    "COMMAND_INJECTION",
                    "CRITICAL",
                    "Input payload"
            );
        }
    }

    public static void validateToken(String token, String tokenType) {
        if (token == null || token.isEmpty()) {
            throw new SecurityValidationException(
                    "Token no proporcionado",
                    "MISSING_TOKEN",
                    "HIGH"
            );
        }

        if ("JWT".equalsIgnoreCase(tokenType)) {
            validateJwtToken(token);
        } else if ("API_KEY".equalsIgnoreCase(tokenType)) {
            validateApiKey(token);
        }
    }

    private static void validateJwtToken(String token) {
        String[] parts = token.split("\\.");
        if (parts.length != 3) {
            throw new SecurityValidationException(
                    "Formato JWT inválido",
                    "INVALID_TOKEN",
                    "HIGH"
            );
        }

        String header = new String(java.util.Base64.getDecoder().decode(parts[0]));
        if (!header.contains("alg") || header.contains("\"alg\":\"none\"")) {
            throw new SecurityValidationException(
                    "JWT con algoritmo débil o none",
                    "WEAK_JWT_ALGORITHM",
                    "CRITICAL"
            );
        }
    }

    private static void validateApiKey(String apiKey) {
        if (apiKey.length() < 32) {
            throw new SecurityValidationException(
                    "API Key demasiado corta",
                    "WEAK_API_KEY",
                    "MEDIUM"
            );
        }

        if (apiKey.matches("^[a-zA-Z0-9]+$")) {
            throw new SecurityValidationException(
                    "API Key no contiene caracteres especiales suficientes",
                    "WEAK_API_KEY",
                    "MEDIUM"
            );
        }
    }

    public static Map<String, Boolean> validateAgainstOwasp2017(String payload) {
        Map<String, Boolean> results = new HashMap<>();

        results.put("A1:2017-Injection", SQL_INJECTION_PATTERN.matcher(payload).find());
        results.put("A3:2017-Sensitive Data Exposure", containsSensitiveData(payload));
        results.put("A7:2017-Cross-Site Scripting (XSS)", XSS_PATTERN.matcher(payload).find());

        return results.entrySet().stream()
                .filter(Map.Entry::getValue)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, Boolean> validateAgainstOwasp2021(String payload) {
        Map<String, Boolean> results = new HashMap<>();

        results.put("A01:2021-Broken Access Control", SQL_INJECTION_PATTERN.matcher(payload).find());
        results.put("A03:2021-Injection", SQL_INJECTION_PATTERN.matcher(payload).find());
        results.put("A07:2021-Identification and Authentication Failures", containsSensitiveData(payload));

        return results.entrySet().stream()
                .filter(Map.Entry::getValue)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static boolean containsSensitiveData(String payload) {
        Pattern[] patterns = {
                Pattern.compile("\\b\\d{4}[- ]?\\d{4}[- ]?\\d{4}[- ]?\\d{4}\\b"),
                Pattern.compile("\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}\\b", Pattern.CASE_INSENSITIVE),
                Pattern.compile("\\b(secret|password|token|api_key|apikey)\\s*[:=]\\s*\\S+\\b", Pattern.CASE_INSENSITIVE)
        };

        for (Pattern pattern : patterns) {
            if (pattern.matcher(payload).find()) {
                return true;
            }
        }
        return false;
    }

    public static String sanitizeInput(String input) {
        if (input == null) {
            return null;
        }
        return Encode.forHtml(input);
    }

    public static boolean isSecureHeader(String headerName) {
        return SENSITIVE_HEADERS.stream().noneMatch(h -> h.equalsIgnoreCase(headerName));
    }

    public static List<String> getOwaspCategories(String version) {
        if ("2017".equals(version)) {
            return OWASP_2017_CATEGORIES;
        } else if ("2021".equals(version)) {
            return OWASP_2021_CATEGORIES;
        }
        throw new IllegalArgumentException("Versión OWASP no soportada: " + version);
    }
}

// === ARCHIVO: src/test/java/com/pragma/loansecurity/utils/JwtUtils.java ===
package com.pragma.loansecurity.utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class JwtUtils {

    private static String currentToken;
    private static final String AUTH_ENDPOINT = "/api/auth/login";

    public static String generateToken(String username, String password) {
        RequestSpecification request = SerenityRest.given()
                .contentType("application/json")
                .body("{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}");

        Response response = request.post(AUTH_ENDPOINT);

        if (response.getStatusCode() == 200) {
            currentToken = response.jsonPath().getString("token");
            return currentToken;
        }
        throw new RuntimeException("Failed to generate JWT token: " + response.getStatusCode());
    }

    public static String getCurrentToken() {
        return currentToken;
    }

    public static void setCurrentToken(String token) {
        currentToken = token;
    }

    public static void clearToken() {
        currentToken = null;
    }

    public static boolean validateToken(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        RequestSpecification request = SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json");

        Response response = request.get("/api/auth/validate");
        return response.getStatusCode() == 200;
    }

    public static String extractUsernameFromToken(String token) {
        return "user_placeholder";
    }

    public static boolean isTokenExpired(String token) {
        return false;
    }

    public static String refreshToken(String expiredToken) {
        RequestSpecification request = SerenityRest.given()
                .header("Authorization", "Bearer " + expiredToken)
                .contentType("application/json");

        Response response = request.post("/api/auth/refresh");

        if (response.getStatusCode() == 200) {
            String newToken = response.jsonPath().getString("token");
            currentToken = newToken;
            return newToken;
        }
        throw new RuntimeException("Failed to refresh JWT token");
    }

    public static RequestSpecification withAuthenticatedHeader(RequestSpecification request) {
        if (currentToken != null && !currentToken.isEmpty()) {
            return request.header("Authorization", "Bearer " + currentToken);
        }
        return request;
    }
}

// === ARCHIVO: src/test/resources/data/test_data.csv ===
username,password,role,expectedStatus,testScenario
admin,admin123,ADMIN,200,Login exitoso con credenciales válidas
user_test,test1234,USER,200,Login con usuario de prueba
invalid_user,wrongpass,UNKNOWN,401,Login con credenciales inválidas
,password123,UNKNOWN,400,Login sin username
user_empty,,UNKNOWN,400,Login sin password
, ,UNKNOWN,400,Login sin credenciales
sql_injection_user,' OR '1'='1,UNKNOWN,401,SQL Injection en username
sql_injection_pass,' OR '1'='1,UNKNOWN,401,SQL Injection en password
xss_payload,<script>alert(1)</script>,UNKNOWN,400,XSS en username
special_chars_user,user@domain#$,UNKNOWN,400,Caracteres especiales en password
admin_token_expired,expired_token_value,ADMIN,401,Token expirado
borrower_001,borrower123,borrower,200,Prestatario válido
fraud_engine_user,fraud123,FRAUD_ENGINE,200,Usuario motor antifraude
risk_bureau_user,risk123,RISK_BUREAU,200,Usuario buró de riesgos
core_bank_user,core123,CORE_BANK,200,Usuario core bancario
originator_user,originator123,ORIGINATOR,200,Originador de créditos

// === ARCHIVO: src/test/java/com/pragma/loansecurity/config/SecurityConfig.java ===
package com.pragma.loansecurity.config;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SecurityConfig {

    private EnvironmentVariables environmentVariables;
    private Map<String, String> protectedEndpoints;
    private Map<String, String[]> allowedRoles;

    public SecurityConfig(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
        this.protectedEndpoints = new HashMap<>();
        this.allowedRoles = new HashMap<>();
        initializeEndpoints();
    }

    private void initializeEndpoints() {
        protectedEndpoints.put("/api/loans/create", "POST");
        protectedEndpoints.put("/api/loans/update", "PUT");
        protectedEndpoints.put("/api/loans/delete", "DELETE");
        protectedEndpoints.put("/api/loans/all", "GET");
        protectedEndpoints.put("/api/auth/login", "POST");
        protectedEndpoints.put("/api/auth/validate", "GET");
        protectedEndpoints.put("/api/auth/refresh", "POST");
        protectedEndpoints.put("/api/fraud/check", "POST");
        protectedEndpoints.put("/api/risk/evaluate", "POST");
        protectedEndpoints.put("/api/core/sync", "POST");

        allowedRoles.put("ADMIN", new String[]{"/api/loans/*", "/api/auth/*", "/api/fraud/*", "/api/risk/*", "/api/core/*"});
        allowedRoles.put("ORIGINATOR", new String[]{"/api/loans/create", "/api/loans/all"});
        allowedRoles.put("BORROWER", new String[]{"/api/loans/all"});
        allowedRoles.put("FRAUD_ENGINE", new String[]{"/api/fraud/check"});
        allowedRoles.put("RISK_BUREAU", new String[]{"/api/risk/evaluate"});
        allowedRoles.put("CORE_BANK", new String[]{"/api/core/sync"});
    }

    public String getBaseUrl() {
        return EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("base.url", "http://localhost:8080");
    }

    public String getApiKey() {
        return EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("api.key", "test-api-key");
    }

    public boolean isEndpointProtected(String endpoint, String method) {
        return protectedEndpoints.containsKey(endpoint) &&
               protectedEndpoints.get(endpoint).equals(method);
    }

    public boolean hasRoleAccess(String role, String endpoint) {
        String[] endpoints = allowedRoles.get(role);
        if (endpoints == null) {
            return false;
        }
        for (String allowedEndpoint : endpoints) {
            if (endpoint.matches(allowedEndpoint.replace("*", ".*"))) {
                return true;
            }
        }
        return false;
    }

    public int getMaxLoginAttempts() {
        return Integer.parseInt(EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("security.max.login.attempts", "5"));
    }

    public int getTokenExpirationMinutes() {
        return Integer.parseInt(EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("security.token.expiration.minutes", "60"));
    }

    public boolean isSecurityScanningEnabled() {
        return Boolean.parseBoolean(EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("security.scanning.enabled", "true"));
    }

    public String[] getExcludedScanPaths() {
        String excluded = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("security.scan.excluded.paths", "/health,/metrics");
        return excluded.split(",");
    }

    public int getScanTimeoutSeconds() {
        return Integer.parseInt(EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("security.scan.timeout.seconds", "300"));
    }
}

// === ARCHIVO: src/test/java/com/pragma/loansecurity/interactions/Authenticate.java ===
package com.pragma.loansecurity.interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class Authenticate implements Interaction {

    private final String token;
    private final String authHeader;

    public Authenticate(String token) {
        this.token = token;
        this.authHeader = "Bearer " + token;
    }

    public static Authenticate withToken(String token) {
        return Tasks.instrumented(Authenticate.class, token);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        
        ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript("window.localStorage.setItem('authToken', arguments[0]);", token);
        
        ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript("window.sessionStorage.setItem('authToken', arguments[0]);", token);
    }
}

// === ARCHIVO: checklists/owasp_security_checklist.md ===
# Checklist de Seguridad OWASP 2017-2021

## A1: Inyección (Injection)
- [ ] Validar entrada de datos en todos los campos de formulario
- [ ] Utilizar consultas parametrizadas (PreparedStatement)
- [ ] Implementar validación en capa de aplicación y base de datos
- [ ] Escapar caracteres especiales en consultas SQL

## A2: Autenticación Rota (Broken Authentication)
- [ ] Implementar autenticación multifactor (MFA)
- [ ] No deploying credenciales predeterminadas
- [ ] Verificar fortaleza de contraseñas (mínimo 12 caracteres, mayúsculas, minúsculas, números, símbolos)
- [ ] Implementar bloqueo de cuenta tras intentos fallidos
- [ ] Gestionar sesiones de forma segura (timeouts, rotación de IDs)

## A3: Exposición de Datos Sensibles
- [ ] Cifrar datos en tránsito (TLS 1.2+)
- [ ] Cifrar datos en reposo con algoritmos fuertes
- [ ] No almacenar datos sensibles sin cifrado
- [ ] Implementar HTTP Strict Transport Security (HSTS)
- [ ] Configurar encabezados de seguridad apropiados

## A4: Configuración de Seguridad Incorrecta
- [ ] Revisar configuraciones de servidor y aplicación
- [ ] Deshabilitar funcionalidades innecesarias
- [ ] Mantener actualizado software y dependencias
- [ ] Configurar políticas de CORS apropiadas
- [ ] Eliminar información de depuración en producción

## A5: Control de Acceso Roto
- [ ] Implementar control de acceso por principio de menor privilegio
- [ ] Validar permisos en cada acceso a recurso
- [ ] Denegar por defecto todo acceso
- [ ] Registar eventos de acceso y fallos de seguridad
- [ ] Realizar revisiones de control de acceso periódicas

## A6: Seguridad de Configuración Incorrecta
- [ ] Verificar que las configuraciones de seguridad sean robustas
- [ ] Revisar permisos en archivos y directorios
- [ ] Implementar separacion de entornos (dev, staging, prod)
- [ ] Gestionar configuraciones sensibles de forma segura

## A7: Cross-Site Scripting (XSS)
- [ ] Escapar contenido no confiable en respuestas HTML
- [ ] Utilizar encabezados de Content-Type apropiados
- [ ] Implementar políticas de CSP (Content Security Policy)
- [ ] Validar y sanear entradas de usuario
- [ ] Utilizar frameworks con protección XSS integrada

## A8: Deserialización Insegura
- [ ] Validar tipos de objetos antes de deserializar
- [ ] No aceptar objetos serializados de fuentes no confiables
- [ ] Utilizar firmas digitales en objetos serializados
- [ ] Limitar puertos y protocolos de deserialización

## A9: Uso de Componentes con Vulnerabilidades Conocidas
- [ ] Mantener inventario de componentes utilizados
- [ ] Monitorear vulnerabilidades de componentes
- [ ] Actualizar componentes a versiones seguras
- [ ] Eliminar componentes no utilizados
- [ ] Obtener componentes de fuentes oficiales

## A10: Registro y Monitoreo Insuficientes
- [ ] Implementar logging de eventos de seguridad
- [ ] Configurar alertas para actividades sospechosas
- [ ] Establecer procedimientos de respuesta a incidentes
- [ ] No registrar datos sensibles (contraseñas, tokens)
- [ ] Revisar y analizar logs regularmente

## A11: Falsificación de Solicitudes del Lado del Servidor (SSRF)
- [ ] Validar y sanear URLs proporcionadas por usuario
- [ ] Implementar listas blancas de recursos permitidos
- [ ] Deshabilitar redirecciones HTTP posteriores
- [ ] Segmentar funcionalidad de acceso a recursos

## Criterios de Aceptación
- Todas las verificaciones críticas (A1-A5) deben estar marcadas
- Máximo 2 items pendientes en categorías de alto riesgo
- Plan de remediación documentado para items pendientes
- Evidencia de pruebas de penetración asociadas

## Referencias
- OWASP Top 10 2017
- OWASP Top 10 2021
- NIST SP 800-53
- ISO/IEC 27001

// === ARCHIVO: reports/security_report_sample.md ===
# Informe de Pruebas de Seguridad

## Información General del Escaneo

| Campo | Valor |
|-------|-------|
| **ID del Escaneo** | `scan_id_placeholder` |
| **Fecha de Ejecución** | `scan_date_placeholder` |
| **Target** | `target_url_placeholder` |
| **Herramienta** | OWASP ZAP |
| **Perfil de Escaneo** | Baseline / Full Scan |
| **Duración** | `duration_placeholder` |

---

## Resumen Ejecutivo

Breve descripción de los hallazgos de seguridad identificados durante el escaneo.
Incluya el número total de vulnerabilidades por severidad y el riesgo general para la aplicación.

### Distribución por Severidad

| Severidad | Cantidad | Descripción |
|-----------|----------|-------------|
| **Crítica** | X | Vulnerabilidades que requieren atención inmediata |
| **Alta** | X | Vulnerabilidades con impacto significativo |
| **Media** | X | Vulnerabilidades que deben abordarse |
| **Baja** | X | Hallazgos con bajo impacto |
| **Informativa** | X | Observaciones sin riesgo directo |

---

## Detalle de Vulnerabilidades

### 1. [Nombre de Vulnerabilidad]

| Atributo | Detalle |
|----------|---------|
| **Severidad** | Crítica / Alta / Media / Baja / Informativa |
| **CWE** | CWE-XXX |
| **WASC** | WASC-XX |
| **URL Afectada** | `url_affected` |
| **Parámetro** | `parameter_name` |
| **Evidencia** | ```request_response_placeholder``` |

**Descripción:**
Descripción técnica de la vulnerabilidad encontrada.

**Impacto:**
Impacto potencial de la vulnerabilidad en la seguridad de la aplicación.

**Remediación:**
Pasos recomendados para corregir la vulnerabilidad.

---

## Vulnerabilidades por Categoría OWASP

| Categoría OWASP | Cantidad | Vulnerabilidades |
|-----------------|----------|------------------|
| A1: Inyección | X | Listado |
| A2: Autenticación Rota | X | Listado |
| A3: Exposición de Datos | X | Listado |
| A4: Configuración Incorrecta | X | Listado |
| A5: Control de Acceso Roto | X | Listado |
| A6: Security Misconfiguration | X | Listado |
| A7: XSS | X | Listado |
| A8: Deserialización Insegura | X | Listado |
| A9: Componentes Vulnerables | X | Listado |
| A10: Logging Insuficiente | X | Listado |

---

## Recomendaciones

### Acciones Inmediatas (0-7 días)
- Remediar vulnerabilidades críticas identificadas
- Actualizar componentes con vulnerabilidades conocidas
- Revisar configuraciones de seguridad

### Acciones a Corto Plazo (7-30 días)
- Remediación de vulnerabilidades de alta severidad
- Implementación de encabezados de seguridad
- Mejora en el manejo de sesiones

### Acciones a Mediano Plazo (30-90 días)
- Automatización de pruebas de seguridad en CI/CD
- Capacitación en seguridad para desarrolladores
- Implementación de programa de bug bounty

---

## Anexos

### Evidencia de Escaneo
- Adjuntar reporte XML/JSON de OWASP ZAP
- Capturas de pantalla de vulnerabilidades críticas

### Herramientas Utilizadas
- OWASP ZAP versión X.X.X
- Navegador: Firefox/Chrome
- Extensiones: Passive Scanner, Active Scanner

### Glosario
| Término | Definición |
|---------|------------|
| CWE | Common Weakness Enumeration |
| WASC | Web Application Security Consortium |
| XSS | Cross-Site Scripting |
| CSRF | Cross-Site Request Forgery |

---

**Reporte generado automáticamente por el pipeline de pruebas de seguridad**
**Proyecto:** Loan Security System - Pruebas de Seguridad OWASP
```
