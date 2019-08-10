package setup;

import constants.PropertyFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static constants.MobileTestingConstants.*;

class TestProperties {
    private String currentPropertyFile;
    private Properties currentProps = new Properties();

    protected void setpropertyFile(PropertyFile propertyFile) {
        currentPropertyFile = propertyFile.getName();
    }

    private Properties getCurrentProps() throws IOException {
        FileInputStream in = new FileInputStream(System.getProperty(USER_DIR.getRecord()) + PROPERTIES_PATH.getRecord() + currentPropertyFile);
        currentProps.load(in);
        in.close();
        return currentProps;
    }

    String getProp(String propKey) throws IOException {
        if (!currentProps.containsKey(propKey)) currentProps = getCurrentProps();
        return currentProps.getProperty(propKey, null);
    }
}
