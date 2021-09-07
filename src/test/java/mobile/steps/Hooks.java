package mobile.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import mobile.utils.DesiredCapabilitiesUtils;
import org.openqa.selenium.WebDriver;
import ui.utils.ConfigReader;

import java.net.MalformedURLException;

public class Hooks {
    public static AndroidDriver<AndroidElement> androidDriver;
    public static WebDriver webDriver;


    @Before
    public void openBrowser() throws MalformedURLException {
        switch (ConfigReader.getProperty("testing")) {
            case "browser":
                webDriver = DesiredCapabilitiesUtils.setupWebDriver();
                break;
            case "app":
                androidDriver = DesiredCapabilitiesUtils.setupAndroidDesiredCapabilities();
                break;
        }

    }


    @After
    public void tearDown() {
        switch (ConfigReader.getProperty("testing")) {
            case "browser":
                webDriver.quit();
                break;
            case "app":
                androidDriver.quit();
                break;
        }
    }


}
