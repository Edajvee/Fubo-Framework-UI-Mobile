package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FuboManageProfilePage {

    String url = "https://www.fubo.tv/profiles";

    public FuboManageProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='see-less-often']/span")
    public WebElement seeLessOftenButton;

    @FindBy(xpath = "//span[@class='profile']")
    public WebElement dajvesProfile;

}

