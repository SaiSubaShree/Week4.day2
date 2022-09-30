package week4.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseMoveover {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://www.snapdeal.com/");
		Thread.sleep(3000);
		WebElement MensFashion = driver.findElement(By.xpath("//span[@class='catText']"));
		Actions builder= new Actions(driver);
		builder.moveToElement(MensFashion).perform();
		driver.findElement(By.xpath("//span[text()='Shirts']")).click();
		
		WebElement shirt = driver.findElement(By.xpath("//div[@class='product-tuple-image ']"));
		builder.moveToElement(shirt).perform();
		shirt.click();
		

	}

}
