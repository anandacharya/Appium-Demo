/**
 * 
 */
package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseClass;

/**
 * @author anand acharya
 *
 */
public class Tests extends BaseClass {

	@Test
	public void testOne(){
		 // creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("Test One", "Sample test for demo");
        // log(Status, details)
        test.log(Status.INFO, "Test one started");
        
		driver.get("https://google.com");
		test.log(Status.PASS, "Navigated to google");
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		test.log(Status.PASS, "searching automation");
		
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		test.log(Status.PASS, "Enter search key");
		
		System.out.println("Completed Test one");
	}
	
	@Test
	public void loginTest(){
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("username")).sendKeys("enter username");
		driver.findElement(By.id("password")).sendKeys("enter password");
		driver.findElement(By.id("login")).click();
	}
}
