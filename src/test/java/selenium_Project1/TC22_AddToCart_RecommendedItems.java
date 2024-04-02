package selenium_Project1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC22_AddToCart_RecommendedItems {
	WebDriver driver;
	@BeforeSuite
	public void setUp() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationexercise.com");
		Thread.sleep(2000);
	}
	@Test(priority=1)
	public void scrollPage(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,7500)");
	    String items=driver.findElement(By.xpath("//h2[contains(text(),'recommended items')]")).getText();
	    System.out.println(items);
	    Assert.assertEquals(items, "RECOMMENDED ITEMS");
    }
	@Test(priority=2)
	public void addItem() {
		driver.findElement(By.xpath("//div[@id='cartModal']/following-sibling::div[1]/child::div/child::div/child::div/child::a/child::i")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//div[@class='col-sm-8']/child::div/child::ul/child::li[3]")).click();
	}
	@Test(priority=3)
	public void verifyCart() {
		WebElement description=driver.findElement(By.xpath("//td[@class='description']"));
		System.out.println(description);
		Assert.assertEquals(description, "Description");
	}
 
	 @AfterSuite   
	 public void closeBrowser() { 
		 driver.close(); 
		}
	
	
}
