package com.practiceTasks.pages;

import com.practiceTasks.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TechCrunch {

    public TechCrunch() {
        PageFactory.initElements(Driver.get(), this);
    }

    public boolean hasAuthor() {
        int numberOfNews = Driver.get().findElements(By.xpath("//article")).size();
        for (int i = 1; i < numberOfNews; i++) {
            WebElement author = Driver.get().findElement(By.xpath("(//article)[" + i + "]//a[starts-with(@aria-label,'Posts by')]"));
            if (!author.isDisplayed()) {
                return false;
            }
            System.out.println("author.getText() = " + author.getText());
        }
        return true;
    }
}
