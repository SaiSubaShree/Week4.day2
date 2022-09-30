package week4.Day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		
	// launch the url
		driver.get("https://www.snapdeal.com/");
		
		//. Go to Mens Fashion
driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]")).click();

//Go to Sports Shoes
driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
Thread.sleep(2000);
//Get the count of the sports shoes
String count = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
System.out.println("The count of the shoes is "+count);

//Click Training shoes
driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

//. Sort by Low to High
driver.findElement(By.xpath("//span[text()='Sort by:']/following-sibling::div")).click();
driver.findElement(By.xpath("//li[@class='search-li']")).click();
Thread.sleep(2000);
//8.Select the price range (900-1200)
driver.findElement(By.xpath("//input[@class='input-filter']")).clear();
driver.findElement(By.xpath("//input[@class='input-filter']")).sendKeys("900");
driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).clear();
driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).sendKeys("1200");
Thread.sleep(1000);
//driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();

// filter with color navyv  

//driver.findElement(By.xpath("(//button[contains(@class, 'theme-secondary viewMoreFilter')])[2]")).click();
driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
//driver.executeScript("arguments[0].click", color);

//verify the all applied filters 
Thread.sleep(3000);
String FilterName = driver.findElement(By.xpath("//div[@class='navFiltersPill']/a")).getText();
	System.out.println(FilterName);
	
//Mouse Hover on first resulting Training shoes
	Actions builder =new Actions(driver);
	WebElement ele = driver.findElement(By.xpath("//div[@class='product-desc-rating ']/a"));
	builder.moveToElement(ele).perform();
	
//click QuickView button
	builder.click().perform();
	
//. Print the cost and the discount percentage	
	Thread.sleep(5000);
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> move=new ArrayList<String>(windowHandles);
	driver.switchTo().window(move.get(1));
	Thread.sleep(3000);
	String cost = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
	System.out.println("The cost of the shoe is "+cost);
		
	String discount = driver.findElement(By.xpath("//span[@class='pdpDiscount ']")).getText();
	
	System.out.println("the discount percentage is "+discount);
	
	Thread.sleep(2000);

//Take the snapshot of the shoes.
	
	File Source = driver.getScreenshotAs(OutputType.FILE);
	File Desti= new File("./deal/SC.png");
	FileUtils.copyFile(Source, Desti);
//Close the current window
	
	driver.close();
	//16. Close the main window
	driver.switchTo().window(move.get(0));
	driver.close();
	
	
	
	}

}
