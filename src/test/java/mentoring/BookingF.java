package mentoring;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BookingF {
public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\mentoring\\drivers\\chromedriver.exe");
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\eclipse-workspace\\mentoring\\drivers\\msedgedriver.exe");
		driver= new ChromeDriver();
		//driver= new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		
		
		WebElement rounT=driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		rounT.click();
		//handling static dropdown
		WebElement currancy= driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		Select usa= new Select(currancy);
		usa.selectByValue("USD");
		System.out.println(usa.getFirstSelectedOption().getText());
		Thread.sleep(6000);
		//handling dynamic dropdown
		WebElement from= driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		from.click();
		WebElement ahmd=driver.findElement(By.xpath("//*[text()=\" Ahmedabad (AMD)\"]"));
		ahmd.click();
		WebElement dlh=driver.findElement(By.xpath("//*[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"]//*[@text=\"Delhi (DEL)\"]"));
		dlh.click();
		WebElement departDate= driver.findElement(By.xpath("(//*[text()=\"22\"])[1]"));
		departDate.click();
		WebElement retuDate= driver.findElement(By.id("Div1"));
		System.out.println(retuDate.getAttribute("style"));
		if(retuDate.getAttribute("style").contains("1")) {
			System.out.println("it is enable");
		}else {
			System.out.println("it is disable");
		}
		WebElement pass=driver.findElement(By.id("divpaxinfo"));
		pass.click();
		WebElement clickon=driver.findElement(By.id("hrefIncAdt"));
		//clickon.click();//if we want click more than one can just repeat this code
		for (int i = 1; i < 2; i++) {
			clickon.click();
		}
		System.out.println(pass.getText());
		Assert.assertEquals(pass.getText(),"2 Adult");
		WebElement donB=driver.findElement(By.id("btnclosepaxoption"));
		donB.click();
		
		WebElement country= driver.findElement(By.id("autosuggest"));
		country.sendKeys("al");
		//using for loop
		//for (int i = 0; i < 3; i++) {
			//country.sendKeys(Keys.DOWN);
		//}
		//using for each loop
		List<WebElement> allcount=driver.findElements(By.xpath("//*[@class=\"ui-menu-item\"]"));
		for (WebElement element : allcount) {
			if(element.getText().equalsIgnoreCase("Algeria")) {
				element.click();
				break;
			}
		}
		//handling checkbox
		WebElement box=driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
		box.click();
		//System.out.println(box.isSelected());
		//Assert.assertTrue(box.isSelected());
		
		SoftAssert as=new SoftAssert();
		as.assertFalse(box.isSelected(), "this box is not select");
		as.assertAll();
		System.out.println(driver.findElements(By.xpath("//*[@type=\"checkbox\"]")).size());
		
		
		
		
		
		
	}

}
