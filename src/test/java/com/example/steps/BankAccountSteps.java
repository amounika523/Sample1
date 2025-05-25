package com.example.steps;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountSteps {
    private double balance;
    private boolean withdraw;
    @Given("my current account balance is {double}")
    public void my_current_account_balance(double amount){
            balance=amount;
    }
    @When ("I deposit amount {double} into my account")
    public void I_deposit_amount_into_my_account(double amount){
            balance=balance+amount;
    }
    @When ("I withdraw amount {double} from my account")
    public void I_withdraw_amount_from_my_account(double amount){
            if(balance>=amount){
                balance=balance-amount;
                withdraw=true;
            }else{
                withdraw=false;
        }
    }
    @Then ("my account balance should be {double}")
    public void my_account_balance_should(double amountexpected){
        assertEquals(amountexpected,balance);
    }
    @Then ("the withdraw should declined")
    public void the_withdraw_should_declined(){
        assertFalse(withdraw);
    }
}