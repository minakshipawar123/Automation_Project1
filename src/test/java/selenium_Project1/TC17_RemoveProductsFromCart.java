package selenium_Project1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC17_RemoveProductsFromCart {
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
	@Test(priority =1)
	public void addProduct()
	{
		driver.findElement(By.xpath("//div[@id='cartModal']/following-sibling::div[1]/child::div/child::div/child::div/child::a/child::i")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//div[@class='col-sm-8']/child::div/child::ul/child::li[3]")).click();
	}
	
	@Test(priority =2)
	public void verifyCartPage()
	{
		String CartPage=driver.findElement(By.xpath("//div[@class='breadcrumbs']/child::ol/li[2]")).getText();
		Assert.assertEquals(CartPage,"Shopping Cart");
		System.out.println("Shopping Cart");
	}
	@Test(priority =3)
	public void removeProduct() {
		driver.findElement(By.xpath("//a[@class='cart_quantity_delete']")).click();
		String emptyCart=driver.findElement(By.xpath("//span[@id='empty_cart']//p//b[contains(text(),'Cart is empty!')]")).getText();
		System.out.println(emptyCart);
		Assert.assertEquals(emptyCart, "Cart is empty!");
	}
	@AfterSuite 
	 public void closeBrowser() { 
		 driver.close(); 
		 }
}
