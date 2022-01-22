package ru.gb.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChooseProduct {
    public static void main(String[] args) throws InterruptedException {

        //чтобы съэкономить ресурсы настроим браузер (чтобы не загружались картинки)
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");


        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create(); //- заменяет строки ниже

        //неявное ожидание
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get("https://pop-music.ru/");
        // размер окна
        webDriver.manage().window().setSize(new Dimension(1300, 720));

        //создаем действие - Навести курсор на элемент
        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//ul[@data-type='header']/li/a[text()='Гитары']")))
                .build()
                .perform();

        webDriver.findElement(By.xpath("//li[contains(@class, 'is-hover')]//a[text()='Акустические бас-гитары']")).click();

        List<WebElement> products = webDriver.findElements(By.xpath("//div[contains(@class, 'product-card ')]"));

        products.get(1).findElement(By.xpath("//div[contains(@class,'product-card__btn')]")).click();

        new WebDriverWait(webDriver, 4)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Перейти в корзину')]")))
                .click();

        System.out.println("Actual cart size = " + webDriver.findElements(By.xpath("//div[contains(@class, 'cart-table__row js-product')]")).size());
        System.out.println("Expected cart size = 1");
        webDriver.quit();
    }
}
