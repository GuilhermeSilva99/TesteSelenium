package com.ada.testeDeInterface;

import com.ada.testeDeInterface.pages.AmericanasBuscaPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class AmericanasBuscaPageTest {
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
    public void testeBuscaBasica() {
        AmericanasBuscaPage page = new AmericanasBuscaPage(chrome);
        page.setCampoBusca("capacete");
        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofMillis(10000));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/main/div/div[1]/h1")));
        String resultado = chrome.findElement(By.xpath("/html/body/div/div/div/main/div/div[1]/h1")).getText();
        String esperado = "resultados para “capacete”";

        assertEquals(esperado, resultado);
    }

    @Test
    public void testeBuscaAvancada(){
        AmericanasBuscaPage page = new AmericanasBuscaPage(chrome);
        page.setCampoBusca("capacete");
        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofMillis(10000));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/main/div/div[2]/div[1]/div[5]/a[1]")));

        chrome.findElement(By.xpath("/html/body/div/div/div/main/div/div[2]/div[1]/div[5]/a[1]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/main/div/div[3]/div[1]/a[1]")));

        String freteGratis = chrome.findElement(By.xpath("/html/body/div/div/div/main/div/div[3]/div[1]/a[1]")).getText();
        String esperadoFrete = "frete grátis";

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/main/div/div[1]/h1")));
        String resultado = chrome.findElement(By.xpath("/html/body/div/div/div/main/div/div[1]/h1")).getText();
        String esperado = "resultados para “capacete”";

        assertEquals(esperado, resultado);
        assertEquals(esperadoFrete, freteGratis);
    }
}