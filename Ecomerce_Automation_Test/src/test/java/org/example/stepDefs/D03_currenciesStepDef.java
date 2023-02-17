package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_currenciesStepDef {
    P03_homePage homePage=new P03_homePage();
    @When("user select currency type and select Euro")
    public void selectCurrencyType()
    {
        Select list=new Select(homePage.Currency);
        list.selectByVisibleText("Euro");

    }


    @Then("verify Euro Symbol \\(€) is shown on the four products displayed in Home page")
    public void verifyEuroSymbol€IsShownOnTheFourProductsDisplayedInHomePage() {
        //create for loop to loop priceList and save item in varable
        String ListOfPrice;
        for (int i=0; i<homePage.priceList.size(); i++)
        {
            if(i<=4) {ListOfPrice=homePage.priceList.get(i).getText();

            }else {break;}
            System.out.println(ListOfPrice); //exist 4 item
            // hard assertion to check if price contain euro sign
            Assert.assertTrue(ListOfPrice.contains("€"),"product contaim € ");

        }





    }


}
