package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class ContextSetup {
	
	public WebDriver driver;
	public String landingPageproductName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;
    
	
	public ContextSetup() throws IOException {
		
		testBase=new TestBase();
		pageObjectManager=new PageObjectManager(testBase.webDriverManager());
		genericUtils=new GenericUtils(testBase.webDriverManager());
	}

}
