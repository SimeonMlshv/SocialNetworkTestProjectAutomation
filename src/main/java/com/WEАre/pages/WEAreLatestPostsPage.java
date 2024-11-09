package com.WEАre.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testframework.Driver;

public class WEAreLatestPostsPage extends WEAreBasePage{
    private final Driver driver;
    public WEAreLatestPostsPage(Driver driver) {
        super("/posts");
        this.driver = driver;
    }

    private final By latestPostsButtonLocator = By.xpath("//a[normalize-space()='Latest Posts']");
    private final By browsePublicPostsButtonLocator = By.xpath("/html/body/section[1]/div/div/div[2]/div[1]/form/input");
    private final By likePostButtonLocator = By.xpath("//input[@id='submit-val69']");

    public void clickLikeDislikePostButton() {
        WebElement latestPostButton = driver.findElement(latestPostsButtonLocator);
        latestPostButton.click();

        WebElement browsePublicPostsButton = driver().findElement(browsePublicPostsButtonLocator);
        browsePublicPostsButton.click();

        WebElement likePostButton = driver().findElement(likePostButtonLocator);
        likePostButton.click();

    }
}
