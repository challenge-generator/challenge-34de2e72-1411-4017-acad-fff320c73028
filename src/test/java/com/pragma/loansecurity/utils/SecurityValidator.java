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