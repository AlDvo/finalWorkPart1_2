package finalWorkPart1_2.pages;

import finalWorkPart1_2.manager.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected DriverManager driverManager = DriverManager.getDriverManager();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), 10, 1000);


    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }


    protected void scrollToElementJs(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driverManager.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
   }
}
