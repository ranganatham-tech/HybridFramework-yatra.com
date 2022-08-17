package scripts;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import config.ConfigFileReader;
import config.StartBrowser;
import objectRepository.bookHotel_2;

public class BookHotel_2 extends StartBrowser {
	static Logger log = Logger.getLogger(BookHotel_2.class);
	ConfigFileReader configFileReader;
	
	@Test
	public void BookHotel() throws Exception
	{
		configFileReader = new ConfigFileReader();
		
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		
		
		driver.get(configFileReader.getApplicationUrl());
		log.info("\n\nOpening Website");
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		log.info("Implicitly waiting");
		
		driver.findElement(bookHotel_2.clickHotel).click();
		log.info("Clicking on Hotel");
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.findElement(bookHotel_2.expandTraveller_Hotel).click();
		log.info("Expanding of Traveller & Hotel");
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.findElement(bookHotel_2.clickMinus).click();
		
		
		driver.findElement(bookHotel_2.clickSearchHotel).click();
		log.info("Clicking on Search");
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.findElement(bookHotel_2.click5Star).click();
		log.info("Clicking 5 Star");
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.findElement(bookHotel_2.click_1stResult).click();
		log.info("Clicking on 1st Result");
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
//		driver.findElement(bookHotel_2.clickChooseRoom).click();
//		log.info("Clicking on Choose Room");
		
		JavascriptExecutor j = (JavascriptExecutor) driver;
	    j.executeScript("window.scrollBy(0,2000)");
	    log.info("Scrolling down");
		
//		driver.findElement(By.xpath("//a[@href='#view-room']")).click();
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
//		this.takeSnapShot(driver, "./Screenshot/Book_Hotel_Fail.png");
//		log.info("Failing and Taking Snapshot");
//		System.out.println("Failing and taking Snapshot");
		
		// It will return the parent window name as a String
		String parent=driver.getWindowHandle();

		Set<String>s1=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s1.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
			driver.switchTo().window(child_window);
		}

		}
//		driver.findElement(bookHotel_2.clickBookNow).submit();
		driver.get("https://hotel.yatra.com/hotel-checkout/dom/hotel/review?checkInDate=17/08/2022&checkOutDate=19/08/2022&city.name=Goa&city.code=Goa&propertySource=TGU&country.name=India&country.code=IND&hotelId=00005781&tenant=B2C&rooms[0].id=1&rooms[0].noOfAdults=1&_rn=qng&roomTypeId=0000021572&ratePlanId=0000078011&excludeHotelTax=true&htlFindMthd=hotel%20name%20click&htlSrchRank=2&viewType=list&chpFare=0&searchId=38cedd01-19cf-4732-8198-70867fb9fd3c");
		log.info("Clicking on Book Now");
		
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.findElement(bookHotel_2.enterEmail).sendKeys("ranganatham7026@gmail.com");
		log.info("Entered Email");
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.findElement(bookHotel_2.enterMobile).sendKeys("8884933835");
		log.info("Entering Mobile number");
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		Select s = new Select(driver.findElement(By.xpath("//*[@id=\'paxNum0\']/div[2]/div[1]/span/select")));
		s.selectByVisibleText("Mr.");
		
		driver.findElement(bookHotel_2.enterFirstName).sendKeys("Ranganatha");
		log.info("Entering First Name");
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.findElement(bookHotel_2.enterLastName).sendKeys("Ranga");
		log.info("Entering Last Name");
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.findElement(bookHotel_2.clickContinue).click();
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		this.takeSnapShot(driver, "./Screenshot/Book_Hotel.png");
		log.info("Taking Snapshot of Book Hotel Page\n");
		System.out.println("Taking Snapshot of Book Hotel Page");
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
