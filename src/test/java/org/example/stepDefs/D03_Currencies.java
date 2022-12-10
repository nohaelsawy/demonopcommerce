package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_Homepage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class D03_Currencies {
    P03_Homepage home = new P03_Homepage();

    @Then("first option is dollar")
    public void step1(){
        Select currencyselect = new Select(home.currencylist());
        String firstOption = currencyselect.getFirstSelectedOption().getText();
        Assert.assertEquals(firstOption,"US Dollar");
    }

    @When("user select Euro option")
    public void userSelectEuroOption() {
        Select currencyselect = new Select(home.currencylist());
        currencyselect.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
    }

    @Then("prices changed successfully")
    public void pricesChangedSuccessfully() {
   // home.prices().get(0).getText();
   // home.prices().get(1).getText();

        int size = home.prices().size();

        for (int x = 0; x < size; x++){
            String price = home.prices().get(x).getText();
            System.out.println(x);
            System.out.println(price);
            Assert.assertTrue(price.contains("€"));
        }
    }
}
