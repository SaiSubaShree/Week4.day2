package week4.Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAssingment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver= new ChromeDriver();
driver.manage().window().maximize();

//Launch the URL
Thread.sleep(1000);
driver.get("https://www.nykaa.com/");

//2) Mouseover on Brands and Search L'Oreal Paris
WebElement Brand = driver.findElement(By.xpath("//a[text()='brands']"));
Actions builder=new Actions(driver);
builder.moveToElement(Brand).perform();
Thread.sleep(2000);
driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
Thread.sleep(2000);
//click on loreal paris
driver.findElement(By.xpath("//a[text()=\"L'Oreal Paris\"]")).click();

//Check the title contains L'Oreal Paris(Hint-GetTitle)
String title = driver.getTitle();
System.out.println(title);
if(title.contains("L'Oreal Paris"))
{
	System.out.println("The title contains Loreal paris");
}
else
{
	System.out.println("The titke doesnot contain loreal paris");
}
Thread.sleep(8000);
//Click sort By and select customer top rated
driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
driver.findElement(By.xpath("//span[text()='customer top rated']")).click();

//6) Click Category and click Hair->Click haircare->Shampoo

driver.findElement(By.xpath("//span[text()='Category']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//span[text()='Hair']")).click();
System.out.println("Hair is selected");
Thread.sleep(3000);
driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
System.out.println("hair care is slected");
Thread.sleep(3000);
driver.findElement(By.xpath("//span[@class='title' and text()='Shampoo']")).click();
//driver.executeScript("arguments[0].click", ele);
System.out.println("shampoo is selected");

Thread.sleep(2000);

//7) Click->Concern->Color Protection
driver.findElement(By.xpath("//span[text()='Concern']")).click();
Thread.sleep(500);
driver.findElement(By.xpath("//span[text()='Color Protection']")).click();

//check whether the Filter is applied with Shampoo

Thread.sleep(4000);
String shampoo = driver.findElement(By.xpath("(//span[@class='filter-value'])[2]")).getText();
if(shampoo.equalsIgnoreCase("Color Protection"))
{
	System.out.println("filter is verified");
}
else
{
	System.out.println("Filter not applied");
}

Thread.sleep(2000);
//9) Click on L'Oreal Paris Colour Protect Shampoo

driver.findElement(By.xpath("//div[text()=\"L'Oreal Paris Colour Protect Shampoo\"]")).click();

//10) GO to the new window and select size as 175ml
Set<String> windowHandles = driver.getWindowHandles();
List<String> window=new ArrayList<String>(windowHandles);
driver.switchTo().window(window.get(1));

Thread.sleep(2000);

//Print the MRP of the product

String MRP = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
System.out.println("the MRP of the product "+MRP);

//Click on ADD to BAG
Thread.sleep(2000);
driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();

//Go to Shopping Bag 
Thread.sleep(2000);
driver.findElement(By.xpath("//button[@type='button']")).click();

//Print the grand total amt
driver.switchTo().frame(0);
Thread.sleep(6000);
String total = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
System.out.println("The grand total is "+total);

//click to proceed
Thread.sleep(3000);
driver.findElement(By.xpath("//span[@class='vernacular-string' and text()='Proceed']")).click();


//Click on Continue as Guest

Thread.sleep(3000);
driver.findElement(By.xpath("//button[@type='button' and @class='btn full big']")).click();


//Check if this grand total is the same in step 14
Thread.sleep(3000);
String Finaltotal = driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div/span")).getText();
System.out.println("The final value is "+Finaltotal);

if(Finaltotal.equals(total))
{
	System.out.println("The grand total is as expected ");
}
else
{
	System.out.println("The grand total is changed");
}

//Close all windows
driver.quit();

	}

}
