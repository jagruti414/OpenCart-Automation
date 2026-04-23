package com.amazon.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();

        // Page load timeout
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // Element find karne ka wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Browser opened successfully");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully");
        }
    }

    public void openURL(String url) {
        driver.get(url);
        System.out.println("Opened URL: " + url);
    }
}