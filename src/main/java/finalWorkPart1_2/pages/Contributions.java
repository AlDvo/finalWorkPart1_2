package finalWorkPart1_2.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Contributions extends BasePage {

    @FindBy(xpath = "//div[@class = 'calculator__currency-content']")
    WebElement currency;

    @FindBy(xpath = "//input[@name = 'amount']")
    WebElement depositaAmount;

    @FindBy(xpath = "//select[@name = 'period']")
    WebElement period;

    @FindBy(xpath = "//input[@name= 'replenish']")
    WebElement replenish;

    @FindBy(xpath = "//input[@name= 'capitalization']/..")
    WebElement capitalization;

    @FindBy(xpath = "//tr[@class= 'calculator__dep-result-table-row']")
    WebElement resultCalc;


    @Step("Выбираем валюту вклада {value}")
    public Contributions selectCurrency(String value) {
        currency.findElement(By.xpath(".//input[@value = '" + value + "']/../span")).click();
        return this;
    }

    @Step("Сумма вклада {value}")
    public Contributions selectDepositAmount(String value) {
        fillField(depositaAmount, value);
        return this;
    }

    @Step("Выбираем срок вклада {value} месяцев")
    public Contributions selectPeriod(String value) {
        new Select(period).selectByVisibleText("" + value + " месяцев");
        return this;
    }

    @Step("Выбираем сумму ежемесячного пополнения {value}")
    public Contributions selectRelenish(String value) {
        fillField(replenish, value);
        return this;
    }

    @Step("Отметить чек-бокс – Ежемесячная капитализация ")
    public Contributions selectCapitalization() {
        if (!capitalization.getAttribute("class").equals("jq-checkbox calculator__check checked")) {
            capitalization.click();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step(" Проверяем значение {value}  равно {result}")
    public Contributions checkResultCalc(String value, String result) {

        Assert.assertEquals("Значение не совпадает", resultCalc.findElement(By.xpath(".//td[text() = '" + value + "']/..//b/span")).getText(), result);
        return this;
    }

    @Step(" Проверяем значение {value}  равно {result}")
    public Contributions checkResultReplenish(String value, String result) {
        Assert.assertEquals("Значение не совпадает", driverManager.getDriver().findElement(By.xpath("//td[text() = '" + value + "']/..//span[@class = 'js-calc-replenish']")).getText(), result);
        return this;
    }

    @Step(" Проверяем значение {value}  равно {result}")
    public Contributions checkResultValue(String value, String result) {
        Assert.assertEquals("Значение не совпадает", driverManager.getDriver().findElement(By.xpath("//div[text() = '" + value + "']/..//span[@class = 'js-calc-result']")).getText(), result);
        return this;
    }

    @Step(" Проверяем значение месяцев в графе {value}")
    public Contributions checkMonth(String value) {
        if (!( driverManager.getDriver().findElement(By.xpath("//*[text() = '" + value + "']//span[@class = 'js-calc-period']")).getText() )
                .equals(period.findElement(By.xpath("./..//div[@class = 'jq-selectbox__select-text']")).getText())) {
            Assert.fail("Месяц не совпадает");
        }
        return this;
    }
}
