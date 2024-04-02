package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common_Library {
	
	 WebDriver driver;

	public Common_Library(WebDriver driver) {
		this.driver=driver;
	}

	public void setUp() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
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
}
