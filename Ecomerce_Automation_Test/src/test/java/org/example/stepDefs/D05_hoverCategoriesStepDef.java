package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class D05_hoverCategoriesStepDef {
    P03_homePage homePage=new P03_homePage();
    String subCat1;

    @When("user hover random category")
    public void userHoverRandomCategory() throws InterruptedException {
        // Create object from Actions class
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(homePage.category).perform();
        Thread.sleep(3000);


    }

    @And("user select sub category")
    public void userSelectSubCategory() {
        subCat1 = homePage.subCat.getText();
        System.out.println(subCat1);

        homePage.subCat.click();

    }

    @Then("subCategory page appears")
    public void subcategoryPageAppears() {

        String actualSubCatTitle = homePage.subCatTitle.getText().toLowerCase().trim();
        Assert.assertTrue(subCat1.toLowerCase().contains(actualSubCatTitle));

    }


}
