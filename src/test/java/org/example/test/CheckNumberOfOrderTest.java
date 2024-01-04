package org.example.test;

import org.example.page.HomePageMesto;
import org.junit.Test;

public class CheckNumberOfOrderTest extends PraktikumBaseTest{
    @Test
    // Дополнительный тест на проверку несуществующего заказа
    public void CheckNumberOfOrder() {
        // создание объекта класса главной страницы приложения
        HomePageMesto objHomePage = new HomePageMesto(driver);
        // клик по кнопке проверки заказа, введение номера заказа и его проверка
        objHomePage.numberOfNewOrder("3423423423");
    }
}
