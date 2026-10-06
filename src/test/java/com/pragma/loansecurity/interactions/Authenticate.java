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