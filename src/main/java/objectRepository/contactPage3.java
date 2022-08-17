package objectRepository;

import org.openqa.selenium.By;

public class contactPage3 {
	public static By EleHover = By.xpath("//a[@href='https://www.yatra.com/support']");
	
	public static By clickContact = By.xpath("//*[@id=\'customer_support_ddn\']/ul/li[3]/a");
	
	public static By clickContactUS = By.className("contact-us-email");
	
	public static By enterFullName = By.id("cs_fullName");
	
	public static By enterEmail = By.id("cs_email");
	
	public static By enterMobile = By.id("cs_phone");
	
	public static By browseFile = By.id("BrowserHidden_2");
	
}
