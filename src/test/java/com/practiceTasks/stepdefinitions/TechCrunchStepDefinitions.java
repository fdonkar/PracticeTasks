package com.practiceTasks.stepdefinitions;

import com.practiceTasks.pages.TechCrunch;
import com.practiceTasks.utilities.ConfigurationReader;
import com.practiceTasks.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class TechCrunchStepDefinitions {

    TechCrunch techCrunch = new TechCrunch();

    @Given("User is on the homepage")
    public void user_is_on_the_homepage() {
        Driver.get().get(ConfigurationReader.get("tech_url"));
    }
    @Then("Each news has an author")
    public void each_news_has_an_author() {
        Assert.assertTrue(techCrunch.hasAuthor());
    }
    @Then("Each news has an image")
    public void each_news_has_an_image() {

    }
}
