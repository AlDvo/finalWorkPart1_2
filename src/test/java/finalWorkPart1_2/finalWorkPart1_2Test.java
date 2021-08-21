package finalWorkPart1_2;

import finalWorkPart1_2.pages.MainPage;
import org.junit.Test;

public class finalWorkPart1_2Test extends BaseTest {
    MainPage mainPage = new MainPage();

    @Test
    public void finalWorkPart1_2() {

        mainPage.selectMainService("Вклады")
                .selectCurrency("RUB")
                .selectDepositAmount("300000")
                .selectPeriod("6")
                .selectRelenish("50000")
                .selectCapitalization()
                .checkResultCalc("Начислено %:", "12 243,26")
                .checkResultReplenish("Пополнение за ","250 000")
                .checkResultValue("К снятию через ","562 243,27")
                .checkMonth("К снятию через ")
                .checkMonth("Пополнение за ");
    }
}
