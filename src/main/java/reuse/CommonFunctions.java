package reuse;

import org.openqa.selenium.WebDriver;

import config.StartBrowser;
import wdcmds.ActionDriver;

public class CommonFunctions {
	
	public ActionDriver aDriver;
	public WebDriver driver;
	
	public CommonFunctions()
	{
		aDriver = new ActionDriver();
		driver = StartBrowser.driver;
	}
	
	public void Login() throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Opening of Application");
		aDriver.launchApplication("https://www.yatra.com/");
		
	}
}
