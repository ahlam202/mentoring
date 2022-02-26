package mentoring;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alarts {
public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\mentoring\\drivers\\chromedriver.exe");
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\eclipse-workspace\\mentoring\\drivers\\msedgedriver.exe");
		driver= new ChromeDriver();
		//driver= new EdgeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		//driver.findElement(By.id("alertButton")).click();
		//driver.switchTo().alert().accept();
		
		driver.findElement(By.id("promtButton")).click();
		driver.switchTo().alert().sendKeys("ahlam");
		driver.switchTo().alert().accept();
		
		
		
	}

}
