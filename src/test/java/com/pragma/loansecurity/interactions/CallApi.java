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