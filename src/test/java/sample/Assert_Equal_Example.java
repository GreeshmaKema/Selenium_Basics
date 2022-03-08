package sample;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Assert_Equal_Example {
	public WebDriver driver;
  @Test
  public void testButton_Example () throws Exception {
	  //navigate to application
	  driver.get("https://www.selenium.dev/");
	String text=driver.findElement(By.xpath("//h1@class='display-1 mt-0 mt-md-5 pb-1']")).getText();
	System.out.println("Text on web page is : "+text);
	Assert.assertEquals(text, "Selenium automates browsers. That's it!");
	System.out.println("Assertion is passed");
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
