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