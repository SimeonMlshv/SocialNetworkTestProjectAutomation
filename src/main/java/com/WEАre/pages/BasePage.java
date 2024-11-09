package com.WEАre.pages;

import testframework.PropertiesManager;
import testframework.core.BaseWebPage;

public class BasePage extends BaseWebPage {

    //тук си викаме метода за базовия URL
    public BasePage(String pageSpecificUrl) {
        super(pageSpecificUrl);

    }
    @Override
    public String getBasePageUrl() {
        return PropertiesManager.getConfigProperties().getProperty("WEAreBaseUrl");
    }
}
