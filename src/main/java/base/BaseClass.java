/**
 * 
 */
package base;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import tests.ExtentReporterDemo;

/**
 * @author anand acharya
 *
 */
public class BaseClass extends ExtentReporterDemo {

	public AppiumDriver<MobileElement> driver; 
	
	@BeforeTest
	public void setup(){
		
		try{
		DesiredCapabilities caps = new DesiredCapabilities();
		
		String platform = "android";
		
		if(platform.equalsIgnoreCase("android")){
		//caps.setCapability("platformName", "ANDROID");
		//caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus3");
		caps.setCapability(MobileCapabilityType.UDID, "b9fa26bc");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		//caps.setCapability(MobileCapabilityType.APP, ""); //for native apps
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		}
		
		else if(platform.equalsIgnoreCase("ios")){
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
			//caps.setCapability(MobileCapabilityType.UDID, "b9fa26bc"); //not required for simulators
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		}
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,caps);
		//driver = new AndroidDriver<MobileElement>(url,caps); //subclass of AppiumDriver
		//driver = new IOSDriver<MobileElement>(url,caps);
		//driver = new WindowsDriver<MobileElement>(url,caps);
		
		}catch(Exception exp){
			System.out.println("Cause is : "+exp.getCause());
			System.out.println("Message is : "+exp.getMessage());
			exp.printStackTrace();
		}
	}

	@Test
	public void sampleTest(){
		System.out.println("Test started");
	}
	
	@AfterTest
	public void teardown(){
		driver.close();
		driver.quit();
	}
}
