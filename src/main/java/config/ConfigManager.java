package config;

import enums.Environment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    public static final Properties properties = new Properties();

    static {
        loadProperties();
    }


    private static void loadProperties(){

        try {
            FileInputStream baseConfig = new FileInputStream("src/main/resources/config/config.properties");
            properties.load(baseConfig);
            baseConfig.close();

            Environment env = Environment.valueOf(properties.getProperty("env").toUpperCase());
            String envConfigPath = "src/main/resources/config/"+env.name().toLowerCase()+"-config.properties";

            FileInputStream envConfig = new FileInputStream(envConfigPath);
            properties.load(envConfig);
            envConfig.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
    public static void printProperty(String key){
        System.out.println(properties.getProperty(key));
    }

    public static void main(String[] args) {
        printProperty("env");
        printProperty("browser");
        printProperty("waitInSeconds");
        printProperty("timeout");
    }
}
