package com.practiceTasks.stepdefinitions;

import com.practiceTasks.pages.hepsiBurada.CartPage_HP;
import com.practiceTasks.pages.hepsiBurada.ItemsPage_HP;
import com.practiceTasks.pages.hepsiBurada.LoginPage_HP;
import com.practiceTasks.utilities.BrowserUtils;
import com.practiceTasks.utilities.ConfigurationReader;
import com.practiceTasks.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class HepsiBurada {

    ItemsPage_HP itemsPage_hp = new ItemsPage_HP();
    List<String> viewedItems = new ArrayList<>();

    @Given("User is on the login page of HepsiBurada")
    public void user_is_on_the_login_page_of_hepsi_burada() {
        Driver.get().get(ConfigurationReader.get("hepsiburada_url"));
    }

    @Given("User logins with valid credentials")
    public void user_logins_with_valid_credentials() {
        LoginPage_HP loginPage_hp = new LoginPage_HP();
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(loginPage_hp.myAccount).perform();
        loginPage_hp.loginButton.click();
        loginPage_hp.usernameInputBox.sendKeys(ConfigurationReader.get("hepsiburada_mail"));
        loginPage_hp.loginButtonTwo.click();
        loginPage_hp.passwordInputBox.sendKeys(ConfigurationReader.get("hepsiburada_password"));
        loginPage_hp.loginButtonThree.click();
    }

    @When("User searches {string} using search box")
    public void user_searches_using_search_box(String itemName) {
        itemsPage_hp.searchBox.sendKeys(itemName);
        itemsPage_hp.searchButton.click();
        BrowserUtils.waitForPageToLoad(5);
    }

    @When("User selects the {int} product on the page")
    public void user_selects_the_product_on_the_page(int indexOfItem) {
        itemsPage_hp.findItem(indexOfItem).click();
        for (String windowHandle : Driver.get().getWindowHandles()) {
            if (!windowHandle.equals(Driver.get().getWindowHandle())){
                Driver.get().switchTo().window(windowHandle);
            }
        }
        viewedItems.add(itemsPage_hp.itemName.getText());
    }

    @When("User navigates to the cart")
    public void user_navigates_to_the_cart() {
        itemsPage_hp.myCart.click();
    }

    @Then("User sees all viewed products under the Recently Viewed section")
    public void userSeesAllViewedProductsUnderTheRecentlyViewedSection() {
        CartPage_HP cartPage_hp = new CartPage_HP();
        List<String> recentViewed = cartPage_hp.getRecentViewedText();
        Assert.assertTrue(recentViewed.containsAll(viewedItems));
    }
}
