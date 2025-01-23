package Test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement date = driver.findElement(By.xpath("//input[@id='datepicker2']"));
		date.click();
		
		WebElement calender = driver.findElement(By.xpath("//div[@class='datepick']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(calender));
		
		WebElement month = driver.findElement(By.xpath("//select[@title='Change the month']/*[@selected='selected']"));
		WebElement year = driver.findElement(By.xpath("//select[@title='Change the year']/*[@selected='selected']"));
		
		
		while(!((year.getText().equals("2027"))&&(month.getText().equals("June")))){
			driver.findElement(By.xpath("//a[@title='Show the next month']")).click();
			year = driver.findElement(By.xpath("//select[@title='Change the year']/*[@selected='selected']"));
			month = driver.findElement(By.xpath("//select[@title='Change the month']/*[@selected='selected']"));
			
			
		}
		
		
		
		
		List<WebElement> day = driver.findElements(By.xpath("//table/child::tbody/descendant::td"));
		for(WebElement j : day) {
			System.out.println(j.getText());
			if(j.getText().contains(" ")) {
				continue;
			}else if(j.getText().equals("20")) {
				j.click();
				break;
			}
		}
		
	}

}
