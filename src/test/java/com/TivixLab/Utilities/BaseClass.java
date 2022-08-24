package com.TivixLab.Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class BaseClass {
	
	Readconfig RCobj=new Readconfig();
	public String baseURL=RCobj.getApplicationURL();
	@Test
	public String generateRandomstring()   //To generate random string
	{
		String str=RandomStringUtils.randomAlphanumeric(12) ;
		return str;	
	}
	
	@Test
	public static boolean isValidName(String name)
	{
		  String regex="[a-zA-Z]+";
		 Pattern p = Pattern.compile(regex);
		 if (name == null) {
	            return false;
	        }
		 Matcher m = p.matcher(name);
		 return m.matches()&&(name.length()<50);
	}
@Test
	public static  boolean isValidCardNumber(String cardno)
	{
		 String regex="[0-9]+";
				  Pattern p = Pattern.compile(regex);
					 if (cardno == null) {
				            return false;
				        }
					 Matcher m = p.matcher(cardno);
					 return m.matches()&&(cardno.length()<25);
}
	@Test
	public  boolean isValidEmail(String email)
	{
		String regex="^[a-zA-Z]+[0-9_.-]*@[a-zA-Z.0-9]+$";
		 Pattern p = Pattern.compile(regex);
		 if (email == null) {
	            return false;
	        }
		 Matcher m = p.matcher(email);
		 return m.matches()&&(email.length()<50);	
}

}