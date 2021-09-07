package ui.utils;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class CommonUtils {

    public static void takeScreenshots(WebDriver driver, Scenario scenario) {
        if (!scenario.getStatus().toString().equals("PASSED")) {
            try {
                // Take a screenshot...
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                // embed it in the report.
                scenario.embed(screenshot, "image/png");
            } catch (Exception e) {
                System.out.println("Failed to take screenshots");
            }
        } else {
            System.out.println("Scenario is passed!");
        }
    }



}
