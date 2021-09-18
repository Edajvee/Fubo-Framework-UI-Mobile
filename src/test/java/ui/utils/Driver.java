package ui.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver; // declare WebDriver object

    private Driver() {
    }

    public static WebDriver getDriver() { //before --> public static WebDriver getDriver(String browser) {
        String browser = System.getenv("BROWSER");
        if (browser == null) {

            switch (ConfigReader.getProperty("browser")) { // reads a key from configuration.properties // before --> switch(browser)
                case "firefox":
                    WebDriverManager.firefoxdriver().setup(); // this is BoniGarcia method
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup(); // this is BoniGarcia method
                    driver = new ChromeDriver(); // initialize WebDriver object
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
