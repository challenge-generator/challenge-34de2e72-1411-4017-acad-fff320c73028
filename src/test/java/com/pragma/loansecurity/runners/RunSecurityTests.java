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