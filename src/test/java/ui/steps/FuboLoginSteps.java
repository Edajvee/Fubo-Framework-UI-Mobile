package ui.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.FuboHomePage;
import ui.pages.FuboLoginPage;
import ui.pages.FuboManageProfilePage;
import ui.pages.FuboPickYourFavoriteTeamsPage;
import ui.utils.WaitUtils;

public class FuboLoginSteps {

    WebDriver driver = Hooks.driver;
    FuboHomePage fuboHomePage = new FuboHomePage(driver);
    FuboLoginPage fuboLoginPage = new FuboLoginPage(driver);
    FuboManageProfilePage fuboManageProfilePage = new FuboManageProfilePage(driver);
    FuboPickYourFavoriteTeamsPage fuboPickYourFavoriteTeamsPage = new FuboPickYourFavoriteTeamsPage(driver);


    @Given("^user is on \"([^\"]*)\"$")
    public void user_is_on(String fuboHomePage) throws Exception {
        driver.get(fuboHomePage);
    }

    @Given("^user clicks \"([^\"]*)\" button$")
    public void user_clicks_button(String signInButton) throws Exception {
        WaitUtils.waitForPageTitle(driver, driver.getTitle());
        fuboHomePage.signInButtonOnHomePage.click();
    }

    @When("^user enters correct credentials$")
    public void user_enters_correct_credentials() throws Exception {
        fuboHomePage.emailInputField.sendKeys("dechols@fubo.tv");
        fuboHomePage.passwordInputField.sendKeys("34Dwanna1!");
        fuboLoginPage.signInButtonOnLoginPage.click();
    }

    @When("^if needed user chooses a profile under \"([^\"]*)\"$")
    public void if_needed_user_chooses_a_profile_under(String manageProfileUrl) throws InterruptedException {
        WaitUtils.waitForElementClickable(driver, fuboManageProfilePage.dajvesProfile);
        fuboManageProfilePage.dajvesProfile.click();

        WaitUtils.waitForElementClickable(driver, fuboPickYourFavoriteTeamsPage.continueButton);
        fuboPickYourFavoriteTeamsPage.continueButton.click();

        WaitUtils.waitForElementClickable(driver, fuboPickYourFavoriteTeamsPage.doneButton);
        fuboPickYourFavoriteTeamsPage.doneButton.click();
    }

    @Then("^user should be logged into their account under \"([^\"]*)\"$")
    public void user_should_be_logged_into_their_account_under(String loggedInHomePage) throws InterruptedException {
        String url = driver.getCurrentUrl();
        Thread.sleep(3000);
        Assert.assertTrue(loggedInHomePage.equals(url));
    }
}
