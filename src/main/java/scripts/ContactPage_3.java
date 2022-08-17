package scripts;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import config.ConfigFileReader;
import config.StartBrowser;
import objectRepository.contactPage3;

public class ContactPage_3 extends StartBrowser {
	static Logger log = Logger.getLogger(ContactPage_3.class);
	ConfigFileReader configFileReader;
	
	@Test
	public void Contact_Page() throws Exception
	{
		configFileReader = new ConfigFileReader();
		
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		
		driver.get(configFileReader.getApplicationUrl());
		log.info("Opening URL");
		
		
		WebElement eleHover = driver.findElement(contactPage3.EleHover);
		Actions actions = new Actions(driver);
		actions.moveToElement(eleHover).perform();
		log.info("\nHovering on 'Support'");
		
		driver.findElement(contactPage3.clickContact).click();

		log.info("Clicking on 'Contact Us' button");
		
		JavascriptExecutor j = (JavascriptExecutor) driver;
	    j.executeScript("window.scrollBy(0,2500)");
	    log.info("Scrolling down");
		
	    driver.findElement(contactPage3.clickContactUS).click();
	    
	    driver.findElement(By.id("cs_fullName")).sendKeys("Ranganatha M");
	    
	    driver.findElement(By.id("cs_email")).sendKeys("ranganatham7026@gmail.com");
	    
	    driver.findElement(By.id("cs_phone")).sendKeys("8884933835");
	    
//	    Select select = new Select(driver.findElement(By.className("ddlabel")));
//	    select.selectByVisibleText("International Flights");
//	    
//	    
//	    select = new Select(driver.findElement(By.id("cs_qCat_title")));
//	    select.selectByVisibleText("Booking Query");
	    
//	    WebElement chooseFile = driver.findElement(By.id("BrowserHidden_2"));
	    WebElement chooseFile = driver.findElement(contactPage3.browseFile);
	    chooseFile.sendKeys("D:\\Dummy File\\Dummy.png");
	    log.info("Browsing the file");
	    
//	    driver.findElement(By.id("submitData")).click();
	    
	    
	    this.takeSnapShot(driver, "./Screenshot/Contact.png");
	    log.info("Taking Snapshot of Contact Page\n");
	    System.out.println("Taking Snapshot of Contact Page\n");
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
