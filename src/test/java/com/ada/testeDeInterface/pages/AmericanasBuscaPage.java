package com.ada.testeDeInterface.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmericanasBuscaPage extends BasicPage{
    public AmericanasBuscaPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.americanas.com.br/");
    }

    public WebElement getCampoBusca(){
        return getPage().findElement(By.xpath("/html/body/div[1]/div/div/header/div[1]/div[1]/div/div[1]/form/input"));
    }
    public void setCampoBusca(String pesquisa){
        getCampoBusca().sendKeys(pesquisa);
        getCampoBusca().submit();
    }
}
