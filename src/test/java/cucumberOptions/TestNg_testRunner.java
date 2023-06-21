package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@runwith used in junit
@CucumberOptions(features="src/test/java/features",glue="steps",monochrome=true,
           tags="@placeOrder or @offerPage",
           plugin = {"html:target/cucumber.html","json:target/cucumber.json",
        		   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestNg_testRunner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
