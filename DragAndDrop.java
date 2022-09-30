package week4.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();
driver.manage().window().maximize();
//Launch the url
driver.get("https://www.leafground.com/drag.xhtml");
//Drag and drop
WebElement Drag = driver.findElement(By.xpath("(//h4[text()='Draggable']/following-sibling::div//div/div)[2]"));
Actions builder=new Actions(driver);
builder.dragAndDropBy(Drag, 220,100).perform();

//Drag and drop from source to destination

WebElement drag1 = driver.findElement(By.xpath("//div[@id='form:drag']"));
WebElement drop = driver.findElement(By.xpath("//div[@id='form:drop_content']"));
builder.dragAndDrop(drag1, drop).perform();


//Drag row
WebElement souR = driver.findElement(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content ui-sortable']/tr[3]"));
WebElement DestR = driver.findElement(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content ui-sortable']/tr[4]"));
builder.dragAndDrop(souR, DestR).perform();


//Drag coloumn
WebElement Source = driver.findElement(By.xpath("//span[text()='Category']"));
WebElement Destination = driver.findElement(By.xpath("//span[text()='Name']"));
builder.dragAndDrop(Source, Destination).perform();

//Drag an img
//WebElement Dragimg = driver.findElement(By.xpath("//div[@class='ui-wrapper']/img"));
WebElement Dragimg = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-e']"));
builder.dragAndDropBy(Dragimg, 15, 15).perform();
System.out.println("resize img perfored");


// progress bar
driver.findElement(By.xpath("//h5[text()='Progress Bar']/following-sibling::button")).click();
Thread.sleep(6000);
driver.findElement(By.xpath("(//h5[text()='Progress Bar']/following-sibling::button)[2]")).click();

//slider
WebElement slide = driver.findElement(By.xpath("(//div[@id='form:j_idt125']/span)[2]"));

builder.dragAndDropBy(slide, 14, 0).perform();


	}

}
