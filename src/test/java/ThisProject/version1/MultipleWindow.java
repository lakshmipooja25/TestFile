package ThisProject.version1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleWindow {
	WebDriver driver;
	@BeforeTest
	public void PageLoading()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation_Resources\\Selenium\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void Window_handling_test()
	{
		String par_win=driver.getWindowHandle();
		Set <String> total_win = driver.getWindowHandles();
		/*Iterator <String> i1= total_win.iterator();
		String naukri = i1.next();
		String HSBC = i1.next();
		String LandT = i1.next();
		driver.switchTo().window(naukri);
		driver.switchTo().window(HSBC);
		driver.switchTo().window(LandT);
		System.out.println(driver.getTitle());
		driver.switchTo().window(naukri);*/
		
		Iterator <String> i1= total_win.iterator();
		while(i1.hasNext()){
			  i1.next();
		String win1=i1.next();
		driver.switchTo().window(win1);
		System.out.println(driver.getTitle());
			  
			}
		
		
	}
}
