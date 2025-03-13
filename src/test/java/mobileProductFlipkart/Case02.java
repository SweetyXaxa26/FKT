package mobileProductFlipkart;

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
	
		
		System.out.println("case02 -Search to product detail the click to cart and error msg display ");
		
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       
        driver.get("https://www.flipkart.com/");
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
       
   
        WebElement Searchbar = driver.findElement(By.xpath("//input[@name='q']"));
        Searchbar.click();
        Searchbar.sendKeys("iphone 16e");
       
        WebElement Searchicon = driver.findElement(By.xpath("//button[@class='_2iLD__']"));
        Searchicon.click();
        
        
        String originalWindow = driver.getWindowHandle();
		WebElement product = driver.findElement(By.xpath("//div[@class='tUxRFH']/a/div/child::div[@class='col col-7-12']/child::div[@class='KzDlHZ' and text()='Apple iPhone 16e (Black, 128 GB)']"));
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
     
        js.executeScript("document.body.style.zoom='80%'");
        
	
     
        
        WebElement cart = driver.findElement(By.xpath("//span[text()='Cart']"));
        cart.click();
        
        
     //   WebElement cartErrormsg = driver.findElement(By.xpath("//div[@class='-XmWnM']/div[text()='Missing Cart items?']"));
    
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        List<WebElement> cartErrormsg = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='-XmWnM']/div[text()='Missing Cart items?']")));

        if (cartErrormsg.isEmpty()) 
        {
            System.out.println("No elements found!");
        } 
        else
        {
            
            for (WebElement element : cartErrormsg) 
            {
                System.out.println("Message " + " [" + element.getText() + "]\n");
                
                
           }
        
	    }
        
        
          driver.quit();
	
  }
}
