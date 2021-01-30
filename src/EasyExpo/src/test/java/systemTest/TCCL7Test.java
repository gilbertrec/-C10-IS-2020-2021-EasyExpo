// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class TCCL7Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver","C:\\Users\\gaeta\\Desktop\\Cartelle\\UNISA\\chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void tCCL71() {
    driver.get("http://localhost:8080/EasyExpo_war/");
    driver.manage().window().setSize(new Dimension(1225, 708));
    driver.findElement(By.name("email")).sendKeys("gaetano99@gmail.com");
    driver.findElement(By.name("password")).sendKeys("Gaetano99*");
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.cssSelector(".owl-item:nth-child(7) a")).click();
    driver.findElement(By.name("addNum")).click();
    driver.findElement(By.cssSelector(".btn")).click();
  }
  @Test
  public void tCCL72() {
    driver.get("http://localhost:8080/EasyExpo_war/");
    driver.manage().window().setSize(new Dimension(1225, 708));
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.cssSelector(".owl-item:nth-child(7) a")).click();
    driver.findElement(By.name("addNum")).click();
    driver.findElement(By.name("addNum")).sendKeys("9999");
    driver.findElement(By.cssSelector(".btn")).click();
  }
  @Test
  public void tCCL73() {
    driver.get("http://localhost:8080/EasyExpo_war/");
    driver.manage().window().setSize(new Dimension(1225, 708));
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.cssSelector(".owl-item:nth-child(7) a")).click();
    driver.findElement(By.name("addNum")).click();
    driver.findElement(By.name("addNum")).sendKeys("E");
    driver.findElement(By.cssSelector(".btn")).click();
  }
  @Test
  public void tCCL74() {
    driver.get("http://localhost:8080/EasyExpo_war/");
    driver.manage().window().setSize(new Dimension(1225, 708));
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.cssSelector(".owl-item:nth-child(7) a")).click();
    driver.findElement(By.name("addNum")).click();
    driver.findElement(By.name("addNum")).sendKeys("888");
    driver.findElement(By.cssSelector(".btn")).click();
  }
  @Test
  public void tCCL75() {
    driver.get("http://localhost:8080/EasyExpo_war/");
    driver.manage().window().setSize(new Dimension(1225, 708));
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.cssSelector(".owl-item:nth-child(7) a")).click();
    driver.findElement(By.name("addNum")).click();
    driver.findElement(By.name("addNum")).sendKeys("10");
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.cssSelector(".owl-item:nth-child(7) a")).click();
    driver.findElement(By.name("addNum")).sendKeys("2");
    driver.findElement(By.name("addNum")).click();
    driver.findElement(By.name("addNum")).sendKeys("3");
    driver.findElement(By.name("addNum")).click();
    {
      WebElement element = driver.findElement(By.name("addNum"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.name("addNum")).sendKeys("4");
    driver.findElement(By.name("addNum")).click();
    driver.findElement(By.name("addNum")).sendKeys("5");
    driver.findElement(By.name("addNum")).click();
    driver.findElement(By.name("addNum")).sendKeys("6");
    driver.findElement(By.name("addNum")).click();
    driver.findElement(By.cssSelector(".btn")).click();
  }
}
