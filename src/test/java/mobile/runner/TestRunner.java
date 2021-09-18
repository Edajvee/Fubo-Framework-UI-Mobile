package mobile.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/mobile"
        ,glue={"mobile/steps"}
        ,tags={"@openApp"}
        ,plugin = {"pretty","html:target/cucumber-reports/mobile"}
)
public class TestRunner {
    /**
     * Cucumber will use Junit to run the tests in our framework.
     * As Cucumber uses Junit we need to have a Test Runner class, this class will use the Junit annotation @RunWith(), which tells JUnit what is the test ui.runner class.
     * It more like a starting point for Junit to start executing your tests. In the src folder create a class called TestRunner.
     */
}
