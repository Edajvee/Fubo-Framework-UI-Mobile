package mobile.utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import ui.utils.ConfigReader;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class CommonUtils {
    static int waitDuration = Integer.parseInt(ConfigReader.getProperty("waitDuration"));

    /**
     * This methods taps on element
     *
     * @param driver
     * @param androidElement
     */
    public static void tapByElement(AndroidDriver<AndroidElement> driver, AndroidElement androidElement) {
        touchAction(driver).tap(TapOptions.tapOptions().withElement(element(androidElement))).perform();
    }

    public static void tapByElement(IOSDriver<IOSElement> driver, IOSElement IOSElement) {
        touchAction(driver).tap(TapOptions.tapOptions().withElement(element(IOSElement))).perform();
    }

    public static void tapByElement(AndroidDriver<AndroidElement> driver, String visibleText) {
        touchAction(driver).tap(TapOptions.tapOptions().withElement(element(driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + visibleText + "\")")))).perform();
    }


    /**
     * This class initializes the object of TouchAction class
     *
     * @param driver -> This is Android driver
     * @returns to object of TouchAction class
     */
    public static TouchAction touchAction(AndroidDriver<AndroidElement> driver) {
        return new TouchAction(driver);
    }

    public static TouchAction touchAction(IOSDriver<IOSElement> driver) {
        return new TouchAction(driver);
    }

    public static AndroidElement elementByText(AndroidDriver<AndroidElement> driver, String visibleText) {
        return driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + visibleText + "\")");
    }

    public static void tapByCoordinates(AndroidDriver<AndroidElement> driver, int x, int y) {
        touchAction(driver)
                .tap(point(x, y))
                .waitAction(waitOptions(ofSeconds(waitDuration))).perform();
    }

    public static void scrollToElement(AndroidDriver<AndroidElement> driver, String visibleText) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())" + ".scrollIntoView(text(\"" + visibleText + "\"))");
    }

    public static void pressByElement(AndroidDriver<AndroidElement> driver, AndroidElement element, long seconds) {
        touchAction(driver)
                .press(element(element))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }

    public static void pressByCoordinates(AndroidDriver<AndroidElement> driver, int x, int y, long seconds) {
        new TouchAction(driver)
                .press(point(x, y))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }


}