package mobile.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/mobile"//points to feature files so we need to update the path
        ,glue={"mobile/steps"}//points to mobile.steps so we need to update package name
        ,tags={"@openApp"}
        ,plugin = {"pretty","html:target/cucumber-reports/mobile"}//This is html report created by  Cucumber
)
public class TestRunner {
    /**
     * Cucumber will use Junit to run the tests in our framework.
     * As Cucumber uses Junit we need to have a Test Runner class, this class will use the Junit annotation @RunWith(), which tells JUnit what is the test ui.runner class.
     * It more like a starting point for Junit to start executing your tests. In the src folder create a class called TestRunner.
     */
}
