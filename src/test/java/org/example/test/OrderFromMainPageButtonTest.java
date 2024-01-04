package org.example.test;

import org.example.page.HomePageMesto;
import org.example.page.OrderPage;
import org.example.page.RentPage;
import org.junit.Test;

public class OrderFromMainPageButtonTest extends PraktikumBaseTest {
    //Тест заказа через кнопку в заголовке (правый верхний угол)
    @Test
    public void checkActivityInHeader() {
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

    //Тест заказа через кнопку в середине страницы
    @Test
    public void checkActivityInMidle() {
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
}
