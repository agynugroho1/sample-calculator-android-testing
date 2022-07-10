package com.example.steps;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.example.app.Calculator;
import com.example.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MathsStepDefinitions extends BaseTest{

    int a = 0;
    int b = 0;
    int total = 0;

    Calculator calculator = new Calculator();

    @Given("a is {int}")
    public void givenAIs(int value) {
        a = value;
    }

    @Given("b is {int}")
    public void givenBIs(int value) {
        b = value;
    }

    @When("I add a and b")
    public void iAddAAndB() {
        total = calculator.add(a,b);
    }

    @Then("the total should be {int}")
    public void theTotalShouldBe(int expectedTotal) {
        int actualTotal = Integer.parseInt(calculatorPage.getResult().replaceAll("Hasil : ", ""));
        assertThat(expectedTotal).isEqualTo(actualTotal);
    }

    @When("user input number {string} is {int}")
    public void userInputNumberIs(String type, int numb) {
        if (type.equalsIgnoreCase("one")){
            calculatorPage.inputNumberOne(numb);
        } else {
            calculatorPage.inputNumbertwo(numb);
        }
    }

    @And("user click equals button")
    public void userClickEqualsButton() {
        calculatorPage.clickEqualsButton();
    }

    @And("user choose operator {string}")
    public void userChooseOperator(String operator) {
        calculatorPage.clickChooseOperator();
        calculatorPage.clickOperator(operator);
    }

    @When("user input number {string} is {string}")
    public void userInputNumberIs(String arg0, String arg1) {
        if(arg0.equalsIgnoreCase("one")){
            calculatorPage.inputNegativeNumberOne(arg1);
        } else{
            calculatorPage.inputNegativeNumberTwo(arg1);
        }
    }

    @Then("field {string} can't be input with alphabet")
    public void fieldCantBeInputWithAlphabet(String arg0) {
        String actual;
        if(arg0.equalsIgnoreCase("one")){
            actual = calculatorPage.getValueFieldNumberOne();
        } else{
            actual = calculatorPage.getValueFieldNumberTwo();
        }
        assertFalse(actual.matches("^[a-zA-Z]*$"));
    }

    @When("user not filling all fields")
    public void userNotFillingAllFields() {
    }

    @Then("Button equals not active")
    public void buttonEqualsNotActive() {
        assertFalse(calculatorPage.checkEqualsButton());
    }
}
