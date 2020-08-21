package ThisProject.version1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTables {

	WebDriver driver;
	@BeforeTest
	public void PageLoading()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation_Resources\\Selenium\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	//@Test(priority = 1)
	public void WebTableshandlingColumn()
	{
		String xpath1="//*[@class='dataTable']//tbody//tr[";
		String xpath2 = "]//td[3]";
		for (int i = 1; i <=26; i++) {
			String values= driver.findElement(By.xpath(xpath1+i+xpath2)).getText();
			System.out.println(values);
		}
	}
	
	@Test(priority = 1)
	public void WebTableshandlingHeader()
	{
		String xpath1="//*[@class='dataTable']//thead//tr//th[";
		String xpath2 = "]";
		for (int i = 1; i <=5; i++) {
			String values= driver.findElement(By.xpath(xpath1+i+xpath2)).getText();
			System.out.println(values);
		}
	}
}
