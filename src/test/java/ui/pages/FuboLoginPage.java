package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FuboLoginPage {

    public FuboLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//div[@class='css-z52n1a']/button/div")
    public WebElement signInButtonOnLoginPage;


}
