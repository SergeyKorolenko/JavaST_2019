package by.korolenko.adsdesk.controller.manager;

import java.util.ResourceBundle;

public final class PagePathManager {

    private static final ResourceBundle RESOURCE_BUNDLE =
            ResourceBundle.getBundle("path");

    public static String getProperty(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
