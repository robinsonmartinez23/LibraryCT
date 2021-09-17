package com.LibraryCT.us2_AddUserFuntionality;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions; //Explicit wait
import org.openqa.selenium.support.ui.WebDriverWait; //Explicit wait
import utilities.CustomMethods;


public class AddUser_Librarian53 {
    public static void main(String[] args)throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("http://library2.cybertekschool.com/login.html");
        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/Librarian53_AddUser/1_login_page.png");

        /*
        Explicit wait, create wait object and create the most accurate Expected Condition
         */
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));

        // Implicit Condition....It is not recommended
        // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        WebElement loginId = driver.findElement(By.xpath("//input[@type='email']"));
        loginId.sendKeys("librarian53@library");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Sdet2022*");
        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/Librarian53_AddUser/2_Librarian53_credentials.png");

        driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"#users\"]")));
        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/Librarian53_AddUser/3_MainPage.png");
        driver.findElement(By.xpath("//a[@href=\"#users\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"tpl/add-user.html\"]")));
        driver.findElement(By.xpath("//a[@href=\"tpl/add-user.html\"]")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='full_name']")));
        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/Librarian53_AddUser/4_FillInfo.png");
        WebElement fullName = driver.findElement(By.xpath("//input[@name='full_name']"));
        fullName.sendKeys("Robinson Martinez");

        WebElement newPassword = driver.findElement(By.xpath("//input[@name='password']"));
        newPassword.sendKeys("12345678");

        WebElement newEmail = driver.findElement(By.xpath("//input[@name='email']"));
        newEmail.sendKeys("robinsonmartinez201@cybertek.com");

        WebElement address = driver.findElement(By.xpath("//*[@id='address']"));
        address.sendKeys("Miami Beach, FL 33141");


        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/Librarian53_AddUser/5_InfoFilled.png");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(2000);
        CustomMethods.takeSnapShot(driver, "C://Users/Robin.000/OneDrive/Fotos/Selenium ScrShot/LibraryCT/AddUserFunctionality/Librarian53_AddUser/6_UserAdded.png");

        driver.quit();


    }
}
