package sample;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class Droppable_Example {
	public WebDriver driver;
  @Test
  public void testDroppable_Example () throws Exception {
	 driver.get("https://jqueryui.com/");
	 driver.findElement(By.linkText("Droppable")).click();
	 //switch to iframe
	 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=demo-frame']")));
	WebElement drag= driver.findElement(By.id("draggable"));
	WebElement drop= driver.findElement(By.id("droppable"));
	//create an object for actions class
	Actions a = new Actions(driver);
	a.dragAndDrop(drag, drop).perform();
	Thread.sleep(2000);
 }
  @BeforeClass
  public void beforeClass() {
	  //instantiate Chrome browser
	  WebDriverManager.chromedriver().setup();
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	  //close Chrome browser
	  driver.quit();
  }

}
