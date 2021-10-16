package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;
import java.util.Set;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicWebDrivers {

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
		driver.manage().window().maximize();

		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current Url = " + currentUrl);

		String title = driver.getTitle();
		System.out.println("Title = " + title);

		String pageSource = driver.getPageSource();
		System.out.println("PageSource = " + pageSource);

//		driver.navigate().to("https://google.com");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

		List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_list']/div"));
		System.out.println("Items = " + items);

		driver.navigate().to("https://www.sugarcrm.com/");
		String windowHandle = driver.getWindowHandle(); 
		System.out.println("windowHande = " + windowHandle);

		driver.findElement(By.xpath("//*[@id=\"mega-menu-item-44\"]/a/span")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("windowHandles = " + windowHandles);

		Thread.sleep(5000);
		driver.quit();

	}

}
