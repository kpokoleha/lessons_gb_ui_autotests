package ru.gb.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyLoginAndLogout {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        webDriver.get("https://top3dshop.ru/");
        webDriver.manage().window().setSize(new Dimension(1050, 708));

        webDriver.findElement(By.xpath("//div[@class='h-second__auth authorization-link']//a[contains(text(),'Войти')]")).click();
        webDriver.findElement(By.xpath("//div[contains(@class,'modal__content')]//input[@placeholder='Электронная почта']")).sendKeys("rudolf@mail.ru");
        webDriver.findElement(By.xpath("//div[contains(@class,'modal__content')]//input[@placeholder='Пароль']")).sendKeys("Qwerty123");
        webDriver.findElement(By.xpath("//button[contains(text(),'Войти')]")).click();

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'h-second__auth')]//a[contains(text(),'Профиль')]")));
        webDriver.findElement(By.xpath("//div[contains(@class,'h-second__auth')]//a[contains(text(),'Профиль')]")).click();
        webDriver.findElement(By.xpath("//a[contains(text(),'Выйти')]")).click();

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='h-second']//a[contains(text(),'Войти')]")));
        webDriver.quit();
    }

}
