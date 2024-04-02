package selenium_Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC01_RegisterUser{
	WebDriver driver;
	@BeforeSuite
	public void setUp() throws InterruptedException {
		driver.get("http://automationexercise.com");
		Thread.sleep(2000);
		String expTitle = "Automation Exercise";
		String actualTitle = driver.getTitle();
		System.out.println("Actual Title is : " + actualTitle);
		System.out.println("Expected Title is : " + expTitle);

		if (actualTitle.equals(expTitle)) {
			System.out.println("Homepage visible successfully");
		} else {
			System.out.println("Homepage not visible successfully");
		}
	}

	@Test(priority = 1)
	public void signUp() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='shop-menu pull-right']/child::ul/child::li[4]/child::a")).click();
		WebElement text = driver.findElement(By.xpath("//div[@class='signup-form']//h2[text()='New User Signup!']"));
		boolean status = text.isDisplayed();
		if (status) {
			System.out.println("New User Signup is verified");
		} else {
			System.out.println("Not verified");
		}
		System.out.println(status);

		driver.findElement(By.name("name")).sendKeys("Minakshi");
		driver.findElement(By.xpath("//div[@class='signup-form']//form//input[3]")).sendKeys("minakshi51@gmail.com");
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

	@Test(priority = 3)
	public void clickOnContinue() {
		WebElement text3 = driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-1']//h2"));
		boolean status3 = text3.isDisplayed();
		if (status3) {
			System.out.println("Account created is verified");
		} else {
			System.out.println("Account created not verified");
		}

		driver.findElement(By.xpath("//div[@class='pull-right']/a")).click();

		WebElement text4 = driver.findElement(By.xpath("//a[contains(text(),' Logged in as ')]"));
		boolean status4 = text4.isDisplayed();
		if (status4) {
			System.out.println("Login verified");
		} else {
			System.out.println("Login not verified");
		}
	}

	@Test(priority = 4)
	public void deleteAccount() {
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Delete Account')]")).click();
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
