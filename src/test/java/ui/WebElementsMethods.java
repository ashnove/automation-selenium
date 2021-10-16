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

public class WebElementsMethods {

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

		driver.get("https://www.sugarcrm.com/au/request-demo/");
//		driver.manage().window().maximize();
		
		driver.findElement(By.name("firstname")).sendKeys("ashnove");
		driver.findElement(By.name("firstname")).clear();
		
		System.out.println("Attribute = " + driver.findElement(By.name("firstname")).getAttribute("class"));
		
		System.out.println("Css Value = " + driver.findElement(By.xpath("//*[@id=\"field1\"]/div/input")).getCssValue("background-color"));

		System.out.println("getSize() = " + driver.findElement(By.xpath("//*[@id=\"field1\"]/div/input")).getSize());
		System.out.println("getLocation() = " + driver.findElement(By.xpath("//*[@id=\"field1\"]/div/input")).getLocation());
		System.out.println("getTagname() = " + driver.findElement(By.xpath("//*[@id=\"field1\"]/div/input")).getTagName() );
		System.out.println("getText() = " + driver.findElement(By.xpath("//*[@id=\"field1\"]/div/input")).getText() );
		
		System.out.println("isDisplayed() = " + driver.findElement(By.xpath("//*[@id=\"field1\"]/div/input")).isDisplayed());
		System.out.println("isEnabled() = " + driver.findElement(By.xpath("//*[@id=\"field1\"]/div/input")).isEnabled());
		System.out.println("isSelected() = " + driver.findElement(By.xpath("//*[@id=\"field1\"]/div/input")).isSelected());
		
		Thread.sleep(5000);
		driver.quit();

	}

}
