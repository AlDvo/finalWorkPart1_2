package finalWorkPart1_2.manager;

import finalWorkPart1_2.util.TestPropertis;

import java.util.concurrent.TimeUnit;

public class InitManager {

    /**
     * Менеджер properties
     *
     * @see TestPropertis#getTestPropertis()
     */
    private static final TestPropertis props = TestPropertis.getTestPropertis();

    /**
     * Менеджер WebDriver
     *
     * @see DriverManager#getDriverManager()
     */
    private static final DriverManager driverManager = DriverManager.getDriverManager();

    /**
     * Инициализация framework и запуск браузера со страницей приложения
     *
     * @see DriverManager
     * @see TestPropertis#getProperty(String)
     * @see TestPropertis
     */
    public static void initFramework() {
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    /**
     * Завершения работы framework - гасит драйвер и закрывает сессию с браузером
     *
     * @see DriverManager#quitDriver()
     */
    public static void quitFramework() {
        driverManager.quitDriver();
    }
}
