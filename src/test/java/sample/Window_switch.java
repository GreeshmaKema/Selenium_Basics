package sample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Window_switch {
 public WebDriver driver;
 @Test
 public void testWindow_switch() throws Exception {
  //navigate to application
  driver.get("https://the-internet.herokuapp.com/");
  driver.findElement(By.linkText("Checkboxes")).click();
  driver.findElement(By.linkText("Elemental Selenium")).click();
// get parent window handle
  String pw=driver.getWindowHandle();
  System.out.println("parent window handle:"+pw);
// get all window handles
  Set<String> windows=driver.getWindowHandles();
// remove parent window from set
  windows.remove(pw);
// switch to child window
  driver.switchTo().window(windows.iterator().next());
  Thread.sleep(2000);
// close child window
  driver.close();
// switch to parent window
  driver.switchTo().window(pw);
// perform actions on parent window
  driver.findElement(By.xpath("//form[@id='chechboxes']/input")).click();
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
