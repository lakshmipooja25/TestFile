package ThisProject.version1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testing {

	WebDriver driver;
	@BeforeTest
	
	public void PageLoading()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation_Resources\\Selenium\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/V4/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		  
	}
	
	@Test(priority = 1)
	public void login()
	{
		driver.findElement(By.name("uid")).sendKeys("mngr276000");
		driver.findElement(By.name("password")).sendKeys("YjupubU");		
		driver.findElement(By.name("btnLogin")).click();
		
		
			
	}
	
	//@Test(priority = 2)
		public void New_Customer() throws InterruptedException, IOException 
		{
			driver.findElement(By.linkText("New Customer")).click();
			driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Lakshpriya");
			driver.findElement(By.cssSelector("input[type='radio'][value='f']")).click();
			driver.findElement(By.cssSelector("input[type='date'][name='dob']")).sendKeys("02/03/1994");
			driver.findElement(By.cssSelector("textarea[name='addr']")).sendKeys("kodambakkam");
			driver.findElement(By.cssSelector("input[name^='ci']")).sendKeys("chennai");
			driver.findElement(By.cssSelector("input[name$='ate']")).sendKeys("tamilnadu");
			driver.findElement(By.cssSelector("input[name*='inn']")).sendKeys("600024");
			driver.findElement(By.cssSelector("input[name*='phoneno']")).sendKeys("8939393977");
			driver.findElement(By.cssSelector("input[name^='emai']")).sendKeys("lakshmi1@gmail.com");
			driver.findElement(By.cssSelector("input[type$='word']")).sendKeys("laksh@123");
	
			driver.findElement(By.cssSelector("input[type='submit'][value='Submit'][name='sub']")).click();
			
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("D:\\Automation_Resources\\My Files\\Snapshots\\Version 1\\image.png"));
			
			Thread.sleep(3000);
			
			
					
			
		}
	
		//@Test(priority=3)
		public void delete_Customer()
		{
			String Customer_id= driver.findElement(By.xpath("//*[@id='customer']//tr[4]//td[2]")).getText();
			System.out.println(Customer_id);
		
			
			driver.findElement(By.linkText("Delete Customer")).click();
			driver.findElement(By.name("cusid")).sendKeys(Customer_id);
			driver.findElement(By.name("AccSubmit")).click();
			driver.switchTo().alert().accept();
			driver.switchTo().alert().accept();
			
		}
		
		//@Test(priority = 2)
		public void testRadio()
		{
			driver.findElement(By.linkText("New Customer")).click();
			WebElement radio = driver.findElement(By.cssSelector("input[name='rad1'][value='f']"));
			if(radio.isEnabled()) 	// to test isEnabled() isSelected(), isDispayed() 
			{
				System.out.println("the value is selected");
			}
			else
			{
				System.out.println("the value is not selected");
			}	
		}
		
		
}


