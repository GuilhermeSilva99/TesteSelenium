package com.ada.testeDeInterface.pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GoogleTests {
    @Test
    void teste(){
//        System.setProperty("webdriver.chrome.driver", "/opt/google/chrome/chrome");
        System.setProperty("webdriver.chrome.driver", "/home/guilherme/Documentos/selenium/chromedriver_linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver chromeDriver = new ChromeDriver(options);

        chromeDriver.get("http:www.google.com");

    }
}
