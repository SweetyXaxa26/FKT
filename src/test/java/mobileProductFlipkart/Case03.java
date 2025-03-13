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

public class Case03 {

	
	public static void main(String[] args) throws InterruptedException {
	
		
		System.out.println("case03-- Search to place order");
		
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       
        driver.get("https://www.flipkart.com/");
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
       
   
        WebElement Searchbar = driver.findElement(By.xpath("//input[@name='q']"));
        Searchbar.click();
        Searchbar.sendKeys("iphone 16e");
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        List<WebElement> topSerch = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(" //ul[@class='_1sFryS _2x2Mmc _3ofZy1']/li")));

        if (topSerch.isEmpty()) 
        {
            System.out.println("No elements found!");
        } 
        else
        {
            int i = 1;
            for (WebElement element : topSerch) 
            {
                System.out.println(i + " [" + element.getText() + "]\n");
                i++;
           }
        
	    }
     
       
          driver.quit();
	
  }
}
