package mobile.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.remote.DesiredCapabilities;
import ui.utils.ConfigReader;

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
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("androidDeviceName", ConfigReader.getProperty("deviceName"));
        desiredCapabilities.setCapability("androidPlatformName", ConfigReader.getProperty("platformName"));
        desiredCapabilities.setCapability("appPackage", ConfigReader.getProperty("appPackage"));
        desiredCapabilities.setCapability("appActivity", ConfigReader.getProperty("appActivity"));

        URL appiumServerUrl = new URL("http://localhost:4723/wd/hub");
        AndroidDriver<AndroidElement> driver = new AndroidDriver(appiumServerUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(ConfigReader.getProperty("timeoutForImplicitWait")), TimeUnit.SECONDS);
        return driver;
    }

    public static IOSDriver<IOSElement> setupIOSDesiredCapabilities() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", ConfigReader.getProperty("iosDeviceName"));
        desiredCapabilities.setCapability("platformName", ConfigReader.getProperty("iosPlatformName"));
        desiredCapabilities.setCapability("platformVersion", ConfigReader.getProperty("iosPlatformVersion"));
        desiredCapabilities.setCapability("udid", ConfigReader.getProperty("udid"));
        desiredCapabilities.setCapability("app", ConfigReader.getProperty("iosAppPath"));

        URL appiumServerUrl = new URL("http://localhost:4723/wd/hub");
        IOSDriver<IOSElement> driver = new IOSDriver(appiumServerUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(ConfigReader.getProperty("timeoutForImplicitWait")), TimeUnit.SECONDS);
        return driver;
    }
}
