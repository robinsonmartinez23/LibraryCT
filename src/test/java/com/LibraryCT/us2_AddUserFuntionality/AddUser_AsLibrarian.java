package com.LibraryCT.us2_AddUserFuntionality;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CustomMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;

public class AddUser_AsLibrarian extends TestBase {
    @Test
    /**
     * User Story 2
     * As a librarian, I should be able to add a new user.
     *
     * AC #1:
     * Given librarian is on the homePage
     * When librarian click Users module
     * And librarian click “+Add User” button
     * When librarian enter full name, password, email and address
     * And librarian click save changes
     * Then verify a new user is created
     */

    public void addUserFun() throws Exception {

        ArrayList<String> usernames = new ArrayList<>(Arrays.asList("librarian21@library", "librarian53@library"));
        // Navigate to url
        driver.navigate().to("http://library2.cybertekschool.com/login.html");
        for (int i = 0; i < usernames.size(); i++) {
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/" + usernames.get(i) + "/1_login_pagee_"+usernames.get(i)+".png");
            // Providing librarian credentials
            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys(usernames.get(i));
            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/" + usernames.get(i) + "/2_credentialse_"+usernames.get(i)+".png");
            // Getting access to Main site
            driver.findElement(By.xpath("//button[@type=\"submit\"]")).submit();
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"tbl_books_processing\"]/div/span")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/"+usernames.get(i)+"/3_accessGrantede_"+usernames.get(i)+".png");

            /**
             * Explicit wait, create wait object and create the most accurate Expected Condition
             *
             * Implicit Condition....It is not recommended
             * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
             */

            // Getting access to Users module
            driver.findElement(By.xpath("//a[@href=\"#users\"]")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"tbl_users_processing\"]/div")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/"+usernames.get(i)+"/4_userMnge_"+usernames.get(i)+".png");
            // Add User button
            driver.findElement(By.xpath("//a[@href=\"tpl/add-user.html\"]")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"tbl_users_processing\"]/div")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/"+usernames.get(i)+"/5_UserForme_"+usernames.get(i)+".png");
            // Full name box
            WebElement fullName = driver.findElement(By.xpath("//input[@name='full_name']"));
            fullName.sendKeys("Robinson Martinez");
            // password box
            WebElement newPassword = driver.findElement(By.xpath("//input[@name='password']"));
            newPassword.sendKeys("12345678");
            //email box
            WebElement newEmail = driver.findElement(By.xpath("//input[@name='email']"));
            newEmail.sendKeys("robinsonmartinez8"+i+"@cybertek.com");
            //address box
            WebElement address = driver.findElement(By.xpath("//*[@id='address']"));
            address.sendKeys("Miami Beach, FL 33141");
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/"+usernames.get(i)+"/6_InfoFillede_"+usernames.get(i)+".png");
            // Save changes button
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"ajax\"]/div/div/div")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/"+usernames.get(i)+"/7_UserAddede_"+usernames.get(i)+".png");
            // Dropdown profile button xpath //*[@id="navbarDropdown"]
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"toast-container\"]/div/div")));
            driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
            // Log out button cssSelector a.dropdown-item
            driver.findElement(By.cssSelector("a.dropdown-item")).click();

        }
    }
}
