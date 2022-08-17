package scripts;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import config.ConfigFileReader;
import config.StartBrowser;
import objectRepository.login_1;

public class Login_1 extends StartBrowser {
	static Logger log = Logger.getLogger(Login_1.class);
	ConfigFileReader configFileReader;
	
	@Test
	public void Login() throws Exception
	{
		configFileReader = new ConfigFileReader();
		
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		
		driver.get(configFileReader.getApplicationUrl());
		log.info("Opening URL");
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		log.info("Implicitly Wait");
		
		//ActionDriver aDriver = new ActionDriver();
	//	aDriver.mouseHover(login_1.myAccount_Hover);
		
//		WebElement eleHover = driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
		WebElement eleHover = driver.findElement(login_1.myAccount_Hover);
		Actions actions = new Actions(driver);
		actions.moveToElement(eleHover).perform();
		log.info("Hovering on 'My Account'");
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		
		driver.findElement(login_1.ClickLogin).click();
		log.info("Clicking on Login Button");
		
		driver.findElement(login_1.inputEmail).sendKeys("ranganatham7026@gmail.com");
		log.info("Entering Email");
		
		driver.findElement(login_1.clickContinue).click();
		log.info("Clicking on Continue button");
		
		driver.findElement(login_1.inputPassword).sendKeys("Ranga@12345");
		log.info("Entering Password");
		
		driver.findElement(login_1.ClickLogin_2).click();
		log.info("Clicking on Login Button");
		log.info("Error 'Something has gone wrong'");
		
		this.takeSnapShot(driver, "./Screenshot/Login.png");
		log.info("Taking Snapshot of Login Page\n");
		System.out.println("Taking Screenshot of Login page");
		
		
		
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
