package mobile.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
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
    /**
     * This method sets up Desired Capabilities for Android Device
     *
     * @return
     * @throws MalformedURLException
     */
    public static AndroidDriver<AndroidElement> setupAndroidDesiredCapabilities() throws MalformedURLException {
        // as a file object
        // we need desiredCapabilities class to set up the device details and the application it is tested
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); // it is an object of desired capabilities class
        desiredCapabilities.setCapability("androidDeviceName", ConfigReader.getProperty("deviceName")); // this sets
        // deviceName as desiredCapabilities and reads deviceName from configuration.properties
        desiredCapabilities.setCapability("androidPlatformName", ConfigReader.getProperty("platformName")); // this sets
        // platformName as desiredCapabilities and reads platformName from configuration.properties
        //desiredCapabilities.setCapability("app", appFile.getAbsolutePath()); // this sets app Absolute
        // Path as desiredCapabilities
        desiredCapabilities.setCapability("appPackage", ConfigReader.getProperty("appPackage"));
        desiredCapabilities.setCapability("appActivity", ConfigReader.getProperty("appActivity"));
        URL appiumServerUrl = new URL("http://localhost:4723/wd/hub"); // this is url of appium server
        AndroidDriver<AndroidElement> driver = new AndroidDriver(appiumServerUrl, desiredCapabilities); // this initializes
        // android driver with integrating appium server url with desiredCapabilities of the device and application
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(ConfigReader.getProperty("timeoutForImplicitWait")), TimeUnit.SECONDS);
        return driver;
    }

    public static IOSDriver<IOSElement> setupIOSDesiredCapabilities() throws MalformedURLException {
        // as a file object
        // we need desiredCapabilities class to set up the device details and the application it is tested
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); // it is an object of desired capabilities class
        desiredCapabilities.setCapability("deviceName", ConfigReader.getProperty("iosDeviceName")); // this sets
        // deviceName as desiredCapabilities and reads deviceName from configuration.properties
        desiredCapabilities.setCapability("platformName", ConfigReader.getProperty("iosPlatformName")); // this sets
        desiredCapabilities.setCapability("platformVersion", ConfigReader.getProperty("iosPlatformVersion")); // this sets
        desiredCapabilities.setCapability("udid", ConfigReader.getProperty("udid")); // this sets
        // platformName as desiredCapabilities and reads platformName from configuration.properties
        //desiredCapabilities.setCapability("app", appFile.getAbsolutePath()); // this sets app Absolute
        // Path as desiredCapabilities
        desiredCapabilities.setCapability("app", ConfigReader.getProperty("iosAppPath"));
        URL appiumServerUrl = new URL("http://localhost:4723/wd/hub"); // this is url of appium server
        IOSDriver<IOSElement> driver = new IOSDriver(appiumServerUrl, desiredCapabilities); // this initializes
        // android driver with integrating appium server url with desiredCapabilities of the device and application
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(ConfigReader.getProperty("timeoutForImplicitWait")), TimeUnit.SECONDS);
        return driver;
    }


}
