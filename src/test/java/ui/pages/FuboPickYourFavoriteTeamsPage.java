package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FuboPickYourFavoriteTeamsPage {


    public FuboPickYourFavoriteTeamsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@class='next-step-button css-1c82dzq-BaseButton']")
    public WebElement continueButton;

    @FindBy(xpath = "//button[@class='next-step-button css-1c82dzq-BaseButton']")
    public WebElement doneButton;
}
