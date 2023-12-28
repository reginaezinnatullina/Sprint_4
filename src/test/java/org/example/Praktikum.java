package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// Класс с автотестом
public class Praktikum {
    private WebDriver driver;
    @Before
    public void startUp() {
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();
    }

    //Тест заказа через кнопку в заголовке (правый верхний угол) через Firefox
    @Test
    public void checkActivityFirefox() {
        // драйвер для браузера FireFox
        WebDriver driver = new FirefoxDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // создай объект класса главной страницы приложения
        HomePageMesto objHomePageOne = new HomePageMesto(driver);
        objHomePageOne.clickCookieButton();
        // кликни на кнопку "заказать"
        objHomePageOne.clickEditProfileButtonInHeader();
        // создай объект класса страницы авторизации
        OrderPage objLoginPage = new OrderPage(driver);
        // выполни авторизацию
        objLoginPage.login("Регина", "Зиннатуллина", "Водный стадион", "город Москва, улица Генерала Тюленева 37, кв. 29", "89656612081");
        RentPage objLoginPageOne = new RentPage(driver);
        objLoginPageOne.rentLogin("01.01.2024", "Буду дома после 18:00");
    }

    //Тест заказа через кнопку в середине страницы через Chrome
    @Test
    public void checkActivityChrome() {
        // драйвер для браузера FireFox
        WebDriver driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // создай объект класса главной страницы приложения
        HomePageMesto objHomePageTwo = new HomePageMesto(driver);
        objHomePageTwo.clickCookieButton();
        // кликни на кнопку "заказать"
        objHomePageTwo.clickEditProfileButtonInMiddle();
        // создай объект класса страницы авторизации
        OrderPage objLoginPage = new OrderPage(driver);
        // выполни авторизацию
        objLoginPage.login("Алина", "Зиннатуллина", "Маяковская", "город Москва, улица Генерала Тюленева 35, кв. 15", "89273112154");
        RentPage objLoginPageTwo = new RentPage(driver);
        objLoginPageTwo.rentLogin("03.01.2024", "Буду дома весь день");
    }
    // Массив с текстом ожидаемых ответов
    private final String[] expectedAnswersList = new String[]{
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };
     // Тест соответствия текста в выпадающем списке в браузере Chrome
        @Test
        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        public void CheckQuestion() {
            WebDriver driver = new ChromeDriver();
            // переход на страницу тестового приложения
            driver.get("https://qa-scooter.praktikum-services.ru/");
            // создание объекта класса главной страницы приложения
            HomePageMesto objHomePageThree = new HomePageMesto(driver);
            // клик по куки
            objHomePageThree.clickCookieButton();
            //прокрутка до списка
            objHomePageThree.scrollToQuestions();
            // проверка списка на совпадение
            for (int i = 0; i < 8; i++) {
                HomePageMesto.clickQuestion(i);
                HomePageMesto.checkTextInOpenPanel(expectedAnswersList[i], i);
            }
        }
    @Test
    // Дополнительный тест на проверку несуществующего заказа
    public void CheckNumberOfOrder() {
        WebDriver driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // создание объекта класса главной страницы приложения
        HomePageMesto objHomePageFour = new HomePageMesto(driver);
        // клик по кнопке проверки заказа, введение номера заказа и его проверка
        objHomePageFour.numberOfNewOrder("3423423423");
    }
    // Закрыть браузер
    @After
    public void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }
}