import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;

/*
 selenium WebDriver example -- google to calculator.net
 */

public class WebDriverExample 
{
    public static void main( String[] args )
    {
    	//System.setProperty ("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
    	WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");                 	   	    	
    	driver.findElement(By.xpath("//div[@id='gs_lc0']/input[@aria-haspopup='false']")).sendKeys("Sem");     	      
    	driver.findElement(By.xpath("//form[@id='tsf']/div[2]/div[3]/center/input[1]")).submit();
    	
    	WebElement secondPageElement = driver.findElement(By.xpath("//div[@id='gs_lc0']/input"));
    	secondPageElement.clear();    	
    	secondPageElement.sendKeys("calculator website");
    	driver.findElement(By.xpath("//div[@id='sblsbb']/button")).submit();
    	//String url_search = driver.getCurrentUrl();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.findElement(By.partialLinkText("Calculator.net")).click();
    	
        driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@id='menu']/div[2]/a")).click();
		if(driver.getCurrentUrl().contains("weight-loss-calculator.html"))
		{
		System.out.println("Navigation is right (Going to Weight Loss Calculators)");
		}
		else
		{
		System.out.println("Navigation is not right(Not going to Weight Loss Calculators)");
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElement(By.partialLinkText("Math")).click();
		driver.findElement(By.xpath("//div[@id='menu']/div[4]/a")).click();
		if(driver.getCurrentUrl().contains("math-calculator.html"))
		{
		System.out.println("Navigation is right(Going to Math Calculators)");
		}
		else
		{
		System.out.println("Navigation is not right(Not going to Math Calculators)");
		}
		driver.findElement(By.linkText("Percentage")).click();
		driver.findElement(By.id("cpar1")).sendKeys("5");
		driver.findElement(By.id("cpar2")).sendKeys("100");
		driver.findElement(By.xpath("//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]")).click();
		String result = driver.findElement(By.xpath("//div[@id='content']/p/font/b")).getText();
		System.out.println("The result =" + result);
		Assert.assertEquals(result, "5");
		System.out.println("The result is verified");	
		driver.close();
  
    }
}
