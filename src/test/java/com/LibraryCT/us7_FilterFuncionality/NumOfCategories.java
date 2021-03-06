package com.LibraryCT.us7_FilterFuncionality;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CustomMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NumOfCategories extends TestBase {

    @Test
    public void filterFuntionality() throws Exception {
        /**
         * User Story 7
         * As a user, I want to filter book categories.
         *
         * AC #1:
         * Given user is on the homePage
         * When user click Books module
         * And user click book category dropdown
         * Then verify there are 21 options
         */

        // Navigate to url
        driver.get("http://library2.cybertekschool.com/login.html");
        ArrayList<String> usernames = new ArrayList<>(Arrays.asList("librarian21@library", "librarian53@library", "student66@library", "student67@library", "student68@library"));

        for (int i = 0; i < usernames.size(); i++) {
            // Provide credentials
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/FilterFunctionality/CheckNumOfCategories/" + usernames.get(i) + "/1_login_pagee_"+usernames.get(i)+".png");
            WebElement loginBox = driver.findElement(By.xpath("//*[@id='inputEmail']"));
            loginBox.sendKeys(usernames.get(i));
            WebElement passwordBox = driver.findElement(By.xpath("//*[@id='inputPassword']"));
            passwordBox.sendKeys("Sdet2022*");
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/FilterFunctionality/CheckNumOfCategories/" + usernames.get(i) + "/2_credentialse_"+usernames.get(i)+".png");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            // Wait till element comes up and screen shoot Main page
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"tbl_books_processing\"]/div/span")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/FilterFunctionality/CheckNumOfCategories/"+usernames.get(i)+"/3_Main_pagee_"+usernames.get(i)+".png");
            // Click books module
            WebElement booksModule = driver.findElement(By.xpath("//span[contains(text(),'Books')]"));
            booksModule.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"tbl_books_processing\"]/div/span")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/FilterFunctionality/CheckNumOfCategories/"+usernames.get(i)+"/4_BookMnge_"+usernames.get(i)+".png");
            // Click books category
            WebElement booksCategory = driver.findElement(By.xpath("//*[@id=\"book_categories\"]"));
            booksCategory.click();
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/FilterFunctionality/CheckNumOfCategories/"+usernames.get(i)+"/5_Dropdowne_"+usernames.get(i)+".png");

            // Check number of categories
            List<WebElement> list= driver.findElements(By.xpath("//select[@id='book_categories']/option"));
            System.out.println("list.size() = " + list.size());

            if (list.size()==21){
                System.out.println("Expected result=21; Actual Result = 21");
            }else {
                System.out.println("test failed");
            }

            // Dropdown profile button xpath //*[@id="navbarDropdown"]
            driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
            // Log out button cssSelector a.dropdown-item
            driver.findElement(By.cssSelector("a.dropdown-item")).click();

        }
    }
}