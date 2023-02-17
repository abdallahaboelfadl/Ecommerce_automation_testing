package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

public class D07_followUsStepDef {
    P03_homePage homePage= new P03_homePage();
    //create array list to save tabs
    ArrayList<String> Tabs;



    @When("user click on facebook")
    public void userClickOnFacebookIcon() {
        homePage.FbIcon.click();


        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //to set tab fb on array list
        Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        //Tabs contain 2 element fb,nopcommmerce

    }


    @Then("user navigate to facebook page")
    public void userNavigateToFacebookPage() throws InterruptedException {
        Thread.sleep(500);
        //drive can navigate between tabs
        //switch drive to tab fb indexof = 1
        Hooks.driver.switchTo().window(Tabs.get(1));
        String actUrlFb=Hooks.driver.getCurrentUrl();
        String exUrl="https://www.facebook.com/nopCommerce";
        System.out.println(actUrlFb);

        Assert.assertEquals(exUrl,actUrlFb);



    }

    @When("user click on twitter icon")
    public void userClickOnTwitterIcon() throws InterruptedException {
    Thread.sleep(1000);
        homePage.twitterIcon.click();//to go to twitter
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
    }

    @Then("user navigate to twitter page")
    public void userNavigateToTwitterPage() throws InterruptedException {
        Thread.sleep(500);
        //drive can navigate between tabs
        //switch drive to tab fb indexof = 1
        Hooks.driver.switchTo().window(Tabs.get(1));
        String actUrlFb=Hooks.driver.getCurrentUrl();
        String exUrl="https://twitter.com/nopCommerce";
        System.out.println(actUrlFb);

        Assert.assertEquals(exUrl,actUrlFb);
    }

    @When("user click on rss icon")
    public void userClickOnRssIcon() {

        homePage.rssIcon.click();
//        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//        Tabs=new ArrayList<>(Hooks.driver.getWindowHandles());

    }

    @Then("user navigate to rss")
    public void userNavigateToRss() throws InterruptedException {
        SoftAssert soft =new SoftAssert();
        Thread.sleep(200);

      //  Hooks.driver.switchTo().window(Tabs.get(2));

        String ACtUrlRss=Hooks.driver.getCurrentUrl();
        String ExUrlRss=" https://demo.nopcommerce.com/new-online-store-is-open";
        soft.assertEquals(ACtUrlRss,ExUrlRss);
        soft.assertAll();



    }

    @When("user click on youtube icon")
    public void userClickOnYoutubeIcon() throws InterruptedException {
        Thread.sleep(1000);
        homePage.youtubeIcon.click();//to go to twitter
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
    }

    @Then("user navigate to youtube page")
    public void userNavigateToYoutubePage() throws InterruptedException {


        SoftAssert soft =new SoftAssert();
        Thread.sleep(200);
//to make drive switch to tab1
         Hooks.driver.switchTo().window(Tabs.get(1));

        String ACtUrlRss=Hooks.driver.getCurrentUrl();
        String ExUrlRss="https://www.youtube.com/user/nopCommerce";
        soft.assertEquals(ACtUrlRss,ExUrlRss);
        soft.assertAll();

    }

}
