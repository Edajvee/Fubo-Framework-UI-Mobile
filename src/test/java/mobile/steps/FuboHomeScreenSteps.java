package mobile.steps;

import cucumber.api.java.en.Given;

public class FuboHomeScreenSteps {

    @Given("^user opens app$")
    public void userOpensApp() throws InterruptedException {
        System.out.println("opens app");
        Thread.sleep(5000);
    }
}
