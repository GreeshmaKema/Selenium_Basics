package sample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class TAF_loginvalid {
  public WebDriver driver=null;
  @Test
  public void testTAF_loginvalid() {
   driver.get("https://testautomationforum.com/");
   driver.findElement(By.xpath("//a[@href=\"https://testautomationforum.com/login-register/\"]")).click();
   driver.findElement(By.id("eael-user-login")).sendKeys("harikrishnapara145@gmail.com");
   driver.findElement(By.id("eael-user-password")).sendKeys("Hari@145");
   driver.findElement(By.id("eael-login-submit")).click();
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

 
