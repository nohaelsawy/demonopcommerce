package org.example.stepDefs;
import io.cucumber.java.en.*;

import static org.example.stepDefs.Hooks.driver;

import io.cucumber.java.en.Given;
import org.example.pages.P01_RegisterPage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
public class D01_Registration {
P01_RegisterPage register = new P01_RegisterPage();

    @Given("user go to register page")
    public void step1(){
        register.register().click();
       // driver.findElement(By.className("ico-register")).click();
       // WebElement reg = driver.findElement(By.className("ico-register"));
       // reg.click();
    }
    @When("user select gender type")
    public void userSelectGenderType() {
        register.gender().click();
    }

    @When("user enter First & last name")
    public void userEnterFirstLastName() {
    register.FirstName().sendKeys("noha");
    register.LastName().sendKeys("elsawy");
    }

    @And("user enter Date of birth")
    public void userEnterDateOfBirth() {
        Select day = new Select(register.Daylist());
        day.selectByValue("20");

        Select month = new Select(register.Monthlist());
        month.selectByValue("3");

        Select year = new Select(register.Yearlist());
        year.selectByValue("1999");
    }

    @And("user enter  valid email {string}")
    public void userEnterValidEmail(String email) {
        register.email().sendKeys(email);
    }

    @And("user enter Company name")
    public void userEnterCompanyName() {
        register.Companyname().sendKeys("factory");
    }

    @And("user enter Password & Confirm password")
    public void userEnterPasswordConfirmPassword() {
    register.password().sendKeys("123456");
    register.ConfirmPassword().sendKeys("123456");
    }

    @And("user click on register button")
    public void userClickOnRegisterButton() {
        register.registerbutton().click();
    }

    @Then("user created account successfully")
    public void userCreatedAccountSuccessfully() {
        SoftAssert soft = new SoftAssert();
      //  https://demo.nopcommerce.com/registerresult/1?returnUrl=/
        String actualURL = driver.getCurrentUrl();
        soft.assertEquals(actualURL, "https://demo.nopcommerce.com/registerresult/1?returnUrl=/");

        String actualMsg = register.successMsg().getText();
        soft.assertEquals(actualMsg,"Your registration completed");

        String actualColor = register.successMsg().getCssValue("color");
        actualColor = Color.fromString(actualColor).asHex();
        soft.assertEquals(actualColor,"#4cb17c");

         boolean continuebutton = register.continuebutton().isDisplayed();
         soft.assertTrue(continuebutton);
         soft.assertAll();
    }

    @Then("user could not create new account")
    public void userCouldNotCreateNewAccount() {
        SoftAssert soft = new SoftAssert();

        String errorMsg = register.errorMsg().getText();
        soft.assertEquals(errorMsg,"Wrong email");

        String actualURL = driver.getCurrentUrl();
        soft.assertEquals(actualURL, "https://demo.nopcommerce.com/register?returnUrl=%2F");

        String actualColor = register.errorMsg().getCssValue("color");
        actualColor = Color.fromString(actualColor).asHex();
        soft.assertEquals(actualColor,"#e4434b");
    }
}
