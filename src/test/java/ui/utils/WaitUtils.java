package ui.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    static int timeoutForExplicitWait = Integer.parseInt(ConfigReader.getProperty("timeoutForExplicitWait"));

    public static void waitForPageTitle(WebDriver driver, String title) {
        wait(driver).until(ExpectedConditions.titleContains(title));
    }

    public static void waitForElementVisible(WebDriver driver, WebElement element) {
        //wait = new WebDriverWait(driver, timeoutForExplicitWait);
        wait(driver).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementClickable(WebDriver driver, WebElement element) {
        //wait = new WebDriverWait(driver, timeoutForExplicitWait);
        wait(driver).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForUrlVisible(WebDriver driver, String currentUrl) {
        wait(driver).until(ExpectedConditions.urlToBe(currentUrl));
    }

    public static WebDriverWait wait(WebDriver driver) {
        return new WebDriverWait(driver, timeoutForExplicitWait);
    }
}
