package utilities;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver;
    @BeforeEach
    public void setupWebDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
    }
    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }
}
