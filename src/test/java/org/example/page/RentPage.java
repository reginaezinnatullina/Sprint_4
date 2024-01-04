package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentPage {
    private WebDriver driver;
    private By datefororder = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By rentaldate = By.className("Dropdown-placeholder");
    private By rentaltime = By.xpath(".//*[contains(text(),'сутки')]");
    private By colorscooter = By.xpath(".//input[@id='black']");
    private By commentary = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By signInButtonTwo =  By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    private By signInYes =  By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да')]");
    private final By modalOrder = By.xpath(".//div[contains(@class, 'Order_ModalHeader')]");
    public boolean isModalOrderDisplayed() {
        return driver.findElement(modalOrder).isDisplayed();
    }
    public RentPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setDateForOrder(String userdatefororder){
        driver.findElement(datefororder).click();
        driver.findElement(datefororder).sendKeys(userdatefororder);
        driver.findElement(datefororder).sendKeys(Keys.DOWN,Keys.ENTER);
    }
    public void setRentaldate(){
        driver.findElement(rentaldate).click();
        driver.findElement(rentaltime).click();
    }
    public void setColorscooter(){
        driver.findElement(colorscooter).click();
    }
    public void setCommentary(String newcommentary){
        driver.findElement(commentary).sendKeys(newcommentary);
    }
    public void clickSignInButtonTwo() {
        driver.findElement(signInButtonTwo).click();
    }
    public void clickSignInYes() {
        driver.findElement(signInYes).click();
    }
    public void rentLogin(String userdatefororder, String newcommentary){
        setDateForOrder(userdatefororder);
        setRentaldate();
        setColorscooter();
        setCommentary(newcommentary);
        clickSignInButtonTwo();
        clickSignInYes();
        isModalOrderDisplayed();
    }

}
