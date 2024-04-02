package selenium_Project1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC20_VerifyCartAfterLogin {
	WebDriver driver;
	@BeforeSuite
	public void setUp() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationexercise.com");
		Thread.sleep(2000);
	}
	@Test(priority=1)
	public void verifyProductPage() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='/products']")).click();
		String title=driver.getTitle();
		Assert.assertEquals(title, "Automation Exercise - All Products");
		System.out.println(title);
		Thread.sleep(2000);
    }
	@Test(priority=2)
	public void searchProduct() throws InterruptedException {
		driver.findElement(By.id("search_product")).sendKeys("Tops");
		driver.findElement(By.xpath("//button[@id='submit_search']")).click();
		Thread.sleep(2000);
		String searchedProd=driver.findElement(By.xpath("//h2[contains(text(),'Searched Products')]")).getText();
		System.out.println(searchedProd);
		Assert.assertEquals(searchedProd, "SEARCHED PRODUCTS");
	}
	@Test(priority=3)
	public void addToCart() {
		driver.findElement(By.xpath("//div[@id='cartModal']/following-sibling::div[1]/child::div/child::div/child::div/child::a/child::i")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//div[@class='col-sm-8']/child::div/child::ul/child::li[3]")).click(); 
	}
	@Test(priority=4)
	public void signUpBtn() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		driver.findElement(By.name("email")).sendKeys("minakshi1@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Mina@123");
		driver.findElement(By.xpath("//form[@action='/login']//button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[3]//a")).click();
	}

	@AfterSuite 
	public void closeBrowser() {
		driver.close(); 
		}
}
