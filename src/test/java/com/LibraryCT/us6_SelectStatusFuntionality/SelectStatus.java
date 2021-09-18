package com.LibraryCT.us6_SelectStatusFuntionality;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CustomMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class SelectStatus extends TestBase {

    @Test
    public void selectStatusAsLibrarian() throws Exception {
        /**
         * User Story 6
         * As a librarian, I want to select user groups.
         *
         * AC #1:
         * Given librarian is on the homePage
         * When librarian click Users module
         * And librarian click user group dropdown
         * Then verify librarian have 3 options
         */

        driver.get("http://library2.cybertekschool.com/login.html");

        ArrayList<String> usernames = new ArrayList<>(Arrays.asList("librarian21@library","librarian53@library"));

        for (int i = 0; i < usernames.size(); i++) {
            // Provide credentials
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/SelectStatusFunctionality/"+usernames.get(i).substring(0,11)+"/1_login_pagee_"+usernames.get(i)+".png");
            WebElement loginBox = driver.findElement(By.xpath("//*[@id='inputEmail']"));
            loginBox.sendKeys(usernames.get(i));
            WebElement passwordBox = driver.findElement(By.xpath("//*[@id='inputPassword']"));
            passwordBox.sendKeys("Sdet2022*");
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/SelectStatusFunctionality/"+usernames.get(i).substring(0,11)+"/2_credentialse_"+usernames.get(i)+".png");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            // Wait till element comes up and screen shoot Main page
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"#users\"]")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/SelectStatusFunctionality/"+usernames.get(i).substring(0,11)+"/3_Main_pagee_"+usernames.get(i)+".png");
            // Click on user module and go to User Management wait till User Group comes up
            driver.findElement(By.xpath("//a[@href=\"#users\"]")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"tbl_users_processing\"]/div/span")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/SelectStatusFunctionality/"+usernames.get(i).substring(0,11)+"/4_UserMng_pagee_"+usernames.get(i)+".png");
            // Click on Status and verify dropdown menu
            driver.findElement(By.xpath("//*[@id=\"user_status\"]")).click();
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/SelectStatusFunctionality/"+usernames.get(i).substring(0,11)+"/5_DropDowne_"+usernames.get(i)+".png");
            // Dropdown profile button xpath //*[@id="navbarDropdown"]
            driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
            // Log out button cssSelector a.dropdown-item
            driver.findElement(By.cssSelector("a.dropdown-item")).click();
        }
    }
}
