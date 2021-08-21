package finalWorkPart1_2.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy(xpath = "//div[@class = 'services services_main']")
    WebElement mainService;

    @Step("Выбрали на главной странице сервис {value}")
    public Contributions selectMainService(String value){
        mainService.findElement(By.xpath(".//div[text() = '" + value +"']/..//a[@class = 'service__title-action']")).click();
        return new Contributions();
    }
}
