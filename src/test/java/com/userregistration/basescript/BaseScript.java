package com.userregistration.basescript;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.RandomAccess;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseScript {
	
	public static WebDriver driver;
	public static Properties prop;
	

	//public static void main(String[] args) throws InterruptedException {
			//readPropertiesFile();	
	//}
	
	//public static void readPropertiesFile() {
		//To provide path for your driver i.e chromedriver
		public BaseScript() {
			
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream fis = new FileInputStream(".//prop.properties");
				prop.load(fis);
				{	
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					driver.get(prop.getProperty("URL"));
					driver.manage().window().maximize();
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}	
		
	}
	
		protected static String readPropertiesFile(String key) {
			return prop.getProperty(key);
			
		}
	
	public static void sleep(int num) throws InterruptedException {
		Thread.sleep(num);
	}
	
	public static void clickEvent(String xpath) {
		driver.findElement(By.xpath(readPropertiesFile(xpath))).click();
	}
	
	public static void sendKeysEvent(String xpath,String value) {
		driver.findElement(By.xpath(readPropertiesFile(xpath))).sendKeys(readPropertiesFile(value));
	}
	
	public static void alertPopup(String xpath) {
		driver.findElement(By.xpath(readPropertiesFile(xpath))).click();
	}
	
	public static void createrandomPassword() {
		prop.setProperty("random_string_placeholder","Role@1" + generateRandomvalues(4));
	}
	
	
	public static void createRandom() {
		prop.setProperty("random_string_placeholder","Sonali" + generateRandomvalues(3));
	}
	public static void createRandomForEmail() {
		prop.setProperty("random_string_placeholder", generateRandomvalues(10)+"@gmail.com");
	}
	
	public static void invalidEmail() {
		prop.setProperty("random_string_placeholder", generateRandomvalues(10));
	}
	
	public static void hyperLinks(String xpath) throws InterruptedException{
		driver.findElement(By.xpath(prop.getProperty(xpath))).click();
		
		// Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Close all tabs except the first one
        String firstWindowHandle = windowHandles.iterator().next();
        for (String handle : windowHandles) {
            if (!handle.equals(firstWindowHandle)) {
                driver.switchTo().window(handle);
                sleep(3000);
                driver.close();
            }
        }

        // Switch back to the first window
        driver.switchTo().window(firstWindowHandle);

	}
	
	
	public static String generateRandomvalues(int length) {
		 // Characters to be used for generating the random string
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // StringBuilder to construct the random string
        StringBuilder stringBuilder = new StringBuilder(length);

        // Random object to generate random indices
        Random random = new Random();

        // Generate random characters and append them to the StringBuilder
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
        
        	   
       }

     public void tearDown() {
         // Close the browser
         driver.quit();   
    }
}



