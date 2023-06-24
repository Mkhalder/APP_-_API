package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features/AppLogin.feature"},
        glue = {"StepDefinition/AppAutomation"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty",
                "html:build/reports/feature.html"
        })
@Test
public class AppRunner extends AbstractTestNGCucumberTests {
}
