package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static constants.MobileTestingConstants.*;

class TestProperties {
    private Properties currentProps = new Properties();

    private Properties getCurrentProps() throws IOException{
        FileInputStream in = new FileInputStream(System.getProperty(USER_DIR)+PROPERTIES_PATH);
        currentProps.load(in);
        in.close();
        return currentProps;
    }

     String getProp(String propKey) throws IOException{
        if(!currentProps.containsKey(propKey)) currentProps = getCurrentProps();
        return currentProps.getProperty(propKey, null);
    }
}
