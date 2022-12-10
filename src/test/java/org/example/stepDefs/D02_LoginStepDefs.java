package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_loginPage;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class D02_LoginStepDefs {
    P02_loginPage login = new P02_loginPage();

    @Given("user go to login page")
    public void openLogin(){
        login.Loginpage().click();
    }
    @When("user login with valid Email and password")
    public void userLoginWithEmailAndPassword() {
        login.Email().sendKeys("noha75@gmail.com");
        login.Password().sendKeys("123456");}

    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.LoginButton().click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        SoftAssert soft = new SoftAssert();
        String actualUrl =driver.getCurrentUrl();
        soft.assertEquals(actualUrl,"https://demo.nopcommerce.com/");
        boolean statusbtn =login.MyaccountButton().isDisplayed();
        soft.assertTrue(statusbtn);
        soft.assertAll();}

    @When("user login with invalid Email and password")
    public void userLoginWithInvalidEmailAndPassword() {
        login.email().sendKeys("nohagmail.com");
        login.password().sendKeys("12347");}


    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        SoftAssert soft = new SoftAssert();

        String errorMsg = login.errorMsg().getText();
        soft.assertEquals(errorMsg,"Wrong email");

        String actualURL = driver.getCurrentUrl();
        soft.assertEquals(actualURL, "https://demo.nopcommerce.com/register?returnUrl=%2F");

        String actualColor = login.errorMsg().getCssValue("color");
        actualColor = Color.fromString(actualColor).asHex();
        soft.assertEquals(actualColor,"#e4434b");
    }


}
