package com.LibraryCT.us4_LogoutFuntionality;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CustomMethods;

public class Librarian53_lobOut {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://library2.cybertekschool.com/login.html");

        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LogoutFunctionality/Librarian53_LogOut/1_login_page.png");
        WebElement email = driver.findElement(By.id("inputEmail"));
        email.sendKeys("librarian53@library");
        WebElement password = driver.findElement(By.id("inputPassword"));
        password.sendKeys("Sdet2022*");
        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LogoutFunctionality/Librarian53_LogOut/2_Librarian53_credentials.png");
        WebElement loginButton= driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.submit();

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarDropdown\"]")));

        WebElement logOutDropBtn = driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]"));
        logOutDropBtn.click();

        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LogoutFunctionality/Librarian53_LogOut/3_Librarian53_dropdown.png");


        driver.findElement(By.cssSelector("a.dropdown-item")).click();
        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/LogoutFunctionality/Librarian53_LogOut/4_Librarian53_logout.png");
        driver.close();
    }
}
