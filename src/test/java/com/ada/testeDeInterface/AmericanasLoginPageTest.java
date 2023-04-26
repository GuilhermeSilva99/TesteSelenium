package com.ada.testeDeInterface;

import com.ada.testeDeInterface.pages.AmericanasLoginPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class AmericanasLoginPageTest {
    ChromeDriver chrome;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "/home/guilherme/Documentos/selenium/chromedriver_linux64/chromedriver");
    }

    @BeforeEach
    public void beforeEach(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        chrome = new ChromeDriver(options);
    }

    @Test
    public void testeLoginFalha(){
        AmericanasLoginPage page = new AmericanasLoginPage(chrome);
        WebDriverWait wait = new WebDriverWait(chrome,Duration.ofMillis(10000));
//         presenceOfElementLocated condition
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/main/div/div[2]/div/form/div[1]/div/label/div[2]/input")));

        //dados incorretos, só pra não divulgar dados pessoais
        page.enterEmail("batata@gmail.com");
        page.enterPassword("batatfrita123");
        page.getButtonLogin();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/main/div/div[2]/div[1]/div/div")));
        String resultado = chrome.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div[1]/div/div")).getText();
        String esperado = "E-mail ou senha incorretos";

        assertEquals(esperado, resultado);
    }

}
