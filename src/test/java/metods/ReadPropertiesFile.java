package metods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadPropertiesFile {

    private String username;
    private String password;
    private String api_key;
    private String list_id;

    public String getList_id() {
        return list_id;
    }

    public void setList_id(final String list_id) {
        this.list_id = list_id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(final String api_key) {
        this.api_key = api_key;
    }


    public ReadPropertiesFile() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        setApi_key(prop.getProperty("api_key"));
        setUsername(prop.getProperty("username"));
        setPassword(prop.getProperty("password"));
        setList_id(prop.getProperty("list_id"));

    }

}
