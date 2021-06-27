package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {
                "html:target/default-cucumber-reports1",
                "json:target/json-report/cucumber1.json",
                "junit:target/xml-report/cucumber1.xml",
                "rerun:target/failedRerun.txt"
        },
        features = "./src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@smoke",
        dryRun = false
)

public class SmokeTestRunner {
}
