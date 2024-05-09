package com.userregistration.testscript;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestScenario02 extends TestScenario01{

	//public static void main(String[] args) throws InterruptedException {
	@Test
	public static void validateEmailTest()  throws InterruptedException {
		
		//readPropertiesFile();
		getName();
	
		//To get already registered user email id from properties file
		driver.findElement(By.xpath(readPropertiesFile("Email_XPATH"))).sendKeys(readPropertiesFile("Email_ID"));
		
		getPassword();
		getCheckbox();
		
		WebElement errorMessage = driver.findElement(By.xpath(readPropertiesFile("AlreadyRegisterUser")));
		
		alertPopup("GoBack_XPATH");
		driver.findElement(By.xpath(readPropertiesFile("GoBack_XPATH"))).click();

       

	}

}
