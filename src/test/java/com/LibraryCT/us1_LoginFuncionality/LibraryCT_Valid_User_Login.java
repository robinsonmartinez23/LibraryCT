package com.LibraryCT.us1_LoginFuncionality;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LibraryCT_Valid_User_Login extends TestBase{
    @Test
    public void LogingFun() throws Exception {
        /**
         * User Story 1 As a user, I should be able to login to LibraryCT.
         *
         * AC #1:
         * Given librarian is on the loginPage
         * Then verify that the title is “Login - Library”
         * When librarian enters valid email address and password
         * And librarian click sign in button
         * Then verify that there are3 modelson the page
         *
         * AC#2:
         * Given student is on the loginPage
         * Then verify that the URL is “https://library2.cybertekschool.com/login.html”
         * When student enters valid email address and password
         * And student click sign in button
         * Then verify that there are 2 models on the page
         */

        ArrayList<String> usernames = new ArrayList<>(Arrays.asList("librarian21@library", "librarian53@library", "student66@library","student67@library","student68@library"));
        // Navigate to url
        driver.get("http://library2.cybertekschool.com/login.html");

        for (int i = 0; i < usernames.size(); i++) {
            // Providing correct credentials
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LoginFunctionality/"+usernames.get(i)+"/1_login_page_"+usernames.get(i)+".png");
            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys(usernames.get(i));
            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LoginFunctionality/"+usernames.get(i)+"/2_credentialse_"+usernames.get(i)+".png");
            // Getting access to Main site
            driver.findElement(By.xpath("//button[@type=\"submit\"]")).submit();
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"tbl_books_processing\"]/div/span")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LoginFunctionality/"+usernames.get(i)+"/3_accessGrantede_"+usernames.get(i)+".png");
            // Dropdown profile button xpath //*[@id="navbarDropdown"]
            driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
            // Log out button cssSelector a.dropdown-item
            driver.findElement(By.cssSelector("a.dropdown-item")).click();
        }
    }
}
