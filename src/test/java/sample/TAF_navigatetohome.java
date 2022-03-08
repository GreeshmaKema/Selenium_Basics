package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TAF_navigatetohome {
 public WebDriver driver;
	
  @Test
  public void testTAF_navigatetohome() throws Exception {
   //navigate to application
   driver.navigate().to("https://testautomationforum.com/");
   driver.findElement(By.xpath("//li[@id='menu-item-223']")).click();
   driver.navigate().back();
   Thread.sleep(2000);
   String title=driver.getTitle();
   System.out.println("Title of the page is :"+title);
  driver.navigate().forward();
  String title1=driver.getTitle();
   System.out.println("Title of the page is :"+title1);
   Thread.sleep(2000);
   driver.navigate().refresh();
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
