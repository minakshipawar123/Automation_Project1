package selenium_Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC13_VerifyProductQuantity {
	WebDriver driver;
	@BeforeSuite
	public void setUp() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationexercise.com");
		Thread.sleep(2000);
		
		String title=driver.getTitle();
		Assert.assertEquals(title, "Automation Exercise");
	}
	
	@Test(priority=1)
	public void viewProduct() {
		//add
		driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
		String title=driver.getTitle();
		Assert.assertEquals(title, "Automation Exercise - Product Details");
		System.out.println(title);
		driver.findElement(By.xpath("//input[@type='number']")).clear();
        driver.findElement(By.xpath("//input[@type='number']")).sendKeys("4");
        driver.findElement(By.xpath("//button[@type='button']")).click();
        driver.findElement(By.xpath("//a[@href='/view_cart']//u")).click();
        
	}
	
	  @AfterSuite 
	  public void closeBrowser() { 
		  driver.close(); 
		  }
	 
}



