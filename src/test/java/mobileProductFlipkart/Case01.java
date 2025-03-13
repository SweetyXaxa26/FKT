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

public class Case01 {

	
	public static void main(String[] args) throws InterruptedException {
	
		
		System.out.println("case01-- Search to place order");
		
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
        
	
        js.executeScript("document.body.style.zoom='80%'");
        
        WebElement Addtocart = driver.findElement(By.xpath("//button[text()='Add to cart']"));
        Addtocart.click();
        
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        List<WebElement> Detail = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='_8X-K8p']/div")));

        if (Detail.isEmpty()) 
        {
            System.out.println("No elements found!");
        } 
        else
        {
            int i = 1;
            for (WebElement element : Detail) 
            {
                System.out.println(i + " [" + element.getText() + "]\n");
                i++;
           }
        
	    }
        
     System.out.println("--------------------------------------------------------------------");
        
        List<WebElement> PriceDetail = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='_3j-e05']/div")));

        if (PriceDetail.isEmpty()) 
        {
            System.out.println("No elements found!");
        } 
        else
        {
            int i = 1;
            for (WebElement element : PriceDetail) 
            {
                System.out.println(i + " [" + element.getText() + "]\n");
                
                i++;
           }
        
	    }
        
           
        WebElement placeOrder = driver.findElement(By.xpath("//span[text()='Place Order']"));
        placeOrder.click();
        
          driver.quit();
	
  }
}
