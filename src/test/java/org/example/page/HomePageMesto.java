package org.example.page;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;

        import static org.junit.Assert.assertEquals;
        import org.openqa.selenium.JavascriptExecutor;

        import java.time.Duration;

// Класс главной страницы
public class HomePageMesto {
    private static WebDriver driver;
    // создай локатор на кнопку куки
    private final By cookieButton = By.id("rcc-confirm-button");
    // создай локатор для нажатия на кнопку "заказать" в заголовке
    private By profileForSaveInHeader = By.className("Button_Button__ra12g");
    // создай локатор для нажатия на кнопку "заказать" в середине
    private By profileForSaveInMiddle = By.className("Button_Middle__1CSJM");
    // локатор для кнопки "статус заказа"
    private By checkButtonStatusOrder = By.className("Header_Link__1TAG7");
    // локатор для поля номера заказа
    private By checkNumberOfOrder = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");
    //локатор для проверки введенного номера заказа
    private By checkButtonGo = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']");
    public HomePageMesto(WebDriver driver) {
        this.driver = driver;
    }
    public HomePageMesto clickCookieButton() {
        driver.findElement(cookieButton).click();
        return this;
    }
    public void clickEditProfileButtonInHeader() {
        driver.findElement(profileForSaveInHeader).click();
    }
    public void clickEditProfileButtonInMiddle() {
        driver.findElement(profileForSaveInMiddle).click();
    }
    // Массив локаторов из списка с текстом вопросов
    private static final String[] dropDownQuestionsArray = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};

    // Массив локаторов из списка с текстом ответов
    private static final String[] dropDownAnswersArray = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};
    // Прокрутка главной страницы до последнего элемента списка
    public void scrollToQuestions(){
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Клик по стрелке выпадающего списка
    public static void clickQuestion(int questionNumber) {
        driver.findElement(By.id(dropDownQuestionsArray[questionNumber])).click();
    }

    // Проверка текста в открытой панели
    public static void checkTextInOpenPanel(String expectedText, int answerNumber) {
        String answerText = driver.findElement(By.id(dropDownAnswersArray[answerNumber])).getText();
        assertEquals(expectedText, answerText);
    }
    /** Клик по кнопке вопроса */
    public HomePageMesto clickQuestionButton(String questionButtonLocator) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id(questionButtonLocator)).click();
        return this;
    }
    // Клик по кнопке "Статус заказа"
    public void clickButtonOrder(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(checkButtonStatusOrder).click();
    }
    // введение номера проверяемого заказа
    public void clickNumberOrder(String numberOfOrder){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(checkNumberOfOrder).sendKeys(numberOfOrder);
    }
    // клик по кнопке GO
    public void clickButtonGo(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(checkButtonGo).click();
    }

    public void numberOfNewOrder(String numberOfOrder){
        clickButtonOrder();
        clickNumberOrder(numberOfOrder);
        clickButtonGo();
    }
}
