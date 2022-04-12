package com.practiceTasks.pages;

import com.practiceTasks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MoneyGamingSignUpPage {

    public MoneyGamingSignUpPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//a[@class='newUser green']")
    public WebElement joinNow;

    @FindBy(xpath = "//select[@name='map(title)']")
    public WebElement title;

    @FindBy(xpath = "//input[@name='map(firstName)']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='map(lastName)']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='map(terms)']")
    public WebElement termsCheckbox;

    @FindBy(id = "form")
    public WebElement joinNowSubmit;

    @FindBy(xpath = "//label[@for='dob']")
    public WebElement errorMessageOfDob;

    @FindBy(xpath = "//label[@for='map(lastName)']")
    public WebElement errorMessageOfLastName;



    public void selectTitle(String value){
        Select select = new Select(title);
        select.selectByValue(value);
    }

}
