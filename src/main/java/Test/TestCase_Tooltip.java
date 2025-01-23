package Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_Tooltip {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement tooltip = driver.findElement(By.xpath("//span[contains(text(),'Provide a valid email id for further updates')]"));
		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(email).build().perform();
		
		boolean display = tooltip.isDisplayed();
		Thread.sleep(3000);
		
		System.out.println(display);
		String captureTip = tooltip.getText();
		String expectedTip = "Provide a valid email id for further updates";
		
		if(captureTip.equals(expectedTip)) {
			System.out.println("Matching");
			System.out.println(captureTip + "==" +expectedTip);
		}else {
			System.out.println("Not Matching");
			System.out.println(captureTip + "==" +expectedTip);
		}
		
		//driver.close();

	}

}
