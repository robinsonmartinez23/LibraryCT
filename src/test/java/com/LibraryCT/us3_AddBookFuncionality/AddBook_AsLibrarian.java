package com.LibraryCT.us3_AddBookFuncionality;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CustomMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;

public class AddBook_AsLibrarian extends TestBase {
    /**
     * User Story 3
     * As a librarian, I should be able to add a new user.
     *
     * AC #1:
     * Given librarian is on the homePage
     * When librarian click Books module
     * And librarian click “+Add Book” button
     * When librarian enter BookName, ISBN, Year, Author, and Description
     * And librarian click save changes Then verify a new book is added
     */

    @Test
    public void addBookFun() throws Exception {

        ArrayList<String> usernames = new ArrayList<>(Arrays.asList("librarian21@library","librarian53@library"));
        // Navigate to url
        driver.get("http://library2.cybertekschool.com/login.html");

        for (int i = 0; i < usernames.size(); i++) {
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddBookFunctionality/"+usernames.get(i)+"/1_login_pagee_"+usernames.get(i)+".png");
            // Provide credentials
            WebElement loginBox = driver.findElement(By.xpath("//*[@id='inputEmail']"));
            loginBox.sendKeys(usernames.get(i));
            WebElement passwordBox = driver.findElement(By.xpath("//*[@id='inputPassword']"));
            passwordBox.sendKeys("Sdet2022*");
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddBookFunctionality/"+usernames.get(i)+"/2_credentialse_"+usernames.get(i)+".png");
            // Getting access to Main site
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"tbl_books_processing\"]/div/span")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddBookFunctionality/"+usernames.get(i)+"/3_accessGrantede_"+usernames.get(i)+".png");
            // Getting access to Books module xpath //span[@class='title' and text()='Books']
            driver.findElement(By.xpath("//span[@class='title' and text()='Books']")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"tbl_books_processing\"]/div/span")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddBookFunctionality/"+usernames.get(i)+"/4_BookMnge_"+usernames.get(i)+".png");
            // Click on Add Book button xpath //div[1]/span/a
            driver.findElement(By.xpath("//div[1]/span/a")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ajax\"]/div/div/div")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddBookFunctionality/"+usernames.get(i)+"/5_AddBookWine_"+usernames.get(i)+".png");
            // Book Name info xpath //*[@id="add_book_form"]/div[1]/div/div[1]/div[1]/div/input
            WebElement nameBox = driver.findElement(By.xpath("//*[@id=\"add_book_form\"]/div[1]/div/div[1]/div[1]/div/input"));
            nameBox.sendKeys("El chavo");
            // Book Year info xpath //input[@name='year']
            WebElement year= driver.findElement(By.xpath("//input[@name='year']"));
            year.sendKeys("2019");
            // ISBN Book number info xpath //input[@name='isbn']
            WebElement isbnBox = driver.findElement(By.xpath("//input[@name='isbn']"));
            isbnBox.sendKeys("12345");
            // Author info xpath //input[@type='text' and @name= 'author' ]
            WebElement authorBox = driver.findElement(By.xpath("//input[@type='text' and @name='author']"));
            authorBox.sendKeys("Roberto Gomez Bolaños");
            // Description area xpath  //textarea[@class='form-control']
            WebElement descriptionBox = driver.findElement(By.xpath("//textarea[@class='form-control']"));
            descriptionBox.sendKeys("A little homeless boy represented by " +
                                    "Roberto Gomez Bolaños and whom is adopted by members" +
                                    " of an small condominium facing very fun situation every" +
                                    " single day");
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddBookFunctionality/"+usernames.get(i)+"/6_NewBookInfoe_"+usernames.get(i)+".png");
            // Save changes button xpath //button[@class='btn btn-primary']
            driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"ajax\"]/div/div/div")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddBookFunctionality/"+usernames.get(i)+"/7_NewBookAddede_"+usernames.get(i)+".png");
            // Drop down button xpath //*[@id="navbarDropdown"]
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"toast-container\"]/div/div")));
            driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
            // Log out button cssSelector a.dropdown-item
            driver.findElement(By.cssSelector("a.dropdown-item")).click();
        }
    }
}
