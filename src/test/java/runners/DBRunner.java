package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {
                "html:target/default-cucumber-reports3",
                "json:target/json-report/cucumber.json3",
                "junit:target/xml-report/cucumber.xml3",
                "rerun:target/failedRerun.txt3"
        },
        features = "./src/test/resources/features/db_features",
        glue = "database_stepdefinitions",
        tags = "@db_read",
        dryRun = false
)
//This class is only used for running database related tests
public class DBRunner {
}
