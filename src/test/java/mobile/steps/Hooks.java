package mobile.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import mobile.utils.DesiredCapabilitiesUtils;

import ui.utils.ConfigReader;



public class Hooks {
    public static AndroidDriver<AndroidElement> androidDriver;
    public static IOSDriver<IOSElement> iosDriver;

    @Before
    public void setup() throws Exception {
        switch (ConfigReader.getProperty("device")) {
            case "ios":
                iosDriver = DesiredCapabilitiesUtils.setupIOSDesiredCapabilities();
            case "android":
                androidDriver = DesiredCapabilitiesUtils.setupAndroidDesiredCapabilities();
            default:
                throw new Exception("No setup found for device!");
        }
    }

    @After
    public void tearDown() {
        switch (ConfigReader.getProperty("device")) {
            case "ios":
                iosDriver.quit();
            case "android":
                androidDriver.quit();
        }
    }
}
