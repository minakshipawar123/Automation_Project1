package selenium_Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC18_ViewCategoryProducts {
	WebDriver driver;
	@BeforeSuite
	public void setUp() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationexercise.com");
		Thread.sleep(2000);
	}
	@Test(priority=1)
	public void verifyCategory() {
		String category=driver.findElement(By.xpath("//div[@class='left-sidebar']//h2[contains(text(),'Category')]")).getText();
		System.out.println(category);
		Assert.assertEquals(category, "CATEGORY");
	}
	@Test(priority=2)
	public void selectCategory() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='#Women']")).click();
		driver.findElement(By.xpath("//a[@href='/category_products/1']")).click();
		Thread.sleep(2000);
		String womenCategory=driver.findElement(By.xpath("//h2[contains(text(),'Women - Dress Products')]")).getText();
		System.out.println(womenCategory);
		Assert.assertEquals(womenCategory, "WOMEN - DRESS PRODUCTS");
	}
	@Test(priority=3)
	public void menCategory() throws InterruptedException {
	      driver.findElement(By.xpath("//a[@href='#Men']")).click();
	      JavascriptExecutor js = (JavascriptExecutor) driver;
	      js.executeScript("window.scrollBy(0,500)");
		  driver.findElement(By.xpath("//a[@href='/category_products/6']")).click();
		  Thread.sleep(2000);
	}
	@Test(priority=4)
	public void verifyPage() {
		String title=driver.getTitle();
		Assert.assertEquals(title, "Automation Exercise - Jeans Products");
		System.out.println(title);
	}
	@AfterSuite 
	 public void closeBrowser() { 
		 driver.close(); 
		 }
}
