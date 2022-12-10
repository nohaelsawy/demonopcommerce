package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepDefs.Hooks.driver;

public class P01_RegisterPage {

    public WebElement register(){

        return driver.findElement(By.className("ico-register"));
    }
   public WebElement gender(){
        return driver.findElement(By.id("gender-female"));

   }
   public WebElement FirstName(){
        return driver.findElement(By.id("FirstName"));
   }
   public WebElement LastName(){
        return driver.findElement(By.id("LastName"));
   }
   public WebElement Daylist(){
        return  driver.findElement(By.name("DateOfBirthDay"));
   }
   public WebElement Monthlist(){
        return driver.findElement(By.name("DateOfBirthMonth"));
   }
   public WebElement Yearlist(){
        return driver.findElement(By.name("DateOfBirthYear"));
   }

   public WebElement email(){
        return driver.findElement(By.id("Email"));
   }
   public WebElement Companyname(){
        return driver.findElement(By.id("Company"));
   }
   public WebElement password(){
        return driver.findElement(By.id("Password"));
   }
   public WebElement ConfirmPassword(){
        return driver.findElement(By.id("ConfirmPassword"));

   }
   public WebElement registerbutton(){
        return driver.findElement(By.id("register-button"));
   }

   public WebElement successMsg(){
        return driver.findElement(By.className("result"));
   }
   public WebElement continuebutton(){
        return driver.findElement(By.className("register-continue-button"));
   }

   public WebElement errorMsg(){
        return driver.findElement(By.id("Email-error"));
   }
}
