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

public class GetAttribute_Example {
	public WebDriver driver;
  @Test
  public void testGetAttribute_Example () throws Exception {
	  //navigate to application
	 driver.get("https://www.bing.com/");
	 driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
	String insideText= driver.findElement(By.id("sb_form_q")).getAttribute("value");
	System.out.println("Text inside text box : "+insideText);
	String ml=driver.findElement(By.id("sb_form_q")).getAttribute("maxlength");
	System.out.println("Max length of text box : "+ml);
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
