package com.LibraryCT.us3_AddBookFuncionality;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.CustomMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class AddBook_AsLibrarian {
    /**
     * As a librarian, I should be able to add a new user.
     * AC #1:
     * Given librarian is on the homePage
     * When librarian click Books module
     * And librarian click “+Add Book” button
     * When librarian enter BookName, ISBN, Year, Author, and Description
     * And librarian click save changes Then verify a new book is added
     */

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://library2.cybertekschool.com/login.html");

        ArrayList<String> usernames = new ArrayList<>(Arrays.asList("librarian21@library","librarian53@library"));

        for (int i = 0; i < usernames.size(); i++) {
    // Provide credentials
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddBookFunctionality/"+usernames.get(i).substring(0,11)+"/1_login_page.png");
            WebElement loginBox = driver.findElement(By.xpath("//*[@id='inputEmail']"));
            loginBox.sendKeys(usernames.get(i));
            WebElement passwordBox = driver.findElement(By.xpath("//*[@id='inputPassword']"));
            passwordBox.sendKeys("Sdet2022*");
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddBookFunctionality/"+usernames.get(i).substring(0,11)+"/2_credentials.png");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
    // Click on Books Module button xpath //span[@class='title' and text()='Books']
            Thread.sleep(4000);
            driver.findElement(By.xpath("//span[@class='title' and text()='Books']")).click();
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddBookFunctionality/"+usernames.get(i).substring(0,11)+"/3_BookMng.png");
    // Click on Add Book button xpath //div[1]/span/a
            driver.findElement(By.xpath("//div[1]/span/a")).click();
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddBookFunctionality/"+usernames.get(i).substring(0,11)+"/4_AddBookWin.png");
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
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddBookFunctionality/"+usernames.get(i).substring(0,11)+"/5_NewBookInfo.png");
    // Save changes button xpath //button[@class='btn btn-primary']
            driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
            Thread.sleep(2000);
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddBookFunctionality/"+usernames.get(i).substring(0,11)+"/6_NewBookAdded.png");
    // Drop down button xpath //*[@id="navbarDropdown"]
            driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
    // Log out button cssSelector a.dropdown-item
            driver.findElement(By.cssSelector("a.dropdown-item")).click();
        }
        driver.close();
    }
}
