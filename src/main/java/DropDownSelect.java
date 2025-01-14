import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSelect {
	
	public static void selectMethod(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
		
		List<WebElement> list = select.getOptions();
		for(WebElement i : list) {
			System.out.println(i.getText());
		}
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement skill = driver.findElement(By.xpath("//select[@id='Skills']"));
		WebElement year = driver.findElement(By.xpath("//select[@id='yearbox']"));
		
		selectMethod(skill, "Adobe Photoshop");
		selectMethod(year, "1929");
		

	}

}
