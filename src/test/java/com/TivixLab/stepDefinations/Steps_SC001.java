package com.TivixLab.stepDefinations;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.TivixLab.Utilities.BaseClass;
import com.TivixLab.Utilities.TakeErrorScreenshot;
import com.TivixLab.pageObjects.CarRentPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps_SC001 extends BaseClass{
	
	WebDriver driver;
	CarRentPages carrentpageobj;   //Import  Home_Pages class and create object of that class
	BaseClass baseclassobj;
	TakeErrorScreenshot tsobj;
	
	@Given("Launch the browser")
	public void launch_the_browser() {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver(); 
	}
	
	@Given("Enter URL")
	public void enter_url() {
		driver.get(baseURL);   //Open given URL
		driver.manage().window().maximize();  	 //To maximize the opened window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); 	  //Wait still fully page loaded
		carrentpageobj=new CarRentPages(driver);
	}
	
	@Given("Select specific Country {string} and City {string}")
	public void select_specific_country_and_city(String countryname, String cityname) {
		carrentpageobj.selectCountryName(countryname);
		//System.out.println("Selected Country name: "+selectedcountry); 
		carrentpageobj.selectCityName(cityname);
//		System.out.println("City Selected: "+cityselected);
	}
	
	@Given("Enter Car {string} Model")
	public void enter_car_model(String carmodel) {
		carrentpageobj.setCarModelName(carmodel);
		System.out.println("Car model entered..");  
	}
	
	@Given("Select both  Pick-up and Drop-Off date")
	public void select_both_pick_up_and_drop_off_date() {
		carrentpageobj.selectPickupDate();
		carrentpageobj.selectDropoffDate();
		System.out.println("Pick-up and Drop-off date are  Selected");
	}
	
	@Then("Click on Search button")
	public void click_on_search_button() throws IOException {
		carrentpageobj.clickOnSearchButton();
		
		String expectedtitle="Car rent";
		String actualtitle=driver.getTitle();
		System.out.println("Title :"+actualtitle);
		if(actualtitle.equalsIgnoreCase(expectedtitle))
		{
			System.out.println("Search button clicked..");
			tsobj=new TakeErrorScreenshot(driver, "sucess");
		}

		else
		{
			System.out.println("Taking screenshot of error...");
			tsobj=new TakeErrorScreenshot(driver, "searcherror");
		}
	}
	@Then("Brower close sucessfully")
	public void brower_close_sucessfully() {
		driver.close();
		  System.out.println("Browser closed sucessfully...");
	}

//Scenario-2  to rent a car, the user needs to provide dates
	
	@Given("Select Pick-up date {string}")
	public void select_pick_up_date(String pdate) {
		carrentpageobj.selectPickupDateByString(pdate); 
	}
	@Given("Select Drop-Off date {string}")
	public void select_drop_off_date(String ddate) {
		carrentpageobj.selectDropoffDateByString(ddate);
	}

	//Scenario-3    The user should be able to see car details after clicking "Rent” button
	
	@Then("Click on Rent button for selected car model {string}")
	public void click_on_rent_button_for_selected_car_model(String carmodel) throws InterruptedException, IOException {
		
		List<WebElement> allrowsno=driver.findElements(By.xpath("//*[@id=\"search-results\"]/tbody/tr/th"));
		
		List<WebElement> allcarmodel=driver.findElements(By.xpath("//*[@id=\"search-results\"]/tbody/tr/td[2]"));
		System.out.println("Total no of car models : " + allcarmodel.size());
		for(int i=0;i<allcarmodel.size();i++)
			{  
				if((allcarmodel.get(i).getText()).equals(carmodel))
				{
					String str1=allcarmodel.get(i).getText();
					String rowno= allrowsno.get(i).getText();
					System.out.println(rowno+" :"+str1+" Car model found at:"+(i+1)+" position");
					Thread.sleep(2000);
					String rentButton="//a[@href=\"/details/"+rowno+"\"]";
					WebElement rentButtonclick=driver.findElement(By.xpath(rentButton));
					rentButtonclick.click();
					
					String expectedtitle=carmodel;
					System.out.println("Expected Title :"+expectedtitle);
					String actualtitle=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]")).getText();
					System.out.println("Actual Title :"+actualtitle);
					if(actualtitle.equalsIgnoreCase(expectedtitle))
					{
						System.out.println("Car details displayed sucessfully..");
						tsobj=new TakeErrorScreenshot(driver, "cardetails");
					}

					else
					{
						System.out.println("Car details not displayed sucessfully...");
						tsobj=new TakeErrorScreenshot(driver, "cardisplayerror");
					}
					break;
				}
				
			}
}
	
	//Scenario-4 The user should be able to provide personal data in the rent form

@Then("Click on Rent button.")
public void click_on_rent_button() {
	WebElement rentButton=driver.findElement(By.xpath("//a[@href=\"/rent/49\"]"));
	rentButton.click();
}

@Then("Fill personal data")
public void fill_personal_data() throws InterruptedException, IOException {
   System.out.println("Personal data filling started");
   Thread.sleep(3000);
   carrentpageobj.setUserName("Swati");
   carrentpageobj.setUserLastName("Kadam");
   carrentpageobj.setUserCardNumber("12345678654");
   
    String emailid=generateRandomstring()+"@gmail.com";
    carrentpageobj.setUserEmail(emailid);
    tsobj=new TakeErrorScreenshot(driver, "fillpersonaldetail");
	System.out.println("Personal data filling done.");
}

@Then("click on Rent button to submit")
public void click_on_rent_button_to_submit() throws IOException {
    System.out.println("All user personal details filling  done...");
    carrentpageobj.clickOnRentButton();
    tsobj=new TakeErrorScreenshot(driver, "404pagenotfound");
	System.out.println("After clicking on Rent button gives Error 404 Page not found.");
}

}
