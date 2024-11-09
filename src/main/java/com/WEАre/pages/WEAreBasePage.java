package com.WEАre.pages;

import testframework.PropertiesManager;
import testframework.core.BaseWebPage;

public class WEAreBasePage extends BaseWebPage {

    //тук си викаме метода за базовия URL
    public WEAreBasePage(String pageSpecificUrl) {
        super(pageSpecificUrl);

    }
    @Override
    public String getBasePageUrl() {
        return PropertiesManager.getConfigProperties().getProperty("WEAreBaseUrl");
    }

}
