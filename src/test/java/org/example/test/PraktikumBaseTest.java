package org.example.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

// Класс с автотестом
public class PraktikumBaseTest {
    WebDriver driver;
    @Before
    public void startUp() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

//        FirefoxOptions options = new FirefoxOptions();
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver(options);
//        // переход на страницу тестового приложения
//        driver.get("https://qa-scooter.praktikum-services.ru/");

    }
    // Закрыть браузер
    @After
    public void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }
}