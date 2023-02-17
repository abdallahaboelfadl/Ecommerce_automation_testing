package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {

    P02_login login = new P02_login();


    @Given("user go to login page")
    public void userGoToLoginPage() {
        login.loginLink.click();
    }

    @When("user login with valid data {string} and {string}")
    public void userLoginWithAnd(String email, String password) {
        login.email.sendKeys(email);                     // send email
        login.password.sendKeys(password);                   // send password
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.loginBtn.click();                            //click on login button
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {

        SoftAssert softAssert = new SoftAssert();
        String actualLoginUrl = Hooks.driver.getCurrentUrl();
        String expectedLoginUrl = "https://demo.nopcommerce.com/";
        softAssert.assertEquals(actualLoginUrl, expectedLoginUrl);
        System.out.println(actualLoginUrl);


        softAssert.assertTrue(login.myAccIcon.isDisplayed());
        System.out.println(login.myAccIcon.getText());

        softAssert.assertAll();
    }


    @When("user login with invalid data {string} and {string}")
    public void userLoginWithInvalidDataAnd(String email, String pass) {
        login.email.sendKeys(email);
        login.password.sendKeys(pass);
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {

        SoftAssert softAssert = new SoftAssert();



        String actualMsgTxt = login.errorMsg.getText();
        String expectedMsgTxt = "Login was unsuccessful.";
        softAssert.assertTrue(actualMsgTxt.contains(expectedMsgTxt),"first assertion is failed");
        System.out.println(actualMsgTxt);



        String actualMassageColor = Color.fromString(login.errorMsg.getCssValue("color")).asHex();
        String expectedMsgColor = "#e4434b";
        softAssert.assertEquals(expectedMsgColor, expectedMsgColor,"second assertion is failed");
        System.out.println(actualMassageColor);
        softAssert.assertAll();
    }
}
