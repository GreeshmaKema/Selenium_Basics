package sample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Alert_Example {
 public WebDriver driver;
	
  @Test
  public void testAlert_Example() throws Exception {
   //navigate to application
   driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
   driver.findElement(By.xpath("//input[@value='Confirmation Alert']")).click();
   //get alert text
   String aMsg=driver.switchTo().alert().getText();
   System.out.println("Alert message : "+aMsg);
   //handle the alert
   driver.switchTo().alert().accept();
   Thread.sleep(2000);
  }
  @BeforeClass
  public void beforeClass() {
   //instantiate chrome browser
   WebDriverManager.chromedriver().setup();
   driver = new ChromeDriver();
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  @AfterClass
  public void afterClass() {
   //close chrome browser
   driver.quit();
  }

}
 