package finalWorkPart1_2.manager;

import finalWorkPart1_2.pages.Contributions;
import finalWorkPart1_2.pages.MainPage;

public class PageManager {

    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Стартовая страничка
     */
    private MainPage mainPage;

    /**
     * Страничка покупки вторичного жилья
     */
    private Contributions contributions;

    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    private PageManager() {
    }

        /**
         * Ленивая инициализация PageManager
         *
         * @return PageManager
         */
        public static PageManager getPageManager() {
            if (pageManager == null) {
                pageManager = new PageManager();
            }
            return pageManager;
        }

    /**
     * Ленивая инициализация {@link MainPage}
     *
     * @return StartPage
     */
    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    /**
     * Ленивая инициализация {@link Contributions}
     *
     * @return InsurancePage
     */
    public Contributions getContributions() {
        if (contributions == null) {
            contributions = new Contributions();
        }
        return contributions;
    }
}
