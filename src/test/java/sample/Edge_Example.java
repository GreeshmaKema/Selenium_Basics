package sample;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;

public class Edge_Example {
	public WebDriver driver;
  @Test
  public void testEdge_Example() {
	  //navigate to application
	  driver.get("https://mvnrepository.com/");
  }
  @BeforeClass
  public void beforeClass() {
	  /*WebDriveManager.firefoxdriver().setup();
	   * driver = new FirefoxDriver();
	   */
	 WebDriverManager.edgedriver().setup();
  driver = new EdgeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	  //close Chrome browser
	  driver.quit();
  }

}
