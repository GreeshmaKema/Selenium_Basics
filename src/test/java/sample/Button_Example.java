package sample;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Button_Example {
	public WebDriver driver;
  @Test
  public void testButton_Example () throws Exception {
	  //navigate to application
	  driver.get("https://mvnrepository.com/");
	 // driver.findElement(By.id("query")).sendKeys("testng");
	  driver.findElement(By.xpath("//input[@name='q']")).sendKeys("testng");
	  //to perform action on button,radio button,checkbox and links we have to use click();
	  driver.findElement(By.xpath("//input[@value='Search']")).click();
	  Thread.sleep(6000);
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
