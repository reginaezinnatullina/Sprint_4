package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;
    private By name = By.xpath(".//input[@placeholder='* Имя']");
    private By lastName = By.xpath(".//*[@placeholder='* Фамилия']");
    private By adress = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");
    private By stationMetro = By.xpath(".//input[@placeholder='* Станция метро']");
    private By phone = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");
    private By signInButton =  By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setUsername(String username) {
        driver.findElement(name).sendKeys(username);
    }

    public void setUserLastName(String userlastname) {
        driver.findElement(lastName).sendKeys(userlastname);
    }
    private void setStationMetro(String userstationmetro){
        driver.findElement(stationMetro).click();
        driver.findElement(stationMetro).sendKeys(userstationmetro);
        driver.findElement(stationMetro).sendKeys(Keys.DOWN,Keys.ENTER);
    }

    public void setAdress(String adressname) {
        driver.findElement(adress).sendKeys(adressname);
    }

    public void setPhone(String phonename) {
        driver.findElement(phone).sendKeys(phonename);
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void login(String username, String userlastname, String userstationmetro, String adressname, String phonename) {
        setUsername(username);
        setUserLastName(userlastname);
        setStationMetro(userstationmetro);
        setAdress(adressname);
        setPhone(phonename);
        clickSignInButton();
    }
}
