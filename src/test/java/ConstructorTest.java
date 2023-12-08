import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Constructor;

public class ConstructorTest {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    @DisplayName("Раздел «Конструктор» - переход в «Булки»")
    @Description("Проверка, что работает переход к разделу: «Булки»")
    public void jumpToBuns() {
        Constructor objConstructor = new Constructor(driver);
        //ждем загрузки главной страницы
        objConstructor.waitForLoadMainPage();

        //клик на «Соусы»
        objConstructor.clickSaucesLink();

        //клик на «Булки»
        objConstructor.clickBunsLink();

//        String finishText = objConstructor.bunsText();
        Assert.assertTrue(objConstructor.bunsIsDisplayed());

    }

    @Test
    @DisplayName("Раздел «Конструктор» - переход в «Соусы»")
    @Description("Проверка, что работает переход к разделу: «Соусы»")
    public void jumpToSauces() {
        Constructor objConstructor = new Constructor(driver);
        //ждем загрузки главной страницы
        objConstructor.waitForLoadMainPage();

        //клик на «Соусы»
        objConstructor.clickSaucesLink();

        //String finishText = objConstructor.saucesText();
        Assert.assertTrue(objConstructor.saucesIsDisplayed());
    }

    @Test
    @DisplayName("Раздел «Конструктор» - переход в «Начинки»")
    @Description("Проверка, что работает переход к разделу: «Начинки»")
    public void jumpToToppings() {
        Constructor objConstructor = new Constructor(driver);
        //ждем загрузки главной страницы
        objConstructor.waitForLoadMainPage();

        //клик на «Начинки»
        objConstructor.clickToppingsLink();

        //String finishText = objConstructor.toppingsText();
        Assert.assertTrue(objConstructor.toppingsIsDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
