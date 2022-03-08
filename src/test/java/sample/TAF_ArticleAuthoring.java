package sample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class TAF_ArticleAuthoring {
  public WebDriver driver=null;
// to check the author(title&keypoints) and submission button functionalitys to be performed after login 
  @Test
  public void testlogin_valid() {
   driver.get("https://testautomationforum.com/");
   driver.findElement(By.xpath("//a[@href=\"https://testautomationforum.com/login-register/\"]")).click();
   driver.findElement(By.id("eael-user-login")).sendKeys("harikrishnapara145@gmail.com");
   driver.findElement(By.id("eael-user-password")).sendKeys("Hari@145");
   driver.findElement(By.id("eael-login-submit")).click();
   driver.findElement(By.className("ast-button")).click();
   Actions a = new Actions(driver);
   a.sendKeys(Keys.PAGE_DOWN).perform();
   driver.findElement(By.id("nf-field-10")).sendKeys("for testing");
   driver.findElement(By.name("nf-field-8")).sendKeys("for testing purpose");
   driver.findElement(By.id("nf-field-9")).click();
  }
  @BeforeClass
  public void beforeClass() {
   WebDriverManager.chromedriver().setup();
   driver = new ChromeDriver();
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   
    }

  @AfterClass
  public void afterClass() {
  driver.quit();
  }

}