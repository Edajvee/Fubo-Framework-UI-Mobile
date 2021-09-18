package mobile.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import mobile.utils.CommonUtils;

public class MobileCommonSteps {

    @Given("^user \"([^\"]*)\" to share location$")
    public void userToShareLocation(String allowAllTheTimeButton) {
        CommonUtils.tapByElement(Hooks.androidDriver, allowAllTheTimeButton);
    }

}
