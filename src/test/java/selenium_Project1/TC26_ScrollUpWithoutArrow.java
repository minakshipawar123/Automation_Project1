package selenium_Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC26_ScrollUpWithoutArrow {
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
	@Test(priority=1)
	public void verifyProductPage() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,8500)");
	    Thread.sleep(2000);
	    String sub=driver.findElement(By.xpath("//h2[contains(text(),'Subscription')]")).getText();
	    System.out.println(sub);
	    Assert.assertEquals(sub, "SUBSCRIPTION");
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
	    js2.executeScript("window.scrollBy(0,-8500)");
    }
	@Test(priority=2)
	public void verifyMsg() {
		String msg=driver.findElement(By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]")).getText();
	    System.out.println(msg);
	    Assert.assertEquals(msg, "Full-Fledged practice website for Automation Engineers");
	}
	 
	 @AfterSuite 
	 public void closeBrowser() { 
		 driver.close(); 
		 }
}
