package selenium_Project1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC10_VerifySubscription {
	WebDriver driver;
	@BeforeSuite
	public void setUp() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationexercise.com");
		Thread.sleep(2000);
		
		String title=driver.getTitle();
		Assert.assertEquals(title, "Automation Exercise");
		System.out.println(title);
	}
	@Test
	public void verifySubscription() {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.scrollBy(0,8500)");
		driver.findElement(By.id("susbscribe_email")).sendKeys("minakshi111@gmail.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String msg=driver.findElement(By.xpath("//div[@class='alert-success alert']")).getText();
		Assert.assertEquals(msg, "You have been successfully subscribed!");
		System.out.println(msg);
	}
	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
}
	 

