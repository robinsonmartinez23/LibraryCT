package com.LibraryCT.us1_LoginFuncionality;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.*;

public class LibraryCT_Invalid_User_Login extends TestBase{
    @Test
    public void loginFun() throws Exception {
        /**
         * User Story 1
         * As a user, I should be able to login to LibraryCT.
         *
         * AC #3 [negative]:
         * Given user is on the loginPage
         * When user enters invalid email address or password
         * And student click sign in button
         * Then verify the error message “Sorry, Wrong Email or Password”
         */

    // Navigate to url
        driver.get("http://library2.cybertekschool.com/login.html");
    // Providing incorrect credential
        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LoginFunctionality/InvalidCredentials/1_login_page.png");
        WebElement email = driver.findElement(By.id("inputEmail"));
        email.sendKeys("invalid@library");
        WebElement password = driver.findElement(By.id("inputPassword"));
        password.sendKeys("invalid");
        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LoginFunctionality/InvalidCredentials/2_invalidCredentials.png");
    // Checking denied access to Main site
        WebElement loginButton= driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.submit();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-form\"]/div[2]/div")));
        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LoginFunctionality/InvalidCredentials/3_accessDenied.png");
    }
}
