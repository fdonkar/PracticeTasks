package com.practiceTasks.pages.hepsiBurada;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage_HP extends BasePage_HP{

    @FindBy(id = "myAccount")
    public WebElement myAccount;

    @FindBy(id = "login")
    public WebElement loginButton;

    @FindBy(id = "txtUserName")
    public WebElement usernameInputBox;

    @FindBy(id = "btnLogin")
    public WebElement loginButtonTwo;

    @FindBy(id = "txtPassword")
    public WebElement passwordInputBox;

    @FindBy(id = "btnEmailSelect")
    public WebElement loginButtonThree;


}
