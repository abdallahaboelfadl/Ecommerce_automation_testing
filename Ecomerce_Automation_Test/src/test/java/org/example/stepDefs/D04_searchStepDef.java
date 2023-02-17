package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {

    //object homepage
    P03_homePage homePage=new P03_homePage();

    @When("user click on search field")
    public void userClickOnSearchField() {
        homePage.SearchInput.click();
    }

    @And("user enter product name {string}")
    public void userEnterProductName(String productname) throws InterruptedException {
        homePage.SearchInput.sendKeys(productname);
        homePage.SeachButton.click();
        Thread.sleep(1000);

    }

    @Then("user find all related products {string}")
    public void userFindAllRelatedProducts(String searchWord) {
        //Assert Url="https://demo.nopcommerce.com/search?q="
        SoftAssert soft=new SoftAssert();
        String ActUrl=Hooks.driver.getCurrentUrl();
        String ExUrl="https://demo.nopcommerce.com/search?q=";
        soft.assertTrue(ActUrl.contains(ExUrl),"true");
        System.out.println(ActUrl);

        //search shows relevant results

        for (int i=0; i<homePage.details.size();i++){

         String detailsList= String.valueOf(homePage.details.get(i).getText().toLowerCase().contains(searchWord));
         if(detailsList.equals("true"))
         {
              detailsList = homePage.details.get(i).getText().toLowerCase();
            soft.assertTrue(detailsList.contains(searchWord));
         }else {break;}



            System.out.println(detailsList+"\t"+i);
        }


        soft.assertAll();


    }

    @And("user enter product sku{string} and click on search button")
    public void userEnterProductSkuAndClickOnSearchButton(String ksu) {
            homePage.SearchInput.sendKeys(ksu);
            homePage.SeachButton.click();
            homePage.picture.click();
    }

    @Then("user will find all related products by {string}")
    public void userWillFindAllRelatedProductsBy(String expectSku) {
        SoftAssert softAssert=new SoftAssert();
        String actSku=homePage.ksuList.getText();
        System.out.println( actSku);
        softAssert.assertEquals(expectSku,actSku,"sku is exsist");


        softAssert.assertAll();


    }


}
