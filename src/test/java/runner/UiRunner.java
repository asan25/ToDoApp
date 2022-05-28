package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-reports",
                "json:target/cucumber.json"},
        features="src/test/resources/features",
        glue="stepDefinitions",
        tags="@US_2",
        dryRun = false,
        monochrome = true
)

public class UiRunner {

}
