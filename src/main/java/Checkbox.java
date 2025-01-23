import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(MyListenerClass.class)
public class Checkbox {

	public static WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
	}
	
	@Test
	public void checkBoxClick() {
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		List<WebElement> list = driver.findElements(By.xpath("//label[@class='checks']"));
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		
		for(WebElement i : list) {
			System.out.println(i.getText());
		}
		for(WebElement j : checkbox) {
			j.click();
		}
		
		
	}
	
	@AfterMethod
	public void closeBrower() {
		driver.close();
	}
	


}
