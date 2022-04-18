package com.practiceTasks.pages.hepsiBurada;

import com.practiceTasks.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage_HP extends BasePage_HP{

    public List<String> getRecentViewedText(){
        List<String> textsOfRecentViewed = new ArrayList<>();
        List<WebElement> elementList = new ArrayList<>();

        elementList = Driver.get().findElements(By.xpath("//div[@class='reco_item_1QNpI reco-index-1']//span[@class='sf-reco-kmsjIo cRJH s126n0w16rp']"));

        for (WebElement element : elementList) {
            textsOfRecentViewed.add(element.getText());
        }

        return textsOfRecentViewed;
    }
}
