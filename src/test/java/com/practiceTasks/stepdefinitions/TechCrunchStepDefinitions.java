package com.practiceTasks.stepdefinitions;

import com.practiceTasks.pages.TechCrunchPage;
import com.practiceTasks.utilities.ConfigurationReader;
import com.practiceTasks.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class TechCrunchStepDefinitions {

    TechCrunchPage techCrunch = new TechCrunchPage();

    @Given("User is on the homepage")
    public void user_is_on_the_homepage() {
        Driver.get().get(ConfigurationReader.get("tech_url"));
    }

    @Then("Each news has an author")
    public void each_news_has_an_author() {
        System.out.println("techCrunch.hasAuthor() = " + techCrunch.hasAuthor());
        Assert.assertTrue(techCrunch.hasAuthor());
    }

    @Then("Each news has an image")
    public void each_news_has_an_image() {
        System.out.println("techCrunch.hasImage() = " + techCrunch.hasImage());
        Assert.assertTrue(techCrunch.hasImage());
    }

    @When("User clicks on a latest news with index number {int}")
    public void user_clicks_on_a_latest_news_with_index_number(int indexOfNews) {
        techCrunch.clickOnALatestNews(indexOfNews);
    }

    @Then("Verify that the title of the page is same with the news title")
    public void verify_that_the_title_of_the_page_is_same_with_the_news_title() {
        String titleOfThePage = techCrunch.getMeTitleOfPage();
        String titleOfTheNews = techCrunch.titleOfArticle.getText();
        Assert.assertEquals("Title of the page is NOT matched with title of the article",titleOfTheNews,titleOfThePage);
    }
}
