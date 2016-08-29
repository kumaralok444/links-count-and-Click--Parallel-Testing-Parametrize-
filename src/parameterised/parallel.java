package parameterised;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parallel {
	WebDriver driver;
	String url="https://www.google.co.in/";
	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void SetUp(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"));
			{
				System.setProperty("webdriver.gecko.driver", "D:\\Alok\\jar\\geckodriver-v0.10.0-win64\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
		if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","D:\\Alok\\chromedriver_win32(1)\\chromedriver.exe");
				driver=new ChromeDriver();
			}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		}	
		@Test
		public void test1() throws InterruptedException
		{
		 driver.get(url);	
		  String pid= driver.getWindowHandle();
		  List<WebElement>we=driver.findElements(By.tagName("a"));
		  int i=we.size();
		  System.out.println("Number of link available on page:"+i);
		 String st[]=new String[i];
		 int l=0;
		 for(int j=0;j<i;j++)
		 {
			 st[l]=we.get(j).getAttribute("href");
			 System.out.println(st[l]);
			 l++;
		 }
		 for(int j=0;j<st.length;j++)
		 {
			 driver.get(url);
		try
		{
			driver.navigate().to(st[j]);
		}
		catch(NullPointerException e)
		{
			System.out.println(e);
		}
		 }
		
	}

}
