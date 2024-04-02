package selenium_Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC05_RegisterUser_ExistingEmail {
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
		WebElement newUserSignUp = driver.findElement(By.xpath("//div[@class='signup-form']//h2"));
		if(newUserSignUp.isDisplayed()) {
			System.out.println("New User SignUp is visible");
		}else {
			System.out.println("New User SignUp is not visible");
		}
		driver.findElement(By.name("name")).sendKeys("Minakshi Pawar");
		driver.findElement(By.xpath("//div[@class='signup-form']//form//input[3]")).sendKeys("minakshi11@gmail.com");
		driver.findElement(By.xpath("//div[@class='signup-form']//form//button")).click();
		Thread.sleep(2000);
	}
	@Test(priority=2)
	public void verifyErrorMsg() {
		WebElement errormsg = driver.findElement(By.xpath("//form[@action='/signup']//p[contains(text(),'Email Address already')]"));
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
