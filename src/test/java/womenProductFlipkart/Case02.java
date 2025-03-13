package womenProductFlipkart;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Case02 {

	
	public static void main(String[] args) throws InterruptedException {
	
		
		System.out.println("case02-- Search to product detail page ");
		  WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        
	        
	        driver.get("https://www.flipkart.com/");

	        JavascriptExecutor js = (JavascriptExecutor) driver;
           
	        WebElement Searchbar = driver.findElement(By.xpath("//input[@name='q']"));
	        Searchbar.click();
	        Searchbar.sendKeys("boyfriend blue denim jeans for woman");
	       
	        WebElement Searchicon = driver.findElement(By.xpath("//button[@class='_2iLD__']"));
	        Searchicon.click();
	        
	        
	        //product listing  Page 
	        
	        WebElement SearchItenDisplay = driver.findElement(By.xpath("  //span[@class='BUOuZu']"));
	        String text = SearchItenDisplay.getText();
	       // System.out.println("Page contain :  ["+text+"]");
	        
	        
	     
	        String originalWindow = driver.getWindowHandle();
	        
	        //---------Actual product---------
			WebElement product = driver.findElement(By.xpath("//a[@class='WKTcLC' and text()='Women Boyfriend High Rise Blue Jeans']/preceding-sibling::div[text()='Z&G TRENDS']/following-sibling::a[@title='Women Boyfriend High Rise Blue Jeans']"));
			product.click();
			
			Set<String> allWindows = driver.getWindowHandles();

			for (String window : allWindows)
			{
			    if (!window.equals(originalWindow)) 
			    {
			        driver.switchTo().window(window); // Switch to the new tab
			        break;
			    }
			}
			
	     
       driver.quit();
	        
        
         
	
  }
}
