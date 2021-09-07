package mobile.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.utils.ConfigReader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DesiredCapabilitiesUtils {
    public static AndroidDriver<AndroidElement> setupAndroidDesiredCapabilities() throws MalformedURLException {
        File appFile = new File(ConfigReader.getProperty("apkAppPath")); // stores the path of android application
        // as a file object
        // we need desiredCapabilities class to set up the device details and the application it is tested
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); // it is an object of desired capabilities class
        desiredCapabilities.setCapability("deviceName", ConfigReader.getProperty("deviceName")); // this sets
        // deviceName as desiredCapabilities and reads deviceName from configuration.properties
        desiredCapabilities.setCapability("platformName", ConfigReader.getProperty("platformName")); // this sets
        // platformName as desiredCapabilities and reads platformName from configuration.properties
        desiredCapabilities.setCapability("app", appFile.getAbsolutePath()); // this sets app Absolute
        // Path as desiredCapabilities
        URL appiumServerUrl = new URL("http://localhost:4723/wd/hub"); // this is url of appium server
        AndroidDriver<AndroidElement> driver = new AndroidDriver(appiumServerUrl, desiredCapabilities); // this initializes
        // android driver with integrating appium server url with desiredCapabilities of the device and application
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(ConfigReader.getProperty("timeoutForImplicitWait")), TimeUnit.SECONDS);
        return driver;
    }
    public static WebDriver setupWebDriver() throws MalformedURLException {
        File appFile = new File(ConfigReader.getProperty("chromePath"));
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", ConfigReader.getProperty("deviceName"));
        cap.setCapability("platformName", ConfigReader.getProperty("platformName"));
        cap.setCapability(CapabilityType.BROWSER_NAME, ConfigReader.getProperty("browser"));
        cap.setCapability("chromedriverExecutable", appFile.getAbsolutePath());
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), cap);
        return driver;
    }


}
