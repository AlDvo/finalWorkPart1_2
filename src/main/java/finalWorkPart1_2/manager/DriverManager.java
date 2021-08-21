package finalWorkPart1_2.manager;

import finalWorkPart1_2.util.TestPropertis;
import org.apache.commons.exec.OS;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {


    /**
     * Переменна для хранения объекта веб-драйвера
     *
     * @see WebDriver
     */
    private WebDriver driver;


    /**
     * Переменна для хранения объекта DriverManager
     */
    private static DriverManager INSTANCE = null;


    /**
     * Менеджер properties
     *
     * @see TestPropertis#getTestPropertis()
     */
    private final TestPropertis testPropertis = TestPropertis.getTestPropertis();


    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see DriverManager#getDriverManager()
     */
    private DriverManager() {
    }

    /**
     * Метод ленивой инициализации DriverManager
     *
     * @return DriverManager - возвращает DriverManager
     */
    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    /**
     * Метод ленивой инициализации веб драйвера
     *
     * @return WebDriver - возвращает веб драйвер
     */
    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    /**
     * Метод для закрытия сессии драйвера и браузера
     *
     * @see WebDriver#quit()
     */
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    /**
     * Метод инициализирующий веб драйвер
     */
    private void initDriver() {
        if (OS.isFamilyWindows()) {
            initDriverWindowsOsFamily();
        } else if (OS.isFamilyMac()) {
            initDriverMacOsFamily();
        } else if (OS.isFamilyUnix()) {
            initDriverUnixOsFamily();
        }
    }

    /**
     * Метод инициализирующий веб драйвер под ОС семейства Windows
     */
    private void initDriverWindowsOsFamily() {
        initDriverAnyOsFamily("path.gecko.driver.windows", "webdriver.chrome.driver");
    }


    /**
     * Метод инициализирующий веб драйвер под ОС семейства Mac
     */
    private void initDriverMacOsFamily() {
        initDriverAnyOsFamily("path.gecko.driver.mac", "path.chrome.driver.mac");
    }

    /**
     * Метод инициализирующий веб драйвер под ОС семейства Unix
     */
    private void initDriverUnixOsFamily() {
        initDriverAnyOsFamily("path.chrome.driver.unix", "path.gecko.driver.unix");
    }


    /**
     * Метод инициализирующий веб драйвер под любую ОС
     *
     * @param gecko - переменная firefox из файла application.properties в классе {@link}
     * @param chrome - переменная chrome из файла application.properties в классе {@link}
     */
    private void initDriverAnyOsFamily(String gecko, String chrome) {
        switch (testPropertis.getProperty("browser")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", testPropertis.getProperty(gecko));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", testPropertis.getProperty(chrome));
                driver = new ChromeDriver();
                break;
            default:
                Assert.fail("Типа браузера '" + testPropertis.getProperty("browser") + "' не существует во фреймворке");
        }
    }


}
