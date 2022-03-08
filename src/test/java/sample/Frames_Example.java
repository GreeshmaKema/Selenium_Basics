package sample;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Frames_Example {
	public WebDriver driver;
  @Test
  public void testFrames_Example () throws Exception {
	  //navigate to application
	  driver.get("https://jqueryui.com/");
	  driver.findElement(By.linkText("Autocomplete")).click();
	  //switch to iframe
	  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
	  driver.findElement(By.id("tags")).sendKeys("selenium");
	  Thread.sleep(2000);
	  //come out of the frame
	  driver.switchTo().defaultContent();
	  driver.findElement(By.linkText("Droppable")).sendKeys("selenium");
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
