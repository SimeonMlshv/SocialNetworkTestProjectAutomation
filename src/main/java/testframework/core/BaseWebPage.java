package testframework.core;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testframework.Driver;
import testframework.DriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseWebPage {
    private final String pageUrl;

    public abstract String getBasePageUrl();

    public BaseWebPage(String pageSpecificUrl) {
        pageUrl = pageSpecificUrl;
    }

    protected Driver driver() {
        return DriverManager.getDriver();
    }

    protected WebDriverWait driverWait() {
        return driver().getDriverWait();
    }

    public String getPageUrl() {
        return getBasePageUrl() + pageUrl;
    }

    // Actions
    public void navigate() {
        driver().get(getPageUrl());
    }

    public void assertNavigated() {
        Assertions.assertEquals(getPageUrl(), driver().getCurrentUrl(), "Page was not navigated.");
    }
}