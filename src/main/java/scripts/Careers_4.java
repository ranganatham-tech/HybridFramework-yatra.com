package scripts;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import config.ConfigFileReader;
import config.StartBrowser;

public class Careers_4 extends StartBrowser {
	static Logger log = Logger.getLogger(Careers_4.class);
	ConfigFileReader configFileReader;
	
	@Test
	public void Careers() throws Exception
	{
		configFileReader = new ConfigFileReader();
		
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		
		driver.get(configFileReader.getApplicationUrl());
		log.info("Opening URL");
		
		
		JavascriptExecutor j = (JavascriptExecutor) driver;
	    j.executeScript("window.scrollBy(0,2500)");
	    log.info("Scrolling down");
	    
	    driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	    log.info("Implicitly Waiting");
	    
		driver.findElement(By.xpath("//a[@href='https://www.yatra.com/career/home']")).click();
		
		j.executeScript("window.scrollBy(0,2500)");
	    log.info("Scrolling down");
	    
		driver.findElement(By.xpath("//a[@href='https://www.yatra.com/career/job-portal']")).click();
		
		j.executeScript("window.scrollBy(0,500)");
	    log.info("Scrolling down");
	    
	    driver.findElement(By.xpath("//a[@data-toggle='Technology-Bangalore']")).click();
	    
	    driver.findElement(By.xpath("//*[@id=\"Technology-Bangalore\"]/div[1]/span/a")).click();
	    
	    
	    
		
	}
	
	public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		}
}
