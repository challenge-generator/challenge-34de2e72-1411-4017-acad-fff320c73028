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