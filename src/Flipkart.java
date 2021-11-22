import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//invoking chrome browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lokesh Kumar Singh J\\Desktop\\All documents_ANUSHA\\chromedriver_win32\\chromedriver.exe");	
		WebDriver driver= new ChromeDriver();
		Utility utils= new Utility();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//launching flipkart application
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("7075797909");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Flipkart@1");
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		utils.waitfor(5);
		
		//searching for HP laptop
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("HP Laptop");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		utils.waitfor(5);
		driver.findElement(By.xpath("//div[contains(text(),'HP Ryzen 3')]")).click();
		
		//windowhandles
		Set<String> ids= driver.getWindowHandles();
		Iterator <String> it=ids.iterator();
		String parentid=it.next();
		String childsid=it.next();
		driver.switchTo().window(childsid);
		js.executeScript("window.scrollBy(0,1000)");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		//adding into cart
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).isDisplayed();
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		driver.close();
		//navigating back to parent window
		driver.switchTo().window(parentid);

		driver.findElement(By.xpath("//input[@name='q']")).click();
		WebElement toClear = driver.findElement(By.xpath("//input[@name='q']"));
		toClear.sendKeys(Keys.CONTROL + "a");
		toClear.sendKeys(Keys.DELETE);

		//searching for mobile
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone");  
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		utils.waitfor(5);
		js.executeScript("window.scrollBy(0,500)");
		utils.waitfor(5);
		driver.findElement(By.xpath("//div[contains(text(),'iPhone 12 (Blue, 128 GB)')]")).click();
		driver.switchTo().window(childsid);
		utils.waitfor(5);
		js.executeScript("window.scrollBy(0,1000)");
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).isDisplayed();
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		
	}
}


