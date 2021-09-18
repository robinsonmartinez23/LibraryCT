package com.LibraryCT.us4_LogoutFuntionality;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CustomMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;


public class LogOut_AsLibrarian extends TestBase {

    @Test
    public void logOutFuntionality() throws Exception{
        /**
         * User Story 4
         * As a librarian, I want to log-out from the library homepage.
         * AC #1:
         * Given user is on the homePage
         * When user click username on the right top corner
         * And user click Log Out
         * Then verify user navigate back to login page.
         */

        ArrayList<String> usernames = new ArrayList<>(Arrays.asList("librarian21@library","librarian53@library"));
        // Navigate to url
        driver.get("http://library2.cybertekschool.com/login.html");
        for (int i = 0; i < usernames.size(); i++) {
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LogoutFunctionality/"+usernames.get(i)+"/1_login_pagee_"+usernames.get(i)+".png");
            // Provide credentials
            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys(usernames.get(i));
            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LogoutFunctionality/"+usernames.get(i)+"/2_credentialse_"+usernames.get(i)+".png");
            // Getting access to Main site
            driver.findElement(By.xpath("//button[@type=\"submit\"]")).submit();
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"tbl_books_processing\"]/div/span")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LogoutFunctionality/"+usernames.get(i)+"/3_accessGrantede_"+usernames.get(i)+".png");
            // User profile dropdown button
            WebElement logOutDropBtn = driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]"));
            logOutDropBtn.click();
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LogoutFunctionality/"+usernames.get(i)+"/4_Librarian21_dropdowne_"+usernames.get(i)+".png");
            // Log out button
            driver.findElement(By.cssSelector("a.dropdown-item")).click();
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LogoutFunctionality/"+usernames.get(i)+"/5_Librarian21_logoute_"+usernames.get(i)+".png");
        }
    }
}
