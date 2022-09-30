package week4.Day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chitoragraph {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		// Launch the URL
	driver.get("https://www.chittorgarh.com/");
	
//2. Click on stock market	
	driver.findElement(By.xpath("//a[@title='Stock Market']")).click();
	Thread.sleep(1000);
	
	//3. Click on NSE bulk Deals
	driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
	
	//4. Get all the Security names
	
	List<WebElement> tab = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']/tbody/tr"));
	
	int size = tab.size();	
	Thread.sleep(4000);
	
	String text = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr//td[3]")).getText();
	System.out.println(text);
	Thread.sleep(2000);
	for(int i=1;i<=size;i++)
	{
		String text1 = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr[" + i + "]/td[3]")).getText();
		System.out.println(text1);
	}
	// . Ensure whether there are duplicate Security names
	//converting list of web elements in to a list
	
		
		List <String> Security= new ArrayList<String>();
		for (WebElement webElement : tab) {
			Security.add(webElement.getText());
		}
		
		System.out.println(Security);
		Set <String> removeDuplicate= new LinkedHashSet<String>(Security);
		/*for (String string : Security) {
			removeDuplicate.add(string);
		}*/
		
		
		int SecSet = removeDuplicate.size();
		System.out.println("The size of set " +SecSet);
		
		int SecList = Security.size();
		System.out.println("The size of List" + SecList);
		if(SecList==SecSet)
		{
			System.out.println("The duplicates are not removed");
		}
		else
		{
			System.out.println("Duplicates are removed");
		}
			
	
	
	}

}
