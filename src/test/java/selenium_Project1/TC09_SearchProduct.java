package selenium_Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC09_SearchProduct {
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
	public void productsBtn() {
		driver.findElement(By.xpath("//a[@href='/products']")).click();
		String title=driver.getTitle();
		Assert.assertEquals(title, "Automation Exercise - All Products");
		System.out.println(title);
	}
	@Test(priority=2)
	public void searchProduct() throws InterruptedException {
		driver.findElement(By.id("search_product")).sendKeys("Tops");
		driver.findElement(By.xpath("//button[@id='submit_search']")).click();
		Thread.sleep(2000);
		String searchedProduct=driver.findElement(By.xpath("//h2[contains(text(),'Searched Products')]")).getText();
		Assert.assertEquals(searchedProduct, "SEARCHED PRODUCTS");
		System.out.println(searchedProduct);
	}
	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
}
	 

