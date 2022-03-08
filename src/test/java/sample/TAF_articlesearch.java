package sample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class TAF_articlesearch {
  public WebDriver driver=null;
  @Test
  public void testTAF_articlesearch() {
   driver.get("https://testautomationforum.com/");
   driver.findElement(By.xpath("//a[@href=\"https://testautomationforum.com/articles/\"]")).click();
   driver.findElement(By.xpath("//a[@href=\"https://testautomationforum.com/why-current-testing-processes-in-ai-ml-are-not-enough/\"]")).click();
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

