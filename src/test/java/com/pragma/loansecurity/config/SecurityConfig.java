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