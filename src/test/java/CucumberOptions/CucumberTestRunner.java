package CucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",
		glue= "stepDifinitions",
		monochrome= true,
		plugin= {"pretty", "html:target/report_html/cucumber-report-default","json:target/report_html/cucumber.json"},
		snippets = SnippetType.CAMELCASE,
		tags = {"@Customer_Dynamic"}
		)
public class CucumberTestRunner {

}
