package selenium_Project1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC06_ContactUsForm {
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
	public void contactUsForm() {
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[8]//a")).click();
		WebElement contactUsBtn = driver.findElement(By.xpath("//div[@class='contact-form']//h2[contains(text(),'Get In Touch')]"));
		if(contactUsBtn.isDisplayed()) {
			System.out.println("Get In Touch is visible");
		}else
			System.out.println("Get In Touch is not visible");
		driver.findElement(By.name("name")).sendKeys("Minakshi");
		driver.findElement(By.name("email")).sendKeys("Minakshi@gmail.com");
		driver.findElement(By.name("subject")).sendKeys("Automation");
		driver.findElement(By.id("message")).sendKeys("Software Testing");
		driver.findElement(By.name("upload_file")).sendKeys("F:\\SOFTWARE TESTING\\Book1.xlsx");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,2000)");
		driver.findElement(By.xpath("//div[@class='form-group col-md-12']//input[@value='Submit']")).click();
		
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	@Test(priority=2)
	public void successMsg() {
		WebElement successMsg=driver.findElement(By.xpath("//div[@class='col-sm-8']//div[contains(text(),'Success! Your details have been submitted successfully.')]"));
		if(successMsg.isDisplayed()) {
			System.out.println("Success Message displyed");
		}else
			System.out.println("Success Message not displyed");
		
	}
	
	 @Test(priority=3) 
	 public void verifyHomePage() {
	 driver.findElement(By.xpath("//div[@id='form-section']//a//span")).click(); 
	 String expTitle="Automation Exercise - Contact Us"; 
	 //Automation Exercise - Contact Us
	 String actualTitle=driver.getTitle(); 
	 System.out.println(actualTitle);
	 if(actualTitle.equals(expTitle)) 
	 {
		 System.out.println("Homepage verified");
	 }else 
	 System.out.println("Homepage not verified"); 
	 }
	 @AfterSuite
		public void closeBrowser() {
			driver.close();
		}
	}
	 

