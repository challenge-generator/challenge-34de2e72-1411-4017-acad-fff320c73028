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