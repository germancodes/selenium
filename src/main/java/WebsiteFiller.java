
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebsiteFiller implements MainInterface{
    private final WebDriver driver  = new FirefoxDriver();
       
    @Override
    public void loadSite(String strSiteURL) {
        //WebDriver driver  = new FirefoxDriver();
        driver.get(strSiteURL);
        WebDriverWait wait = new WebDriverWait(driver, 10);
    }
    
    @Override
    public void populateDropDown(String strElemID, String strValue) {
        Select dropdown = new Select(driver.findElement(By.id(strElemID)));
        if (dropdown.isMultiple()) {
            dropdown.deselectAll();
        }
        dropdown.selectByVisibleText(strValue);
    }
    
    @Override
    public void uploadFile(String strElemID, String strValue) {
        WebElement textBoxElem = driver.findElement(By.id(strElemID));
        textBoxElem.sendKeys(strValue);
    }
    
    @Override
    public void populateTextBox(String strElemID, String strValue) {
        WebElement textBoxElem = driver.findElement(By.id(strElemID));
        textBoxElem.clear();
        textBoxElem.sendKeys(strValue);
    }
    
    @Override
    public void selectRadio(String strElemID){
        WebElement radioElem = driver.findElement(By.id(strElemID));
        radioElem.click();
    }
    
    @Override
    public void clickButton(String strElemID) {
        WebElement buttElem = driver.findElement(By.id(strElemID));
        buttElem.click();
    }
    
    @Override
    public void populateSpecialTextBox(String strXPath, String strValue) {
        WebElement specialElem = driver.findElement(By.xpath(strXPath));
        specialElem.sendKeys(strValue);
    }
    
    @Override
    public void SpecialClickButton(String strXPath) {
        WebElement specialElem = driver.findElement(By.xpath(strXPath));
        specialElem.click();
    }
    @Override
    public void closeSite(){
      driver.close();
      driver.quit();
      System.out.println("Done w/ automation");
    }
    
}
