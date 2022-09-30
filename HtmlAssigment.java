package week4.Day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlAssigment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
	//Launch the URL
driver.get("https://html.com/tags/table/");

List<WebElement> rowcount = driver.findElements(By.xpath("//table/tbody/tr"));
int size = rowcount.size();
System.out.println("The number of rows "+size);

//WebElement colcount = driver.findElement(By.xpath("//table/thead/tr/th"));
//Dimension size2 = colcount.getSize();
List<WebElement> ColCount = driver.findElements(By.tagName("th"));
int Count = ColCount.size();
System.out.println("The number of coloums "+Count);

	}

}
