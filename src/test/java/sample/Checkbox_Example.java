package sample;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Checkbox_Example {
	public WebDriver driver;
  @Test
  public void testCheckbox_Example () throws Exception {
	  //navigate to application
	 driver.get("http://www.tizag.com/htmlT/htmlCheckboxes.php");
	 //check the checkbox
	 driver.findElement(By.xpath("(//input[@value='football'])[1]")).click();
	 Thread.sleep(2000);
	  //uncheck the checkbox
	  driver.findElement(By.xpath("(//input[@value='soccer'])[2]")).click();
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
