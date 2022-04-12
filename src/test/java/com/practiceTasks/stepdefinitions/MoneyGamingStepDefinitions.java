package com.practiceTasks.stepdefinitions;

import com.practiceTasks.pages.MoneyGamingSignUpPage;
import com.practiceTasks.utilities.ConfigurationReader;
import com.practiceTasks.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class MoneyGamingStepDefinitions {

    MoneyGamingSignUpPage moneyGaming = new MoneyGamingSignUpPage();

    @Given("User navigates to the main page")
    public void user_navigates_to_the_main_page() {
        Driver.get().get(ConfigurationReader.get("moneygaming_url"));
    }

    @Given("User clicks on the join now button to open registration page")
    public void user_clicks_on_the_join_now_button_to_open_registration_page() {
        moneyGaming.joinNow.click();
    }

    @When("User selects a title")
    public void user_selects_a_title() {
        moneyGaming.selectTitle("Mr");
    }

    @When("User enters first name and last name")
    public void user_enters_first_name_and_last_name() {
        moneyGaming.firstName.sendKeys("Joe");
        moneyGaming.lastName.sendKeys("Tricky");
    }

    @When("User clicks on checkbox to accept terms and conditions")
    public void user_clicks_on_checkbox_to_accept_terms_and_conditions() {
        moneyGaming.termsCheckbox.click();
    }
    @When("User clicks on join now button to submit the form")
    public void user_clicks_on_join_now_button_to_submit_the_form() {
        moneyGaming.joinNowSubmit.click();
    }
    @Then("This field is required message should be displayed under the date of birth box")
    public void this_field_is_required_message_should_be_displayed_under_the_date_of_birth_box() {
        Assert.assertTrue(moneyGaming.errorMessageOfDob.isDisplayed());
    }
}
