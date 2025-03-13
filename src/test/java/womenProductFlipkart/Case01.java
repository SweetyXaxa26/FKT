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

public class Case01 {

	
	public static void main(String[] args) throws InterruptedException {
	
		
		System.out.println("case01-- Search to Productlist---  ");
		  WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        
	        // Open  website
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
	        System.out.println("Page contain :  ["+text+"]");
	        
	        
	         driver.quit();
	        
        
         
	
  }
}
