import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGelement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://svgomg.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//WebElement uploadIcon = driver.findElement(By.xpath("//*[@class='icon']//*[name()='path']"));
		//uploadIcon.click();
		
		driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M9 16h6v-6')]")).click();
		

	}

}
