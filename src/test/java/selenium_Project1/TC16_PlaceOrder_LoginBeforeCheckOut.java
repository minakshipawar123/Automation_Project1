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

public class TC16_PlaceOrder_LoginBeforeCheckOut {
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
	public void loginUser() throws InterruptedException{
		driver.findElement(By.xpath("//div[@class='shop-menu pull-right']/child::ul/child::li[4]/child::a")).click();
		driver.findElement(By.name("email")).sendKeys("minakshi58@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Mina@123");
		driver.findElement(By.xpath("//form[@action='/login']//button")).click();
		Thread.sleep(2000);
		WebElement userName = driver.findElement(By.xpath("//a[contains(text(),' Logged in as ')]"));
		if(userName.isDisplayed()) {
			System.out.println("Logged in as UserName is visible");
		}else {
			System.out.println("Logged in as UserName is not visible");
		}
	}
	@Test(priority =2)
	public void AddProduct()
	{
		driver.findElement(By.xpath("//div[@id='cartModal']/following-sibling::div[1]/child::div/child::div/child::div/child::a/child::i")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//div[@class='col-sm-8']/child::div/child::ul/child::li[3]")).click();
	}
	
	@Test(priority =3)
	public void VerifyCartPage()
	{
		String CartPage=driver.findElement(By.xpath("//div[@class='breadcrumbs']/child::ol/li[2]")).getText();
		Assert.assertEquals(CartPage,"Shopping Cart");
		System.out.println("Shopping Cart");
		driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
	}
	@Test(priority=4)
	public void verifyAddressDetailsandReviewOrder() throws InterruptedException {
		String title1=driver.findElement(By.xpath("//div[@class='step-one']//h2[contains(text(),'Address Details')]")).getText();
		Assert.assertEquals(title1, "Address Details");
		System.out.println(title1);
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.scrollBy(0,600)");
		String title2=driver.findElement(By.xpath("//div[@class='step-one']//h2[contains(text(),'Review Your Order')]")).getText();
		Assert.assertEquals(title2, "Review Your Order");
		System.out.println(title2);
		
		driver.findElement(By.xpath("//div[@id='ordermsg']//textarea")).sendKeys("Good product!");
		driver.findElement(By.xpath("//a[@href='/payment']")).click();
		Thread.sleep(2000);
	}
	@Test(priority=5)
	public void paymentDetails() {
		driver.findElement(By.name("name_on_card")).sendKeys("Minakshi");
		driver.findElement(By.name("card_number")).sendKeys("112233");
		driver.findElement(By.name("cvc")).sendKeys("455");
		driver.findElement(By.name("expiry_month")).sendKeys("06");
		driver.findElement(By.name("expiry_year")).sendKeys("2025");
		driver.findElement(By.xpath("//button[@class='form-control btn btn-primary submit-button']")).click();
	}
	@Test(priority=6)
	public void verifySuccessMsg() {
		String msg=driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-1']//p[contains(text(),'Congratulations! Your order has been confirmed!')]")).getText();
		Assert.assertEquals(msg, "Congratulations! Your order has been confirmed!");
		System.out.println(msg);
	}
	@Test(priority=7)
	public void deleteAccount() {
		driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
		WebElement text5 = driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-1']//h2"));
		boolean status5 = text5.isDisplayed();
		if (status5) {
			System.out.println("Account Deleted is verified");
		} else {
			System.out.println("Account Deleted is not verified");
		}
		driver.findElement(By.linkText("Continue")).click();
	}
		
	 @AfterSuite 
	 public void closeBrowser() { 
		 driver.close(); 
		 }
}
