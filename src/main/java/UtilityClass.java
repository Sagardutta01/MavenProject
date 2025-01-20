import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class UtilityClass extends TestTest {
	

	
	public static void getMeScreenshot(WebDriver driver) throws IOException {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		String timeStamp = formatter.format(currentDateTime);
		System.out.println(timeStamp);
		File obj = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(obj, new File("C:\\Users\\sagar\\eclipse-workspace\\MavenProject\\target\\Failed\\"
				+ "Failed_"+timeStamp+".png"));
	}
	

}
