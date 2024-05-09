package com.userregistration.testscript;

import org.testng.annotations.Test;

public class TestScenario03 extends TestScenario02{
	


	//public static void main(String[] args) throws InterruptedException  {
	@Test
	public static void validatePasswordWithConfirmPasswordTest() throws InterruptedException {
		//readPropertiesFile();
		getName();
		getEmail();
		
		clickEvent("Password_XPATH");
		createrandomPassword();
		sendKeysEvent("Password_XPATH", "random_string_placeholder");
		clickEvent("Password_icon");
		sleep(3000);
		
		clickEvent("Confirm_Password_XPATH");
		createrandomPassword();
		sendKeysEvent("Confirm_Password_XPATH", "random_string_placeholder");
		clickEvent("Confirm_Password_icon");
		
		hyperLinks("EULA_XPATH");

		hyperLinks("NDA_XPATH");

		hyperLinks("DPA_XPATH");

		hyperLinks("PRIVACY_XPATH");

		hyperLinks("TERMS_XPATH");	

		getCheckbox();

	}

}
