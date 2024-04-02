package selenium_Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC03_LoginUser_InvalidCredentials {
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() throws InterruptedException {
		driver=new ChromeDriver();
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
		driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.xpath("//form[@action='/login']//button")).click();
		Thread.sleep(2000);
	}
	@Test(priority=3)
	public void verifyError() {
		WebElement errormsg = driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]"));
		if(errormsg.isDisplayed()) {
			System.out.println("Error message displyed");
		}else
			System.out.println("Error message not displyed");
	}
	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
	
}
