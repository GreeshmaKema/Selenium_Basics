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

public class Get_Commands {
	public WebDriver driver;
  @Test
  public void testGet_Commands () throws Exception {
	  //navigate to application
	 driver.get("https://www.selenium.dev/");
	 driver.findElement(By.xpath("//span[text()='Downloads']")).click();
	 String title=driver.getTitle();
	 System.out.println("Title of the page is :"+title);
	 Assert.assertEquals(title, "Downloads | Selenium");
	 String url=driver.getCurrentUrl();
	 System.out.println("URL of the page is :"+url);
	 Assert.assertEquals(url, "https://www.selenium.dev/downloads/");
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
