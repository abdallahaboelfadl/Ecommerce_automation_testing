package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Hooks {

    public static WebDriver driver;

    @Before
    public static void openBrowser() {

        // 1 - Bridge or Web Driver Manager
        WebDriverManager.chromedriver().setup();

        // 2 - Create object from Chrome Browser
        driver = new ChromeDriver();

        //3 - Configuration
        //3.1 - maximize browser
        driver.manage().window().maximize();

        //3.2 - Set implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //4 - Navigate to website url
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();                    // quit driver after waiting 3 sec
    }
}
