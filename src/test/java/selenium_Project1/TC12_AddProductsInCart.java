package selenium_Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC12_AddProductsInCart {
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
	@Test(priority = 1 )
	public void clickOnProducts() {
		driver.findElement(By.xpath("//a[@href='/products']")).click();
	}
	@Test(priority = 2 )
	 public void addProductInCart() { 
		WebElement mouseHover=driver.findElement(By.xpath("//div[@class='overlay-content']//a[@data-product-id='1']")); 
		Actions act =new Actions(driver); act.moveToElement(mouseHover); 
		WebElement clickAddtoCart=driver.findElement(By.xpath("//div[@class='overlay-content']//a[@data-product-id='1']"));
		act.moveToElement(clickAddtoCart); 
		act.click().build().perform();
		driver.findElement(By.xpath("//div[@class='overlay-content']//a[@data-product-id='1']")).click(); 
		driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
	 //hover over second product and click on add to cart
	  driver.findElement(By.xpath("//a[@href='/view_cart']//u")).click(); 
	  }
	 
	@Test(priority=2)
	public void verifyProductsInCart() {
		driver.findElement(By.xpath("//tr[@class='cart_menu']//td[3]")).getText();
		driver.findElement(By.xpath("//tr[@class='cart_menu']//td[4]")).getText();
		driver.findElement(By.xpath("//tr[@class='cart_menu']//td[5]")).getText();
	}
	
	  @AfterSuite 
	  public void closeBrowser() { 
		  driver.close(); 
		  }
	
	 
}


