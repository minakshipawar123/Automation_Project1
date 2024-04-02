package selenium_Project1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC07_VerifyTestCasesPage {
	WebDriver driver;
	@BeforeSuite
	public void setUp() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationexercise.com");
		Thread.sleep(2000);
		
		String expTitle="Automation Exercise";
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expTitle)) {
			System.out.println("Homepage verified");
		}else {
			System.out.println("Homepage not verified");
		}
	}
	@Test
	public void testCasesBtn() {
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[5]//a")).click();
		String expTitle="Automation Practice Website for UI Testing - Test Cases";
		String actualTitle=driver.getTitle();
		if(expTitle.equals(actualTitle)) {
			System.out.println("User navigated to test cases page successfully");
		}else
			System.out.println("User not navigated to test cases page successfully");
	}
	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
}
	 

