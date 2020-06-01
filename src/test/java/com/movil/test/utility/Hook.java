/**
 * 
 */
package com.movil.test.utility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Hook {

	private static WebDriver driver;
	private static AndroidDriver<WebElement> driverr = null;
	private static DesiredCapabilities capabilities=null;
	

	@Before("@appium")
	public void setUpAppium() throws MalformedURLException
	{
		manageCapabilitiesAndroid();
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}

	public static void manageCapabilitiesAndroid()
	{
		capabilities = DesiredCapabilities.android();
		capabilities.setCapability("--session-override", true);
		capabilities.setCapability(MobileCapabilityType.PLATFORM, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capabilities.setCapability("deviceName", "420052446a99337b");
		capabilities.setCapability("udid", "420052446a99337b");
		capabilities.setCapability("platformVersion", "5.1");
		capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"//App//VodQA.apk");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("newCommandTimeout", 6000);
		capabilities.setCapability("autoGrantPermissions", true);
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}




}


