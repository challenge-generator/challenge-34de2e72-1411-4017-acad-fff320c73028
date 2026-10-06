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