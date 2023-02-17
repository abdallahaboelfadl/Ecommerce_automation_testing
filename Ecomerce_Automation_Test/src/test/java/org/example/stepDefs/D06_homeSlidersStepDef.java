package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.example.stepDefs.Hooks;
import org.testng.Assert;

public class D06_homeSlidersStepDef {

    P03_homePage home=new P03_homePage();

    @When("user press on first home slider iphone")
    public void userPressOnFirstHomeSliderIphone() {

        home.homeSlider.click();
    }


    @Then("user navigate to iphone page")
    public void userNavigateToIphonePage() throws InterruptedException {
        Thread.sleep(500);
        String ACtUrlSlider= Hooks.driver.getCurrentUrl();
        String ExUrlSlider="https://demo.nopcommerce.com/nokia-lumia-1020";
        System.out.println(ACtUrlSlider );
        Assert.assertEquals(ACtUrlSlider,ExUrlSlider);

    }

    @When("user press on first home slider galaxy")
    public void userPressOnFirstHomeSliderGalaxy() {
home.homeSlider2.click();

    }

    @Then("user redirect to galaxy page")
    public void userRedirectToGalaxyPage() throws InterruptedException {
        Thread.sleep(500);
        String ActulUrl=Hooks.driver.getCurrentUrl();
        String ExUrl="https://demo.nopcommerce.com/galaxy-22";
        Assert.assertEquals(ActulUrl,ExUrl);

    }


}
