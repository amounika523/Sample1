package com.example.steps;

import io.cucumber.java.en.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CartSteps {
    private Map<String,Double> cart;

    @Given("the cart is empty")
        public void the_cart_is_empty(){
            cart=new HashMap<>();
        }
    @When("user add {string} with price {double}")
        public void user_add_items_to_the_cart_with_price(String item, Double price){
            cart.put(item,price);
    }
    @When("user remove {string} with price {double}")
        public void user_remove_items_to_the_cart_with_price(String item, Double price){
            cart.remove(item,price);
    }
    @Then("total price is {double}")
        public void total_price(Double expectedprice){
            double total=cart.values().stream().mapToDouble(Double::doubleValue).sum();
            assertEquals(expectedprice,total);
    }
    @Then("total price is {double} which should not match")
        public void total_price_which_should_not_match(Double expectedprice){
        double total=cart.values().stream().mapToDouble(Double::doubleValue).sum();
        assertNotEquals(expectedprice,total);
    }
}
