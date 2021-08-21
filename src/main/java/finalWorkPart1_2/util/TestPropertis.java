package finalWorkPart1_2.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Arkadiy_Alaverdyan
 * Класс для управления пропертями
 */
public class TestPropertis {

    /**
     * Переменна для хранения данных считанных из файла properties и переданных пользователем
     * Т.е. переменная для хранения пользовательских properties
     *
     * @see Properties - реализован на основе {@link java.util.Hashtable}
     */
    private final Properties properties = new Properties();


    /**
     * Переменна для хранения объекта TestPropManager
     */
    private static TestPropertis INSTANCE = null;


    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     * Происходит загрузка содержимого файла application.properties в переменную {@link #properties}
     *
     * @see TestPropertis#getTestPropertis()
     */
    private TestPropertis() {
        loadApplicationProperties();
    }


    /**
     * Метод ленивой инициализации TestPropManager
     *
     * @return TestPropManager - возвращает TestPropManager
     */
    public static TestPropertis getTestPropertis() {
        if (INSTANCE == null) {
            INSTANCE = new TestPropertis();
        }
        return INSTANCE;
    }


    /**
     * Метод подгружает содержимого файла application.properties в переменную {@link #properties}
     * Либо из файла переданного пользователем через настройку -DpropFile={nameFile}
     *
     * @see TestPropertis#TestPropertis()
     */
    private void loadApplicationProperties() {
        try {
            properties.load(new FileInputStream("src/main/resources/" +
                    System.getProperty("propFile", "environment") + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод возвращает либо значение записанное в ключе в переменной {@link #properties},
     * либо defaultValue при отсутствие ключа в переменной {@link #properties}
     *
     * @param key          - ключ, значения которого хотите получить
     * @param defaultValue - значение по умолчанию которое хотите получить если отсутствует ключ в {@link #properties}
     * @return String - возвращает системное св-во либо переданное default значение
     */
    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }


    /**
     * Метод возвращает значения записанное в ключе в переменной {@link #properties}, если нет переменной вернет null
     *
     * @param key - ключ, значения которого хотите получить
     * @return String - строка со значением ключа
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}

