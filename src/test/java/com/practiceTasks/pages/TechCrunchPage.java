package com.practiceTasks.pages;

import com.practiceTasks.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TechCrunchPage {

    public TechCrunchPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = ".article__title")
    public WebElement titleOfArticle;

    public boolean hasAuthor() {
        int numberOfNews = Driver.get().findElements(By.xpath("//div[@class='river river--homepage ']//article")).size();
        for (int i = 1; i < numberOfNews; i++) {
            WebElement author = Driver.get().findElement(By.xpath("//div[@class='river river--homepage ']//article[" + i + "]//a[starts-with(@aria-label,'Posts by')]"));
            if (!author.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean hasImage(){
        int numberOfNews = Driver.get().findElements(By.xpath("//div[@class='river river--homepage ']//article")).size();
        for (int i = 1; i < numberOfNews; i++) {
            WebElement img = Driver.get().findElement(By.xpath("//div[@class='river river--homepage ']//article["+i+"]//img"));
            if (!img.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public void clickOnALatestNews(int num){
        Driver.get().findElement(By.xpath("//article["+num+"]//h2[@class='post-block__title']")).click();
    }

    public String getMeTitleOfPage(){
        String title = Driver.get().getTitle();
        String titleWithoutCrunch = title.substring(0,title.length()-13);
        return titleWithoutCrunch;
    }
}
