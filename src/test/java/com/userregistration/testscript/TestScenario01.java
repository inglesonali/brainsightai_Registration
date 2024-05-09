package com.userregistration.testscript;


import org.testng.annotations.Test;

import com.userregistration.basescript.BaseScript;

public class TestScenario01 extends BaseScript {
	
	//public static void main(String[] args) throws InterruptedException {
		@Test
		public static void userRegistrationTest() throws InterruptedException {
			
			//readPropertiesFile(null);
			
			getName();
			
			getEmail();
			
			getPassword();

			getCheckbox();	
			
			userLogin();
	}
	
	private static void userLogin() throws InterruptedException {
		// TODO Auto-generated method stub
		sleep(2000);
		clickEvent("SignIn_XPATH"); 
		sleep(2000);

		clickEvent("LoginSignup_XPATH");
		sleep(2000);

	}

	public static void getCheckbox() throws InterruptedException {
		sleep(2000);
		clickEvent("Term_checkbox_XPATH");
		clickEvent("Declare_checkbox_XPATH");
		clickEvent("SignUp_XPATH");		
	}

	public static void getPassword() throws InterruptedException {
		sleep(2000);
//		driver.findElement(By.xpath(prop.getProperty("Password_XPATH"))).click();
//		driver.findElement(By.xpath(prop.getProperty("Password_XPATH"))).sendKeys(prop.getProperty("Password"));
//		driver.findElement(By.xpath(prop.getProperty("Password_icon"))).click();
		
		clickEvent("Password_XPATH");
		createrandomPassword();
		sendKeysEvent("Password_XPATH", "Password");
		clickEvent("Password_icon");

		sleep(2000);
//		driver.findElement(By.xpath(prop.getProperty("Confirm_Password_XPATH"))).click();
//		driver.findElement(By.xpath(prop.getProperty("Confirm_Password_XPATH"))).sendKeys(prop.getProperty("Confirm_Password"));
		
		clickEvent("Confirm_Password_XPATH");
		sendKeysEvent("Confirm_Password_XPATH", "Confirm_Password");
		clickEvent("Confirm_Password_icon");
		
	}

	public static void getEmail() {
//		driver.findElement(By.xpath(prop.getProperty("Email_XPATH"))).click();
//		driver.findElement(By.xpath(prop.getProperty("Email_XPATH"))).sendKeys(prop.getProperty("Email_ID"));
		
		clickEvent("Email_XPATH");
		createRandomForEmail();
		sendKeysEvent("Email_XPATH", "random_string_placeholder");
		
	}

	public static void getName() throws InterruptedException {
		// Generate a random string
				// driver.findElement(By.xpath(prop.getProperty("First_XPATH"))).click();
				// driver.findElement(By.xpath(prop.getProperty("First_XPATH"))).sendKeys(prop.getProperty("FisrtName"));
				
				sleep(3000);
				clickEvent("First_XPATH");
				createRandom();
				sendKeysEvent("First_XPATH", "random_string_placeholder");

				// driver.findElement(By.xpath(prop.getProperty("Last_XPATH"))).click();
				// driver.findElement(By.xpath(prop.getProperty("Last_XPATH"))).sendKeys(prop.getProperty("LastName"));

				clickEvent("Last_XPATH");
				createRandom();
				sendKeysEvent("Last_XPATH", "random_string_placeholder");
				sleep(2000);		
	}
}
