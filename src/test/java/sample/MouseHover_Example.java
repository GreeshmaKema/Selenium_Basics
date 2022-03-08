package sample;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class MouseHover_Example {
 public WebDriver driver;
	
  @Test
  public void testMouseHover_Example() throws Exception {
   //navigate to application
   driver.get("https://the-internet.herokuapp.com/");
   driver.findElement(By.linkText("Hovers")).click();
   WebElement we=driver.findElement(By.xpath("//img[@alt='User Avatar']"));
   Actions a = new Actions(driver);
   a.moveToElement(we).perform();
   Thread.sleep(2000);
   driver.findElement(By.linkText("View profile")).click();
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