package objectRepository;

import org.openqa.selenium.By;

public class bookHotel_2 {
	public static By clickHotel = By.id("booking_engine_hotels");
	
	public static By expandTraveller_Hotel = By.id("BE_Hotel_pax_info");
	
	public static By clickMinus = By.xpath("//span[@class='ddSpinnerMinus']");
	
	public static By clickSearchHotel = By.id("BE_hotel_htsearch_btn");
	
	public static By click5Star = By.xpath("//label[@title='5 star']");
	
	public static By click_1stResult = By.xpath("//a[@title='Country inn and Suites by Raddison, Goa Candolim']");
	
	public static By clickChooseRoom = By.xpath("//*[@id='choose-room-disable']");
	
	public static By clickBookNow = By.xpath("//button[@class='new-blue-button newBtn  choose-room-button ']");
	
//	public static By clickBookNow = By.xpath("//*[@id=\"roomWrapper0000138754\"]/div[2]/div[5]/button");
	
	public static By enterEmail = By.id("additionalContactEmail");
	
	public static By enterMobile = By.id("additionalContactMobile");
	
	//selct Mr
	
	public static By enterFirstName = By.id("travellerf0");
	
	public static By enterLastName = By.id("travellerl0");
	
	public static By clickContinue = By.xpath("//button[@ng-click='continueToNextPage(travellerForm.$valid, travellerForm);']");
	
}
