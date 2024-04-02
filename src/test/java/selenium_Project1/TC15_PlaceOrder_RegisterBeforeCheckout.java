package selenium_Project1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC15_PlaceOrder_RegisterBeforeCheckout {
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
	public void signUporLogin() throws InterruptedException{
		driver.findElement(By.xpath("//div[@class='shop-menu pull-right']/child::ul/child::li[4]/child::a")).click();
		driver.findElement(By.name("name")).sendKeys("Minakshi");
		driver.findElement(By.xpath("//div[@class='signup-form']//form//input[3]")).sendKeys("minakshi5678@gmail.com");
		driver.findElement(By.xpath("//div[@class='signup-form']//form//button")).click();
		Thread.sleep(2000);
	}
	@Test(priority = 2)
	public void createAccount() {
		WebElement text2 = driver
				.findElement(By.xpath("//div[@class='login-form']//h2//b[text()='Enter Account Information']"));
		boolean status2 = text2.isDisplayed();
		if (status2) {
			System.out.println("Enter account information is verified");
		} else {
			System.out.println("Not verified");
		}
		System.out.println(status2);

		driver.findElement(By.id("id_gender2")).click();
		driver.findElement(By.id("password")).sendKeys("Mina@123");

		WebElement day = driver.findElement(By.id("days"));
		Select selectDay = new Select(day);
		selectDay.selectByValue("12");

		WebElement month = driver.findElement(By.name("months"));
		Select selectMonth = new Select(month);
		selectMonth.selectByIndex(5);

		WebElement year = driver.findElement(By.id("years"));
		Select selectYear = new Select(year);
		selectYear.selectByVisibleText("1998");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,2000)");

		WebElement checkbox = driver.findElement(By.name("newsletter"));
		// checkbox.sendKeys("");
		checkbox.click();
		driver.findElement(By.id("optin")).click();

		driver.findElement(By.id("first_name")).sendKeys("Minakshi");
		driver.findElement(By.id("last_name")).sendKeys("Pawar");
		driver.findElement(By.name("company")).sendKeys("ABC");
		driver.findElement(By.name("address1")).sendKeys("Flat no.16");
		driver.findElement(By.id("address2")).sendKeys("Street 123, Pune");

		WebElement country = driver.findElement(By.id("country"));
		Select selectCountry = new Select(country);
		selectCountry.selectByVisibleText("India");

		driver.findElement(By.name("state")).sendKeys("Maharashtra");
		driver.findElement(By.id("city")).sendKeys("Jalgaon");
		driver.findElement(By.id("zipcode")).sendKeys("123456");
		WebElement contact = driver.findElement(By.id("mobile_number"));
		contact.sendKeys("9876543210");
		contact.sendKeys(Keys.TAB);
		// contact.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//button[@data-qa='create-account']")).sendKeys(Keys.ENTER);
	}
	@Test(priority =3)
	public void clickOnContinue() {
		String text3 = driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-1']//h2")).getText();
		Assert.assertEquals(text3, "ACCOUNT CREATED!");
		System.out.println(text3);
		driver.findElement(By.xpath("//div[@class='pull-right']/a")).click();
		WebElement text4 = driver.findElement(By.xpath("//a[contains(text(),' Logged in as ')]"));
		boolean status4 = text4.isDisplayed();
		if (status4) {
			System.out.println("Login verified");
		} else {
			System.out.println("Login not verified");
		}
    }
	@Test(priority =4)
	public void AddProduct()
	{
		driver.findElement(By.xpath("//div[@id='cartModal']/following-sibling::div[1]/child::div/child::div/child::div/child::a/child::i")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//div[@class='col-sm-8']/child::div/child::ul/child::li[3]")).click();
	}
	
	@Test(priority =5)
	public void VerifyCartPage()
	{
		String CartPage=driver.findElement(By.xpath("//div[@class='breadcrumbs']/child::ol/li[2]")).getText();
		Assert.assertEquals(CartPage,"Shopping Cart");
		System.out.println("Shopping Cart");
		driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
	}
	@Test(priority=6)
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
	@Test(priority=7)
	public void paymentDetails() {
		driver.findElement(By.name("name_on_card")).sendKeys("Minakshi");
		driver.findElement(By.name("card_number")).sendKeys("112233");
		driver.findElement(By.name("cvc")).sendKeys("455");
		driver.findElement(By.name("expiry_month")).sendKeys("06");
		driver.findElement(By.name("expiry_year")).sendKeys("2025");
		driver.findElement(By.xpath("//button[@class='form-control btn btn-primary submit-button']")).click();
	}
	@Test(priority=8)
	public void verifySuccessMsg() {
		String msg=driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-1']//p[contains(text(),'Congratulations! Your order has been confirmed!')]")).getText();
		Assert.assertEquals(msg, "Congratulations! Your order has been confirmed!");
		System.out.println(msg);
	}
	@Test(priority=9)
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
