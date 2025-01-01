package base;

import config.ConfigManager;
import config.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

    public static WebDriver driver; // Changed to static

    private final String baseUrl = ConfigManager.getProperty("baseUrl");

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.initializeWebDriver();
        driver.get(baseUrl);
        System.out.println("Navigating to Url: " + baseUrl);
        System.out.println("Driver initialized in Base class: " + driver);
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.quitDriver();
        System.out.println("Browser Closed");
    }
}
