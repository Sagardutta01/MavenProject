package Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDom {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://practice.expandtesting.com/shadowdom");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-host")).getShadowRoot();
		String text = shadow0.findElement(By.cssSelector("#my-btn")).getText();
		
		System.out.println(text);
	}

}
