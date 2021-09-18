package ui.steps;
import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import ui.utils.CommonUtils;
import ui.utils.Driver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setup() {
        driver = Driver.getDriver();
    }
    @After
    public void tearDown(Scenario scenario) {
        CommonUtils.takeScreenshots(driver,scenario);
        driver.quit();
    }
}