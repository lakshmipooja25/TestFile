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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLinks {

	WebDriver driver;
	@BeforeTest
	public void PageLoading()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation_Resources\\Selenium\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void BrokenLinkTest()
	{
		HttpURLConnection huc = null;
		List <WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement we :links)
		{
			
			String urlnames = we.getAttribute("href");
			System.out.println(urlnames);
			
			try {
				huc = (HttpURLConnection)(new URL(urlnames).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				int  resp_code = huc.getResponseCode();
				if(resp_code >400)
				{
					System.out.println("link is broken");
				}
				else
				{
					System.out.println("links are not broken");
				}
			}
			catch(Exception ex)
			{
				System.err.println(ex.getMessage());
			}
			
			ProfilesIni pi = new ProfilesIni();
			FirefoxProfile fp = pi.getProfile("my profile");
			fp.setAcceptUntrustedCertificates(true);
			fp.setAssumeUntrustedCertificateIssuer(false);
		}
	}
}
