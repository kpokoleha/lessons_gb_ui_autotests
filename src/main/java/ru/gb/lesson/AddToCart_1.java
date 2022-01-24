package ru.gb.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AddToCart_1 {
    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get("https://top3dshop.ru/");
        webDriver.manage().window().setSize(new Dimension(1050, 708));

        webDriver.findElement(By.xpath("//div[@class='h-second__auth authorization-link']//a[contains(text(),'Войти')]"))
                .click();
        webDriver.findElement(By.xpath("//div[contains(@class,'modal__content')]//input[@placeholder='Электронная почта']"))
                .sendKeys("rudolf@mail.ru");
        webDriver.findElement(By.xpath("//div[contains(@class,'modal__content')]//input[@placeholder='Пароль']"))
                .sendKeys("Qwerty123");
        webDriver.findElement(By.xpath("//button[contains(text(),'Войти')]"))
                .click();


        webDriver.findElement(By.xpath("//div[@id=\"contentMainWrap\"]//a[@title='3D принтеры']"))
                .click();
        new WebDriverWait(webDriver,12).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-product-id=\"7149\"]")));
        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//div[@data-product-id=\"7149\"]")))
                .build()
                .perform();

        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-product-id='7149']//div[@class='c-goods__links']//div[@class='c-goods__buy--button']")))
                .click();

        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'modal-cart-added__button')]//a[contains(text(),'Перейти к оформлению')]")))
                .click();


        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='simplecheckout_cart']//a[text()='3D принтер Picaso Designer X Pro']")));
        System.out.println("3D принтер \"Picaso Designer X Pro\" добавлен в корзину");
        webDriver.quit();
    }
}
