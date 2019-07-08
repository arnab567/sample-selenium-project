package com.sample.login;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleLoginPage {

	public static void main(String[] a) throws IOException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).isDisplayed();
		driver.findElement(By.id("pass")).isDisplayed();
		driver.findElement(By.xpath("//input[@value='Log In']")).isEnabled();

		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File save = new File("../Images/actual/" + driver.getTitle() + "_actual.png");
		try {
			FileUtils.copyFile(scr, save);
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
		driver.close();
	}
}
