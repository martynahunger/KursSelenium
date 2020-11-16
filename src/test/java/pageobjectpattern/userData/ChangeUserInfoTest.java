package pageobjectpattern.userData;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/Features/profile-data-change.feature",
        plugin = {"pretty","html:out"}
)
public class ChangeUserInfoTest {
}
