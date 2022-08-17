package wdcmds;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.MediaEntityBuilder;

import config.StartBrowser;

public class ActionDriver {
	
	public WebDriver driver;
	public ActionDriver()
	{
		driver = StartBrowser.driver;
	}
	
	public void launchApplication(String url)
	{
		try {
			driver.get(url);
			StartBrowser.childTest.pass("Successfully Launched : "+url);
		}catch(Exception e) {
			StartBrowser.childTest.fail("Unable to Launch : "+url);
		}
		
	}
	
	public void navigateToApplication(String url)
	{
			driver.get(url);
			
	}
	
	
	public void click(By locator) throws Exception 
	{
		try {
			driver.findElement(locator).click();
			StartBrowser.childTest.pass("Performed click action on : ");
		} catch(Exception e) {
			StartBrowser.childTest.fail("Unable to perform click action on : ",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	
	public void mouseHover(By locator) throws Exception
	{
		try {
			WebElement we = driver.findElement(locator);
			Actions a = new Actions(driver);
			a.moveToElement(we);
			a.click().build().perform();
			StartBrowser.childTest.pass("Successfully performed mousehover action on : ");
		} catch(Exception e) {
			StartBrowser.childTest.fail("Unable to perform mousehover action on : ",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	
	public void selectByVisibleText(By locator, String visibleText, String eleName) throws Exception
	{
		try {
			WebElement we = driver.findElement(locator);
			Select s = new Select(we);
			s.selectByVisibleText(visibleText);
			StartBrowser.childTest.pass("Successfully Selected value : " + visibleText + " From Dropdown " + eleName);
		} catch(Exception e) {
			StartBrowser.childTest.fail("Unable to Select value : " + visibleText + " From Dropdown " + eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	
	
	public void type(By locator, String testData) throws Exception
	{
		try {
			driver.findElement(locator).sendKeys(testData);
			StartBrowser.childTest.pass("Successfullt performed type action on : with test data : " + testData);
		} catch(Exception e) {
			StartBrowser.childTest.fail("Unable to perform type action on : with test data : " + testData,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
		
	}
	
	
	public String screenShot()
	{
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
	
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
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
