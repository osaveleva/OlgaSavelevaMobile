package constants;

public enum MobileTestingConstants {
    BROWSERCHROME("chrome"),
    BROWSERSAFARI("Safari"),
    USER_DIR("user.dir"),
    PROPERTIES_PATH("/src/main/resources/test.properties"),
    SUT_TITLE("Internet Assigned Numbers Authority"),
    TITLE1("Set a Password"),
    TITLE2("Please provide a Password"),
    PASSWORD("123456"),

    APPACTIVITY("appActivity");

    public String record;

    MobileTestingConstants(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }
}
