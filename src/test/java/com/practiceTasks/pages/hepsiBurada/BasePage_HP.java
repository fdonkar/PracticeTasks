package com.practiceTasks.pages.hepsiBurada;

import com.practiceTasks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage_HP {

    public BasePage_HP(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//input[@class='desktopOldAutosuggestTheme-input']")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='SearchBoxOld-buttonContainer']")
    public WebElement searchButton;

    @FindBy(id = "shoppingCart")
    public WebElement myCart;
}
