package ThisProject.version1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalanderAutomation {
	static WebDriver driver;
	 
	@BeforeTest
	public void PageLoading()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation_Resources\\Selenium\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/bus/#home");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//*[@class='makeFlex hrtlCenter font10 makeRelative lhUser']")).click();
	}
	
	@Test(priority = 1)
	public void CalanderAutomate_Test() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@class='col-md-6 col-sm-6 col-xs-12 marginB10']//*[@class='icon-calendar1 ico22 lh1-2 widgetCalIcon ']")).click();
		Thread.sleep(3000);
	
		String input_date="10-November-2020";
		String input_date_arr [] =input_date.split("-");
		String date=input_date_arr[0];
		String month = input_date_arr[1];
		String year = input_date_arr[2];
		String mon_year= month+" "+year;
		
		
		
		String xpath1 ="//*[@class='jrdp_calendar_box'][1]//tbody//tr[";
		String xpath2="]//*[@class='jrdp_calendar_day1_multi'][";
		String xpath3="]//*[@class='calDate']//span";
		String xpath4 ="//*[@class='jrdp_calendar_box'][2]//tbody//tr[";
		String xpath5="]//*[@class='jrdp_calendar_day1_multi'][";
		String xpath6="]//*[@class='calDate']//span";
		
		calculateCalanderMain(   mon_year,  date,  xpath1,  xpath2,  xpath3,  xpath4,  xpath5,  xpath6);
	  
	}
	
	public static void CalanderMethod(String date,String xpathlocal1,String xpathlocal2, String xpathlocal3)
	{
		
		String date_val = null;
		boolean flag=false;
		for(int i=3;i<=8;i++) //3-->8
		{
			for(int j =1;j<=7;j++) 
			{
				try {
				 date_val =driver.findElement(By.xpath(xpathlocal1+i+xpathlocal2+j+xpathlocal3)).getText();
				 System.out.println(date_val);
				 if(date_val.equals(date))
					{
					 driver.findElement(By.xpath(xpathlocal1+i+xpathlocal2+j+xpathlocal3)).click();
						System.out.println("date clicked");
						flag=true;
						break;
					}
				}
				catch (NoSuchElementException e) {
					System.out.println("enter valid date");
					flag = false;
					break;
				}
				
				
			}
			if(flag)
			{
				break;
			}
		}
			
	}
	
	public static boolean CurrentCalanderDate(String date)
	{
		boolean check = false;
		Date localdate = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	    String strDate = formatter.format(localdate); 
	    String CurrentDate = strDate.substring(0, 2);
	   
	    if(Integer.parseInt(CurrentDate)>=10)
	    {
	    	if(date.equals(CurrentDate))
	    	{
	    		driver.findElement(By.xpath("//*[@class='jrdp_calendar_box'][1]//tbody//tr[4]//*[@class='jrdp_calendar_current_day_multi']//span")).click();
	    		check=true;
	    	}
	    check = false;
	    	
	    }
	    else 
	    {
	    	String currentDateSingledigit =  strDate.substring(1, 2);
	    	System.out.println(currentDateSingledigit);
	    	if(date.equals(currentDateSingledigit))
	    	{
	    		driver.findElement(By.xpath("//*[@class='jrdp_calendar_box'][1]//tbody//tr[4]//*[@class='jrdp_calendar_current_day_multi']//span")).click();
	    		check=true;
	    		
	    	}
	    	 check = false;
	    }
	    
		return check;
	}
	
	public static void calculateCalanderMain(String mon_year, String date, String xpath1, String xpath2, String xpath3, String xpath4, String xpath5, String xpath6)
	{
		String Web_mon_year1=driver.findElement(By.xpath("//*[@class='jrdp_calendar_box'][1]//*[@class='jrdp_calendar_multi']//*[@class='jrdp_calendar_month_multi']")).getText();
		String Web_mon_year2=driver.findElement(By.xpath("//*[@class='jrdp_calendar_box'][2]//*[@class='jrdp_calendar_multi']//*[@class='jrdp_calendar_month_multi']")).getText();
		
		if(Web_mon_year1.equalsIgnoreCase(mon_year))
		{
			
			CurrentCalanderDate(date);
			if(CurrentCalanderDate(date) ==false)
			{
			CalanderMethod(date,xpath1,xpath2,xpath3);
			}
		}
		else if(Web_mon_year2.equalsIgnoreCase(mon_year))
		{
			 
			CalanderMethod(date,xpath4,xpath5,xpath6);
		}
		else
		{
			driver.findElement(By.xpath("//*[@id='jrdp_start-calen_nextmonth_multi_1']")).click();
			driver.findElement(By.xpath("//*[@id='jrdp_start-calen_nextmonth_multi_1']")).click();
			calculateCalanderMain(  mon_year,  date,  xpath1,  xpath2,  xpath3,  xpath4,  xpath5,  xpath6);
			
		}
	}
}
