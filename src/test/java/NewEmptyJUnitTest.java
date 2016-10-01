import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewEmptyJUnitTest {
    
  @Test
  public void populateValues() {
      String strFirstName;
      WebDriver driver  = new FirefoxDriver();
      driver.get("https://www.usaa.com/inet/ent_membereligibility/CpModularPersonalInfo?action=executeTask&target=ModularPersonalInfoTask&operationName=INIT&wa_ref=wcu_main_banner");
      WebElement elementFirstName = driver.findElement(By.id("FirstName"));
      WebElement elementMiddleName = driver.findElement(By.id("MiddleName"));
      elementFirstName.sendKeys("German");
      elementMiddleName.sendKeys("M");
      strFirstName = elementFirstName.getAttribute("value");
      //driver.findElement(By.name("btnWriteReport")).click();
      System.out.println(strFirstName);
      driver.close();
      System.out.println("Done");
      System.exit(0);
  }
}