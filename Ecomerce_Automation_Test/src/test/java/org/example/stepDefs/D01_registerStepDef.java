package org.example.stepDefs;

import org.example.pages.P01_register;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    // Create object from pom design pattern
    P01_register register = new P01_register();

    @Given("user go to register page")
    public void userGoToRegisterPage() {
        register.registerLink.click();
    }

    @When("user select gender type")
    public void userSelectGenderType() {                                   // select gender type : male
        register.maleOption.click();
    }

    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String firstName, String lastName) {
        register.firstName.sendKeys(firstName);
        register.lastName.sendKeys(lastName);
    }

    @And("user enter date of birth  Step")
    public void userEnterDateOfBirthStep() {
        Select select = new Select(register.birthDay);
        select.selectByIndex(10);

        select = new Select(register.birthMonth);
        select.selectByVisibleText("March");

        select = new Select(register.birthYear);
        select.selectByValue("1998");

    }

    @And("user enter email {string} field")
    public void userEnterEmailField(String email) {
        register.email.sendKeys(email);
        System.out.println(email);
    }

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String pass, String passConfirm) {
        register.password.sendKeys(pass);
        register.passwordConfirm.sendKeys(passConfirm);

    }

    @And("clicks on register button")
    public void clicksOnRegisterButton() {
        register.registerBtn.click();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {

        // assertion for verifying success message and it's color
        SoftAssert softAssert = new SoftAssert();

        //8.1 - verify Success message is displayed "Your registration completed"
        softAssert.assertTrue(register.successMsg.getText().contains("Your registration completed"));

        //8.2 - verify success message color is green  (#4cb17c) hex
        softAssert.assertEquals(register.successMsg.getCssValue("color"), "rgba(76, 177, 124, 1)");
        System.out.println(register.successMsg.getCssValue("color"));
        softAssert.assertAll();
    }
}
