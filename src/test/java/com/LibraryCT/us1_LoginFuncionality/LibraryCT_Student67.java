package com.LibraryCT.us1_LoginFuncionality;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.*;

public class LibraryCT_Student67 {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://library2.cybertekschool.com/login.html");
        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LoginFunctionality/Student67/1_login_page.png");
        WebElement email = driver.findElement(By.id("inputEmail"));
        email.sendKeys("student67@library");
        WebElement password = driver.findElement(By.id("inputPassword"));
        password.sendKeys("Sdet2022*");
        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LoginFunctionality/Student67/2_Student67_credentials.png");
        WebElement loginButton= driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.submit();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LoginFunctionality/Student67/3_MainPage.png");
        driver.quit();
    }
}
