package Test;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		String rowX = "//table[@id='countries']/tbody/tr[";
		String rowY = "]";
		
		String cellX = "/td[";
		String cellY = "]";
		
		List<WebElement> rowSize = driver.findElements(By.xpath("//table[@id='countries']/tbody/tr"));
		List<WebElement> columnSize = driver.findElements(By.xpath("//table[@id='countries']/tbody/tr[1]/td"));
		
		boolean flag = false;
		String country = "Angola";
		
		for(int i=1;i<=rowSize.size();i++) {
			
			if(flag) {
				break;
			}

			for(int j=1; j<=columnSize.size(); j++) {
				
				WebElement	currentRow = driver.findElement(By.xpath(rowX+i+rowY+cellX+j+cellY));
					
					if(currentRow.getText().equals(country)) {
						WebElement capital = driver.findElement(By.xpath("//table[@id='countries']/tbody/tr["+i+"]/td[3]"));
						System.out.println(country+" capital is "+capital.getText());
						flag = true;
						break;
					}
					}
				}

		driver.quit();
	
	}
		
}


	

