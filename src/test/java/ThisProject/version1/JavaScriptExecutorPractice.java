package ThisProject.version1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptExecutorPractice {

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
	
	@Test(priority = 2)
	public void JSPromptsHandling() throws InterruptedException  
	{
	//generateAlertBox(driver);							//generate ALert message box
	//createPrompt(driver);								//Generate Prompt box
	//createConfirmBox(driver);							//Generate confirm box
		System.out.println("to be copied");
	//clickElementUsingDOM(driver);	
	//sendKeysinDOM(driver);
	}
	
	//@Test(priority=3)
	public void JSscrollElements()
	{
		//scrollToElement(driver);							// scroll until element is found
		//scrollUp(driver);									//To scroll up the page till mentioned pixels
		//scrollDownTillEnd(driver);						//To Scroll till end of the page
		//scrollUpTillElement(driver);						//Scroll up till the element is found
	}
	
	//@Test(priority=4)
	public void JSWindowsHandling()
	{	
		
		System.out.println(getTitleOfPage(driver));			// Get title of page
		System.out.println(getURLOfPage(driver));			//To Get URL of page
		System.out.println(getInnerText(driver));			//get Inner text of the page
		//pageRefresh(driver)	;							//page Refresh
	}
	
	//@Test(priority=4)
	public void JSelementsHandling()
	{	
		//clickElement(driver);								//element clicking
		
	}
	
	
	public static void clickElement(WebDriver driver)
	{
		WebElement manager = driver.findElement(By.linkText("Manager"));	
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", manager);
	}
	
	public static void clickElementUsingDOM(WebDriver driver)
	{
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementsByName('uid').click()");				// since the page does not have any clickable elements with Name we are using for reference
	}
	public static void sendKeysinDOM(WebDriver driver)
	{
		driver.navigate().back();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement userID= driver.findElement(By.cssSelector("input[name='uid']"));
		js.executeScript("arguments[0].value='mngr276000'", userID);
		
	}
	
	public static void scrollToElement(WebDriver driver)
	{
		WebElement logout = driver.findElement(By.linkText("Log out"));
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", logout);
	}
	public static void scrollUp(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,-500)");
	}
	
	public static void scrollUpTillElement(WebDriver driver)
	{
		WebElement Guru99BankText = driver.findElement(By.xpath("//	*[@class='barone']"));
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",Guru99BankText);
	}
	
	public static void scrollDownTillEnd(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static String getTitleOfPage(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title = js.executeScript("return document.title").toString();
		return title;
	}
	
	public static void generateAlertBox(WebDriver driver) throws InterruptedException
	{
		String alertmsg="Welcome to our website";
		JavascriptExecutor  js = ((JavascriptExecutor)driver);
		js.executeScript("alert('"+alertmsg+"')");
		Thread.sleep(2000);
	}
	
	public static String getURLOfPage(WebDriver driver)
	{
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		String urllocal =js.executeScript("return document.URL").toString();
		return urllocal;
	}
	
	public static void pageRefresh(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title = js.executeScript("history.go(0)").toString();
		
	}
	
	public static String getInnerText(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String docinnertext = js.executeScript("retun document.documentElement.innerText").toString();
		return docinnertext;
	}
	
	public static void createPrompt(WebDriver driver)
	{
		String promptmessage = "creating prompt message";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("prompt('"+promptmessage+"')");
	}
	
	public static void createConfirmBox(WebDriver driver)
	{
		String confirmMsg = "This is to test confirm box";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("confirm('"+confirmMsg+"')");
	}
}
