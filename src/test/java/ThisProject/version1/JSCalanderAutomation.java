package ThisProject.version1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JSCalanderAutomation {

	WebDriver driver;
	@BeforeTest
	public void PageLoading()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation_Resources\\Selenium\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/bus/#home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		  
	}
	
	@Test(priority = 1)
	public void JSCalanderAutomateTest()
	{
		WebElement date_picker1=driver.findElement(By.xpath("//*[@class='col-md-6 col-sm-6 col-xs-12 marginB10']//*[@class='form-control inputTxtLarge widgetCalenderTxt']"));
		WebElement date_picker2=driver.findElement(By.xpath("//*[@id='gi_onward_date']"));
		String date1="08/09/2020";
		String date2 ="Sun Aug 09 2020 00:00:00 GMT+0530 (India Standard Time)"; 
		JsScriptcall(driver, date_picker1,date_picker2, date1, date2);
			
	}
	
	public static void JsScriptcall(WebDriver driver, WebElement date_picker1,WebElement datapicker2, String date1,String date2)
	{
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('data-date','"+date1+"')", date_picker1);
		js.executeScript("arguments[0].setAttribute('value','"+date2+"')", datapicker2);
		
	}
	
}
