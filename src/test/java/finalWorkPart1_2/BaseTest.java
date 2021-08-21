package finalWorkPart1_2;

import finalWorkPart1_2.manager.DriverManager;
import finalWorkPart1_2.manager.InitManager;
import finalWorkPart1_2.util.TestPropertis;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


public class BaseTest {
    private static DriverManager driverManager = DriverManager.getDriverManager();
    private TestPropertis testPropertis = TestPropertis.getTestPropertis();

    @BeforeClass
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @Before
    public void Before() {
        driverManager.getDriver().get(TestPropertis.getTestPropertis().getProperty("base.url"));
    }

    @AfterClass
    public static void After() {
        driverManager.quitDriver();
    }
}
