package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Constructor {
    private final WebDriver driver;
    //Заголовок h1 главной страницы
    private final By mainH1 = By.xpath("//h1[text()='Соберите бургер']");
    //локаторы кнопок меню
    private final By linkBuns = By.xpath("//span[text()='Булки']");
    private final By linkSauces = By.xpath("//span[text()='Соусы']");
    private final By linkToppings = By.xpath("//span[text()='Начинки']");
    //локаторы заголовков разделов в меню
    private final By spanBuns = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    private final By spanSauces = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    private final By spanToppings = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");

    public Constructor(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadMainPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(mainH1));
    }

    //метод клика по кнопке "Булки"
    public void clickBunsLink() {
        driver.findElement(linkBuns).click();
    }

    //метод клика по кнопке "Соусы"
    public void clickSaucesLink() {
        driver.findElement(linkSauces).click();
    }

    //метод клика по кнопке "Начинки"
    public void clickToppingsLink() {
        driver.findElement(linkToppings).click();
    }

    public boolean bunsIsDisplayed() {
        return driver.findElement(spanBuns).isDisplayed();
    }

    public boolean saucesIsDisplayed() {
        return driver.findElement(spanSauces).isDisplayed();
    }

    public boolean toppingsIsDisplayed() {
        return driver.findElement(spanToppings).isDisplayed();
    }


}
