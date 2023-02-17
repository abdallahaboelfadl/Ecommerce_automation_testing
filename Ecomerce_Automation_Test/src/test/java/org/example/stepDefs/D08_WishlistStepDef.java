package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishlistStepDef {

    P03_homePage homePage=new P03_homePage();

    @When("user clicks on AddToCard button on this product")
    public void userClicksOnAddToCardButtonOnThisProduct() {

        homePage.htcBtn.click();
    }

    @Then("this product is added successfully")
    public void thisProductIsAddedSuccessfully() {
        SoftAssert softAssert = new SoftAssert();

        //assertion check if success message is displayed
        softAssert.assertTrue(homePage.sucMsg.isDisplayed());
        //to get color message use getcssvalue
        String successMsgColor = Color.fromString(homePage.sucMsg.getCssValue("background-color")).asHex();

        //assertion check if success message background color is green or not
        softAssert.assertEquals(successMsgColor, "#4bb07a", "color assertion is failed");
        softAssert.assertAll();




    }


    @When("user clicks on wishlist button on this product")
    public void userClicksOnWishlistButtonOnThisProduct() {

        homePage.htcBtn.click();
        
    }

    @And("clicks on wishlist link")
    public void clicksOnWishlistLink() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(homePage.sucMsg));
        homePage.wishlistLink.click();
    }

    @Then("verify the product is added successfully and product quantity is more than zero")
    public void verifyTheProductIsAddedSuccessfullyAndProductQuantityIsMoreThanZero() {

        int productQuantity = Integer.parseInt(homePage.productQaulity.getAttribute("value"));

        //assertion check if product quantity more than 0
        Assert.assertTrue(productQuantity > 0, "quantity assertion is more than zero");

    }
}
