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