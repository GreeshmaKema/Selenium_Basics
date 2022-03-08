package sample;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Dropdown_Example2 {
	public WebDriver driver;
  @Test
  public void testDropdown_Example2 () throws Exception {
	  //navigate to application
	  driver.get("https://the-internet.herokuapp.com/");
	 driver.findElement(By.linkText("Dropdown")).click();
	 WebElement dd=driver.findElement(By.id("dropdown"));
	 //create an object for select class
	 Select s = new Select(dd);
	List<WebElement> options=s.getOptions();
	System.out.println("Number of option in dropdown :"+options.size());
	for (int i = 0; i < options.size(); i++) {
		System.out.println("Values in dropdown :"+options.get(i).getText());
	}
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
