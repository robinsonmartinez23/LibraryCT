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

        ArrayList<String> usernames = new ArrayList<>(Arrays.asList("librarian21@library","librarian53@library"));
    // Navigate to url
        driver.get("http://library2.cybertekschool.com/login.html");
        for (int i = 0; i < usernames.size(); i++) {
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LogoutFunctionality/"+usernames.get(i)+"/1_login_page.png");
    // Provide credentials
            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys(usernames.get(i));
            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LogoutFunctionality/"+usernames.get(i)+"/2_credentials.png");
    // Getting access to Main site
            driver.findElement(By.xpath("//button[@type=\"submit\"]")).submit();
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"tbl_books_processing\"]/div/span")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LogoutFunctionality/"+usernames.get(i)+"/3_accessGranted.png");
    // User profile dropdown button
            WebElement logOutDropBtn = driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]"));
            logOutDropBtn.click();
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LogoutFunctionality/"+usernames.get(i)+"/4_Librarian21_dropdown.png");
    // Log out button
            driver.findElement(By.cssSelector("a.dropdown-item")).click();
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LogoutFunctionality/"+usernames.get(i)+"/5_Librarian21_logout.png");
        }
    }
}
