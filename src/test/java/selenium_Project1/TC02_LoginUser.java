package selenium_Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC02_LoginUser {
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() throws InterruptedException {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://automationexercise.com");
	Thread.sleep(2000);
	
	String expTitle="Automation Exercise";
	String actualTitle=driver.getTitle();
	if(actualTitle.equals(expTitle)) {
		System.out.println("Homepage verified");
	}else {
		System.out.println("Homepage not verified");
	}
}
	@Test(priority=1)
	public void signUp() throws InterruptedException {
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[4]//a")).click();
		Thread.sleep(2000);
		WebElement loginForm = driver.findElement(By.xpath("//div[@class='login-form']//h2"));
		if(loginForm.isDisplayed()) {
			System.out.println("Login to your account is visible");
		}else {
			System.out.println("Login to your account is not visible");
		}
	}
	@Test(priority=2)
	public void loginUser() throws InterruptedException {
		driver.findElement(By.name("email")).sendKeys("minakshi123@gmail.com");
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
	@Test(priority=3)
	public void deleteAccount() {
		driver.findElement(By.linkText("Delete Account")).click();
		WebElement acDelete = driver.findElement(By.xpath("//h2[@class='title text-center']"));
		if(acDelete.isDisplayed()) {
			System.out.println("Account deleted");
		}else
			System.out.println("Account not deleted");
	}
	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
}