package WEaretests.enums;

public enum WEAreTestData {
    STANDARD_USER_USERNAME("simeon"),
    STANDARD_USER_PASSWORD("Test123456"),
    NEW_POST_MESSAGE("New amazing Comment with Selenium");

    WEAreTestData(String propName) {
        value = propName;
    }

    public String getValue() {
        return value;
    }

    final String value;
}