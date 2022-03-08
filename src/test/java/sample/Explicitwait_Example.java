package sample;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Explicitwait_Example {
 public WebDriver driver;

 @Test
 public void testExplicitwait_Example() throws Exception {
  //navigate to application
  driver.get("https://the-internet.herokuapp.com/dynamic_loading");
  driver.findElement(By.partialLinkText("Example 1: ")).click();
  driver.findElement(By.xpath("//div[@id='start']/button")).click();
  //explicit wait
  WebDriverWait wait = new WebDriverWait(driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
  String msg=driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
  System.out.println("Message is :"+msg);
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