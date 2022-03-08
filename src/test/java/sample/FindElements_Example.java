package sample;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class FindElements_Example {
 public WebDriver driver;

 @Test
 public void testFindElements_Example() throws Exception {
  //navigate to application
  driver.get("https://www.google.com/");
  driver.findElement(By.name("q")).sendKeys("selenium");
  List<WebElement> sug=driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));
  System.out.println("Number of suggestions : "+sug.size());
  for (int i = 0; i < sug.size(); i++) {
   System.out.println("Suggestions are : "+sug.get(i).getText());
  }
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