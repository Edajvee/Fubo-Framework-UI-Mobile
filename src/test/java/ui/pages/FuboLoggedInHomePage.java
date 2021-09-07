package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FuboLoggedInHomePage {

    public FuboLoggedInHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


}
