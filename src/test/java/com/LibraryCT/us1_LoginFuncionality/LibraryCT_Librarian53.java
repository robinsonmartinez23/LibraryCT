package com.LibraryCT.us1_LoginFuncionality;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.*;

public class LibraryCT_Librarian53 {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://library2.cybertekschool.com/login.html");
        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LoginFunctionality/Librarian53/1_login_page.png");
        WebElement email = driver.findElement(By.id("inputEmail"));
        email.sendKeys("librarian53@library");
        WebElement password = driver.findElement(By.id("inputPassword"));
        password.sendKeys("Sdet2022*");
        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LoginFunctionality/Librarian53/2_Librarian53_credentials.png");
        WebElement loginButton= driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.submit();

        Thread.sleep(2000);
        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LoginFunctionality/Librarian53/3_MainPage.png");
        driver.quit();

    }

}
