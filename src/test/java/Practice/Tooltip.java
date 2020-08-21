package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tooltip {

	WebDriver driver;
	@BeforeTest
	public void PageLoading()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation_Resources\\Selenium\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/tooltip.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void testToolTip()
	{
		WebElement download = driver.findElement(By.linkText("Download now"));
		Actions action = new Actions(driver);
		action.moveToElement(download).build().perform();
		String OS = driver.findElement(By.xpath("//*[@class='tooltip']//table//tr[4]//td[1]")).getText();
		System.out.println(OS);
		String os_version=driver.findElement(By.xpath("//*[@class='tooltip']//a")).getText();
		System.out.println(os_version);
		
		String releasenotes_name = driver.findElement(By.xpath("//*[@class='tooltip']//a")).getAttribute("href");
		System.out.println(releasenotes_name);
	}
}
