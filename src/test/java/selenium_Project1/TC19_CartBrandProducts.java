package selenium_Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC19_CartBrandProducts {
	WebDriver driver;
	@BeforeSuite
	public void setUp() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationexercise.com");
		Thread.sleep(2000);
	}
	@Test(priority=1)
	public void verifyBrands() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='/products']")).click();
		String brands=driver.findElement(By.xpath("//h2[contains(text(),'Brands')]")).getText();
		System.out.println(brands);
		Assert.assertEquals(brands, "BRANDS");
		Thread.sleep(2000);
	}
	@Test(priority=2)
	public void selectBrands() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,5000)");
		driver.findElement(By.xpath("//ul[@class='nav nav-pills nav-stacked']//li[1]//a")).click();
		Thread.sleep(2000);
	}
	@Test(priority=3)
	public void verifyPage() {
		String title=driver.getTitle();
		Assert.assertEquals(title, "Automation Exercise - Polo Products");
		System.out.println(title);
		
		String title2=driver.findElement(By.xpath("//h2[contains(text(),'Brand - Polo Products')]")).getText();
		Assert.assertEquals(title2, "BRAND - POLO PRODUCTS");
		System.out.println(title2);
	}
	@Test(priority=4)
	public void selectNextBrands() throws InterruptedException {
		driver.findElement(By.xpath("//ul[@class='nav nav-pills nav-stacked']//li[5]//a")).click();
		Thread.sleep(2000);
	}
	@Test(priority=5)
	public void verifyPage2() {
		String title3=driver.getTitle();
		Assert.assertEquals(title3, "Automation Exercise - Babyhug Products");
		System.out.println(title3);
		
		String title4=driver.findElement(By.xpath("//h2[contains(text(),'Brand - Babyhug Products')]")).getText();
		Assert.assertEquals(title4, "BRAND - BABYHUG PRODUCTS");
		System.out.println(title4);
	}
	@AfterSuite 
	 public void closeBrowser() { 
		 driver.close(); 
		 }
}