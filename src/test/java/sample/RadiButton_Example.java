package sample;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class RadiButton_Example {
	public WebDriver driver;
  @Test
  public void testRadiButton_Example () throws Exception {
	  //navigate to application
	 driver.get("http://www.tizag.com/htmlT/htmlinput.php");
	 //checkbox
	 driver.findElement(By.xpath("((//form[@name='myWebForm'])[1]/input[1]")).click();
	 //textbox
	 driver.findElement(By.xpath("((//form[@name='myWebForm'])[1]/input[2]")).sendKeys("Sample name");
	 //radio button--No
	 driver.findElement(By.xpath("((//form[@name='myWebForm'])[1]/input[4]")).click();
	  Thread.sleep(2000);
//reset button
	  driver.findElement(By.xpath("((//form[@name='myWebForm'])[1]/input[6]")).click();
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
