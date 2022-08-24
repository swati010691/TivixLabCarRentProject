package com.TivixLab.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CarRentPages {

	WebDriver driver;
	@FindBy(xpath="//*[@id=\"search_form\"]/div[1]/label") WebElement countrylabel;
	@FindBy(id="country") WebElement selectcountry;
	
	@FindBy(xpath="//*[@id=\"search_form\"]/div[2]/label") WebElement citylaabel;
	@FindBy(id="city") WebElement selectcity;
	
	@FindBy(xpath="//*[@id=\"search_form\"]/div[3]/label") WebElement modellabel;
	@FindBy(id="model")  WebElement modelname;
	 
	@FindBy(id="pickup") WebElement pickupdate;
	@FindBy(id="dropoff") WebElement dropoffdate;
	
	@FindBy(xpath="//button[text()=\"Search\"]") 
	WebElement searchbtn;
	
	
	@FindBy(id="search-results") WebElement searchtable;
	
	@FindBy(id="name") WebElement userName;
	@FindBy(xpath="//*[@id=\"rent_form\"]/h5[1]") WebElement nameErrorMsg;
	@FindBy(id="last_name") WebElement userLastName;
	@FindBy(name="card_number") WebElement userCardNumber;
	@FindBy(name="email")  WebElement userEmail;
	@FindBy(css="button.btn-primary") WebElement clickRentButton;
	 
	public CarRentPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String selectCountryName(String countryname)
	{
		Select countrychoice=new Select(selectcountry);
		List <WebElement> alloption=countrychoice.getOptions();
		String selectedval=null;
		for(WebElement item:alloption)
		{
			selectedval=item.getText();
			
			if(selectedval.equals(countryname))
			{
				item.click();
				System.out.println("Selected Country name: "+selectedval); 
				break;
			}
		}
		return selectedval;
	}
	
	public String selectCityName(String cityname)
	{
		Select citychoice=new Select(selectcity);
		List <WebElement> alloption=citychoice.getOptions();
		String  selectedval=null;
		for(WebElement item:alloption)
		{
			selectedval=item.getText();
			
			if(selectedval.equals(cityname))
			{
				item.click();
				System.out.println("Selected Country name: "+selectedval); 
				break;
			}
		}
		return  selectedval;
		
	}
	
	public void setCarModelName(String carname)
	{
		modelname.clear();  //To clear the input text value 
		modelname.sendKeys(carname);   //To set new value to input box 
	}
	
	public void selectPickupDate()
	{
		pickupdate.sendKeys("08");
		pickupdate.sendKeys("23");
		pickupdate.sendKeys("2022");
	}
	
	public void selectPickupDateByString(String pdate)
	{
		pickupdate.sendKeys(pdate);
	}
	
	public void selectDropoffDate()
	{
		dropoffdate.sendKeys("08");
		dropoffdate.sendKeys("26");
		dropoffdate.sendKeys("2022");
	}
	public void selectDropoffDateByString(String ddate)
	{
		dropoffdate.sendKeys(ddate);
	}
	
	public void clickOnSearchButton()
	{
		searchbtn.click();
	}
	
	public void setUserName(String uName)
	{
		if(uName==null)
		{
			String errormsg=nameErrorMsg.getText();
			System.out.println("Error Message:"+errormsg);
		}
		
		userName.sendKeys(uName);
	}
	public void setUserLastName(String lName)
	{
		userLastName.sendKeys(lName);
	}
	public void setUserCardNumber(String cardno)
	{
		userCardNumber.sendKeys(cardno);
	}
	public void setUserEmail(String email)
	{
		userEmail.sendKeys(email);	
	}
	public void clickOnRentButton()
	{
		clickRentButton.click();
	}
}
