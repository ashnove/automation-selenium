package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	public static String browser = "Chrome"; // Extrernal Configuration xls, csv etc...
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver();
		}

		driver.get("https://saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("testing");
//		driver.findElement(By.className("form_input")).sendKeys("testing");
//		driver.findElement(By.cssSelector("#user-name")).sendKeys("ashnove");
//		driver.findElement(By.tagName("input")).sendKeys("ashnove");
		
//		WebElement passwordField = driver.findElement(By.id("password"));
//		WebElement emailField = driver.findElement(with(By.tagName("input")).above(passwordField));
//		emailField.sendKeys("ashnove");
		

		
		Thread.sleep(5000);
		driver.close();

	}

}
