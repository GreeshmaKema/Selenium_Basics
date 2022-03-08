package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keys_Example {
 public WebDriver driver;

 @Test
 public void testKeys_Example() throws Exception {
  //navigate to application
  driver.get("https://www.bing.com/");
  driver.findElement(By.name("q")).sendKeys("selenium");
  Actions a = new Actions(driver);
  a.sendKeys(Keys.ENTER).perform();
  Thread.sleep(2000);
  a.sendKeys(Keys.PAGE_DOWN).perform();
  a.sendKeys(Keys.PAGE_DOWN).perform();
  Thread.sleep(2000);
  a.sendKeys(Keys.PAGE_UP).perform();
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
