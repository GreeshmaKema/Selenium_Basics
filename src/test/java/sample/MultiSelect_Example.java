package sample;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class MultiSelect_Example {
	public WebDriver driver;
  @Test
  public void testMultiSelect_Example () throws Exception {
	  //navigate to application
	  driver.get("https://www.tizag.com/htmlT/htmlselect.php");
	WebElement ms= driver.findElement(By.xpath("(//select[@multiple='yes'])[1]"));
	Select s = new Select(ms);
	s.selectByVisibleText("California -- CA");
	  Thread.sleep(1000);
	  s.selectByVisibleText("Colorado -- CO");
	  Thread.sleep(1000);
	  s.selectByVisibleText("Connecticut -- CN");
	  Thread.sleep(1000);
	  //deselect options
	  s.deselectByVisibleText("California -- CA");
	  Thread.sleep(1000);
	  s.deselectAll();
	  Thread.sleep(1000);
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
