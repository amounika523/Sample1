package com.example.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class APISteps {

    private String endpoint;
    private Response response;
    private Map<String, Object> requestBody = new HashMap<>();

    @Given("the API endpoint is {string}")
    public void set_api_endpoint(String url) {
        this.endpoint = url;
    }

    @When("I send a POST request with:")
    public void send_post_request_with(io.cucumber.datatable.DataTable dataTable) {
        requestBody.clear();
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        data.forEach((key, value) -> {
            if (key.equals("userId")) {
                requestBody.put(key, Integer.parseInt(value));
            } else {
                requestBody.put(key, value);
            }
        });

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    @Then("the response status code should be {int}")
    public void validate_status_code(int expectedCode) {
        assertEquals(expectedCode, response.getStatusCode());
    }

    @Then("the response should contain:")
    public void validate_response_fields(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> expected = dataTable.asMap(String.class, String.class);
        expected.forEach((key, value) -> {
            if (key.equals("userId")) {
                assertEquals(Integer.parseInt(value), response.jsonPath().getInt(key));
            } else {
                assertEquals(value, response.jsonPath().getString(key));
            }
        });
    }
}
