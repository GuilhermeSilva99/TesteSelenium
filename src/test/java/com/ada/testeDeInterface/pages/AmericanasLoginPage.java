package com.ada.testeDeInterface.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmericanasLoginPage extends BasicPage{
    public AmericanasLoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://cliente.americanas.com.br/minha-conta/entrar?next=https://www.americanas.com.br/");
    }
    public WebElement getEmail() {
        return getPage().findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/form/div[1]/div/label/div[2]/input"));
    }
    public WebElement getPassword() {
        return getPage().findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/form/div[2]/div/label/div[2]/input"));
    }

    public WebElement getButtonLogin() {
        return getPage().findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/form/div[4]/button"));
    }

    public void login(String email, String password) {
        enterEmail(email);

        enterPassword(password);
    }

    public void enterEmail(String email){
        getEmail().sendKeys(email);
    }

    public void enterPassword(String pwd){
        getPassword().sendKeys(pwd);
        getButtonLogin().click();
    }

}
