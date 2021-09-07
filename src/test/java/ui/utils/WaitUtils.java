package ui.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    /**
     * We store our common methods under ui.utils package.
     * This package contains the Wait ui.utils
     */

    static int timeoutForExplicitWait = Integer.parseInt(ConfigReader.getProperty("timeoutForExplicitWait"));
    /**
     * Waits for the page to have a given title
     *
     * This method is an attempt to address a problem where Chrome/IE drivers
     * are trying to check the page title on page load before the title has
     * changed to that of the new page.
     *
     * @param driver WebDriver instance
     * @param title title the page should have
     */
    public static void waitForPageTitle(WebDriver driver, String title){
        //wait = new WebDriverWait(driver, timeoutForExplicitWait);
        wait(driver).until(ExpectedConditions.titleContains(title));
    }

    /**
     * Waits for the element until it's visible
     * @param driver WebDriver instance
     * @param element WebElement object
     */
    public static void waitForElementVisible(WebDriver driver, WebElement element){
        //wait = new WebDriverWait(driver, timeoutForExplicitWait);
        wait(driver).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementClickable(WebDriver driver, WebElement element){
        //wait = new WebDriverWait(driver, timeoutForExplicitWait);
        wait(driver).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForUrlVisible(WebDriver driver, String currentUrl){
        wait(driver).until(ExpectedConditions.urlToBe(currentUrl));
    }
    public static  WebDriverWait wait(WebDriver driver){
        return new WebDriverWait(driver,timeoutForExplicitWait);
    }
}
