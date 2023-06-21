package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.ContextSetup;

public class Hooks {
	ContextSetup contextSetup;
	WebDriver driver;
	public Hooks(ContextSetup contextSetup) {
		this.contextSetup=contextSetup;
	}
	
	@After
	public void tearDown() throws IOException {
		driver=contextSetup.testBase.webDriverManager();
		driver.quit();
	}
	@AfterStep
	public void addScreenShot(Scenario scenario) throws IOException {
		WebDriver driver=contextSetup.testBase.webDriverManager();
		if(scenario.isFailed()) {
			//we have tell our driver to caste the screenshot mode
			File sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//we have send our file has bytes format
			//to convert fileformat to bytes format there is one dependency apache commons.io
			byte[] file= FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(file, "image/png", "image");
		}
	}

}
