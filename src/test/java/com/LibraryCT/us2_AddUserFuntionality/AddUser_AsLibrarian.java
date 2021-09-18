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
    public void addUserFun() throws Exception {

        ArrayList<String> usernames = new ArrayList<>(Arrays.asList("librarian21@library", "librarian53@library"));
    // Navigate to url
        driver.navigate().to("http://library2.cybertekschool.com/login.html");
        for (int i = 0; i < usernames.size(); i++) {
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/" + usernames.get(i) + "/1_login_page.png");
    // Providing librarian credentials
            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys(usernames.get(i));
            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/" + usernames.get(i) + "/2_credentials.png");
    // Getting access to Main site
            driver.findElement(By.xpath("//button[@type=\"submit\"]")).submit();
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"tbl_books_processing\"]/div/span")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/"+usernames.get(i)+"/3_accessGranted.png");


            /**
             * Explicit wait, create wait object and create the most accurate Expected Condition
             *
             * Implicit Condition....It is not recommended
             * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
             */


    // Getting access to Users module
            driver.findElement(By.xpath("//a[@href=\"#users\"]")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"tbl_users_processing\"]/div")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/"+usernames.get(i)+"/4_userMng.png");
    // Add User button
            driver.findElement(By.xpath("//a[@href=\"tpl/add-user.html\"]")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"tbl_users_processing\"]/div")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/"+usernames.get(i)+"/5_UserForm.png");
    // Full name
            WebElement fullName = driver.findElement(By.xpath("//input[@name='full_name']"));
            fullName.sendKeys("Robinson Martinez");
    // password
            WebElement newPassword = driver.findElement(By.xpath("//input[@name='password']"));
            newPassword.sendKeys("12345678");
    //email
            WebElement newEmail = driver.findElement(By.xpath("//input[@name='email']"));
            newEmail.sendKeys("robinsonmartinez6"+i+"@cybertek.com");
    //address
            WebElement address = driver.findElement(By.xpath("//*[@id='address']"));
            address.sendKeys("Miami Beach, FL 33141");
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/"+usernames.get(i)+"/6_InfoFilled.png");
    // Save changes
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"ajax\"]/div/div/div")));
            CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/"+usernames.get(i)+"/7_UserAdded.png");
    // Dropdown profile button xpath //*[@id="navbarDropdown"]
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"toast-container\"]/div/div")));
            driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
    // Log out button cssSelector a.dropdown-item
            driver.findElement(By.cssSelector("a.dropdown-item")).click();

        }
    }
}
