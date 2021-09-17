package com.LibraryCT.us7_FilterFuncionality;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CustomMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class DramaSelection {
    public static void main(String[] args) throws Exception {
        /**
         * As a user, I want to filter book categories.
         *
         * AC #2:
         * Given user is on the homePage
         * When user click Books module
         * And user click book category dropdown
         * Then verify user is able to select the “Drama” option
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://library2.cybertekschool.com/login.html");

        ArrayList<String> usernames = new ArrayList<>(Arrays.asList("librarian21@library", "librarian53@library", "student66@library","student67@library","student68@library"));

        for (int i = 0; i < usernames.size(); i++) {
    // Provide credentials
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/FilterFunctionality/DramaOption/" + usernames.get(i) + "/1_login_page.png");
            WebElement loginBox = driver.findElement(By.xpath("//*[@id='inputEmail']"));
            loginBox.sendKeys(usernames.get(i));
            WebElement passwordBox = driver.findElement(By.xpath("//*[@id='inputPassword']"));
            passwordBox.sendKeys("Sdet2022*");
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/FilterFunctionality/DramaOption/" + usernames.get(i) + "/2_credentials.png");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
    // Wait till element comes up and screen shoot Main page
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"tbl_books_processing\"]/div/span")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/FilterFunctionality/DramaOption/"+usernames.get(i)+"/3_Main_page.png");
    // Click books module
            WebElement booksModule = driver.findElement(By.xpath("//span[contains(text(),'Books')]"));
            booksModule.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"tbl_books_processing\"]/div/span")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/FilterFunctionality/DramaOption/"+usernames.get(i)+"/4_BookMng.png");
    // Click books category
            WebElement booksCategory = driver.findElement(By.xpath("//*[@id=\"book_categories\"]"));
            booksCategory.click();
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/FilterFunctionality/DramaOption/"+usernames.get(i)+"/5_Dropdown.png");
    // Select Drama category
            WebElement categories = driver.findElement(By.cssSelector("#book_categories"));
            Select drama = new Select(categories);
            drama.selectByValue("6");
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/FilterFunctionality/DramaOption/"+usernames.get(i)+"/6_DramaChoice.png");
    // Dropdown profile button xpath //*[@id="navbarDropdown"]
            driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
    // Log out button cssSelector a.dropdown-item
            driver.findElement(By.cssSelector("a.dropdown-item")).click();

        }
    driver.close();
    }
}