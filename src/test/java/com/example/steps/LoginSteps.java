package com.example.steps;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {

    private String username;
    private String password;
    private boolean loggedIn;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Reset state for each scenario
        loggedIn = false;
    }

    @When("the user logs in with username {string} and password {string}")
    public void the_user_logs_in_with_credentials(String user, String pass) {
        this.username  = user;
        this.password  = pass;

        // Very simple “authentication” logic for demo purposes
        loggedIn = "admin".equals(username) && "password123".equals(password);
    }

    @Then("the login should succeed")
    public void the_login_should_succeed() {
        assertTrue(loggedIn, () ->
                String.format("Expected login to succeed for '%s' / '%s'", username, password));
    }

    @Then("the login should fail")
    public void the_login_should_fail() {
        assertFalse(loggedIn, () ->
                String.format("Expected login to fail for '%s' / '%s'", username, password));
    }
}
