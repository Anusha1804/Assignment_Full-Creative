import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	public static WebDriver driver;

	public void waitfor(long seconds)
	{
		try 
		{
			Thread.sleep(seconds *1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
//	public void waituntilelementvisible(String string,long TimeOutInSeconds) 
//	{
//		WebDriverWait w= new WebDriverWait(driver,TimeOutInSeconds);
//		w.until(ExpectedConditions.visibilityOf(string));
//	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
