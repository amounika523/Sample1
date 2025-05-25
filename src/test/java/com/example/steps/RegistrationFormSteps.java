package com.example.steps;

import io.cucumber.java.en.*;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationFormSteps {
    private String name;
    private String email;
    private boolean loggedIn;

    private String password;

    @Given("User is on the registration page")
    public void User_is_on_the_registration_page() {
        // Reset state for each scenario
        loggedIn = false;
    }

    @When("user register with name {string}, email {string}, and password {string}")
    public void the_user_register_in_with_details(String name, String mail, String pass) {
        this.name = name;
        this.password = pass;
        this.email = mail;
        //String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!name.isEmpty() && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$") && password.length()>8) {
            loggedIn = true;
        }else {
                loggedIn = false;
        }
    }

    @Then("validation is success")
    public void the_validation_is_success() {
        assertTrue(loggedIn, () ->
                String.format("Expected login to succeed for '%s' / '%s'", name, password, email));
    }

    @Then("validation is fail")
    public void the_validation_is_failed() {
        assertFalse(loggedIn, () ->
                String.format("Expected login to fail for '%s' / '%s'", name, password, email));
    }
}