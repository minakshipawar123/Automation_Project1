package selenium_Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC21_AddReview {
	WebDriver driver;
	@BeforeSuite
	public void setUp() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationexercise.com");
		Thread.sleep(2000);
	}
	@Test(priority=1)
	public void verifyProductPage() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='/products']")).click();
		String title=driver.getTitle();
		Assert.assertEquals(title, "Automation Exercise - All Products");
		System.out.println(title);
		Thread.sleep(2000);
    }
	@Test(priority=2)
	public void viewProductBtn() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,2000)");
		driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
		Thread.sleep(2000);
	}
	@Test(priority=3)
	public void verifyReview() throws InterruptedException {
		String review=driver.findElement(By.xpath("//a[@href='#reviews']")).getText();
		System.out.println("review");
		Assert.assertEquals(review, "WRITE YOUR REVIEW");
		driver.findElement(By.id("name")).sendKeys("Minakshi");
		driver.findElement(By.id("email")).sendKeys("Minakshi1@gmail.com");
		driver.findElement(By.id("review")).sendKeys("Good!");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-default pull-right']")).click();
		Thread.sleep(2000);
	}
	@Test(priority=4)
	public void verifySuccessMsg() {
		String title2=driver.findElement(By.xpath("//div[@class='alert-success alert']//span[contains(text(),'Thank you for your review.')]")).getText();
		Assert.assertEquals(title2, "Thank you for your review.");
		System.out.println(title2);
	} 
	@AfterSuite 
	public void closeBrowser() {
		driver.close(); 
		}
	
}
