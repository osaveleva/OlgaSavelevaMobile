package constants;

public enum MobileTestingConstants {
    BROWSERCHROME("chrome"),
    BROWSERSAFARI("Safari"),
    USER_DIR("user.dir"),
    PROPERTIES_PATH("/src/main/resources/"),
    EXPECTED_TITLE("Internet Assigned Numbers Authority"),
    PASSWORD("123456"),
    APPPACKAGE("appPackage"),
    APPACTIVITY("appActivity");

    public String record;

    MobileTestingConstants(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }
}
