package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FuboHomePage {

    public FuboHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInputField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInputField;

    @FindBy(xpath = "//div[@class='btn signin']")
    public WebElement signInButtonOnHomePage;


}
