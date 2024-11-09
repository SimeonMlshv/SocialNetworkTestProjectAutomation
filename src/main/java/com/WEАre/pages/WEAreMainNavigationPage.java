package com.WEАre.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WEAreMainNavigationPage extends WEAreBasePage {
    public WEAreMainNavigationPage() {
        super("/");
    }
    private final By addNewPostButtonLocator = By.xpath("//*[@id=\"ftco-nav\"]/ul/li[8]/a");
    private final By messageFieldLocator = By.id("message");
    private final By savePostButtonLocator =
            By.xpath("/html/body/section[1]/div/div/div/div/ul/div/form/div[3]/input");


    public void submitMessageToANewPost(String message) {
        WebElement addNewPostButton = driver().findElement(addNewPostButtonLocator);
        addNewPostButton.click();

        WebElement messageField = driver().findElement(messageFieldLocator);
        messageField.sendKeys(message);

        WebElement savePostButton = driver().findElement(savePostButtonLocator);
        savePostButton.click();
    }
}
