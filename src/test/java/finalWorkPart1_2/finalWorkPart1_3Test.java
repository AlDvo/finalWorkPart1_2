package finalWorkPart1_2;

import finalWorkPart1_2.pages.MainPage;
import org.junit.Test;

public class finalWorkPart1_3Test extends BaseTest {
    MainPage mainPage = new MainPage();

    @Test
    public void finalWorkPart1_3() {

        mainPage.selectMainService("Вклады")
                .selectCurrency("USD")
                .selectDepositAmount("500000")
                .selectPeriod("12")
                .selectRelenish("20000")
                .selectCapitalization()
                .checkResultCalc("Начислено %:", "920,60")
                .checkResultReplenish("Пополнение за ","220 000")
                .checkResultValue("К снятию через ","720 920,60")
                .checkMonth("К снятию через ")
                .checkMonth("Пополнение за ");
    }
}
