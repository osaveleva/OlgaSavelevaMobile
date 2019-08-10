package constants;

public enum PropertyFile {
    NATIVE("nativetests"), WEB("webtests");

    private String currentAppType;

    PropertyFile(String current) {
        this.currentAppType = current;
    }

    public String getName() {
        return currentAppType + ".properties";
    }

}
