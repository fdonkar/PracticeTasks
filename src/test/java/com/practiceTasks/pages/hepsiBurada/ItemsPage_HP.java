package com.practiceTasks.pages.hepsiBurada;

import com.practiceTasks.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemsPage_HP extends BasePage_HP{

    @FindBy(id = "product-name")
    public WebElement itemName;

    public WebElement findItem(int index){
        WebElement item = Driver.get().findElement(By.xpath("(//div[@data-test-id='product-info-wrapper'])[" + index + "]"));
        return item;
    }

    public String getTextOfItem(int index){
        WebElement element = Driver.get().findElement(By.xpath("(//h3)[" + index + "]"));
        return element.getText();
    }
}
