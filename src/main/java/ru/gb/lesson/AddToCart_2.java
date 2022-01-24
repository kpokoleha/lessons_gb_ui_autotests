package ru.gb.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class AddToCart_2 {
    public static void main(String[] args)  {
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


        webDriver.findElement(By.xpath("//div[@class='covers-block__block ']//a[@title='3D сканеры']"))
                .click();
        webDriver.findElement(By.xpath("//img[@id='image_14950']"))
                .click();
        webDriver.findElement(By.xpath("//a[contains(@class,'link link__control product-info-button-cart add-to-cart')]"))
                .click();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class,'button-ckeckout')]")))
                .click();

        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='cart_block']//span[contains(text(),'товар')]")));

        System.out.println("Товар добавлен в корзину");
        webDriver.quit();
    }
}
