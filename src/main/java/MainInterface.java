import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.firefox.FirefoxDriver;

public interface MainInterface {
    public void loadSite(String strSiteURL);
    public void populateDropDown(String strElemID, String strValue);
    public void uploadFile(String strElemID, String strValue);
    public void populateTextBox(String strElemID, String strValue);
    public void selectRadio(String strElemID);
    public void clickButton(String strElemID);
    public void populateSpecialTextBox(String strXPath, String strValue);
    public void SpecialClickButton(String strXPath);
    public void closeSite();
}
