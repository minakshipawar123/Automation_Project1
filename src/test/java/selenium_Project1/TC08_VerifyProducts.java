package selenium_Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC08_VerifyProducts {
	WebDriver driver;

	@BeforeSuite
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationexercise.com");
		Thread.sleep(2000);

		String expTitle = "Automation Exercise";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expTitle)) {
			System.out.println("Homepage verified");
		} else {
			System.out.println("Homepage not verified");
		}
	}

	@Test(priority = 1)
	public void productsBtn() {
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[2]//a")).click();

		String expTitle = "Automation Exercise";
		String actualTitle = driver.getTitle();
		System.out.println(driver.getTitle());
		if (actualTitle.equals(expTitle)) {
			System.out.println("All products page verified successfully");
		} else
			System.out.println("All products page not verified successfully");
	}

	@Test(priority = 2)
	public void viewProduct() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,2000)");
		driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
	}
	
	  @Test(priority=3) public void verifyProductDetails() 
	  { 
	  String productDetails=driver.findElement(By.xpath("//div[@class='product-information']//h2")).getText();
	  String productCategory=driver.findElement(By.xpath("//div[@class='product-information']//p[1]")).getText();
	  driver.findElement(By.xpath("//div[@class='product-information']//span//span")).getText();
	  driver.findElement(By.xpath("//div[@class='product-information']//p//b")).getText();
	  driver.findElement(By.xpath("//div[@class='product-information']//p[3]//b")).getText();
	  driver.findElement(By.xpath("//div[@class='product-information']//p[4]//b")).getText(); }
	  
	  @AfterSuite
		public void closeBrowser() {
			driver.close();
		} 
}
