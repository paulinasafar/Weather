package server.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import server.util.Json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigurationManager {

    private static ConfigurationManager myConfigManager;
    private static Configuration myCurrentConfiguration;

    private ConfigurationManager() {
    }

    public static ConfigurationManager getInstace() {
        if(myConfigManager == null) {
            myConfigManager = new ConfigurationManager();
        }
        return myConfigManager;
    }

    /**
     * Loads configuration file by the path provided
     * @param filePath
     */
    public void loadConfigFile(String filePath)  {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            throw new HttpConfigurationException(e);
        }

        StringBuffer sb = new StringBuffer();
        int i;
        while(true) {
            try {
                if (!((i = fileReader.read()) != -1)) break;
            } catch (IOException e) {
                throw new HttpConfigurationException(e);
            }
            sb.append((char)i);
        }
        JsonNode conf = null;
        try {
            conf = Json.parse(sb.toString());
        } catch (JsonProcessingException e) {
            throw new HttpConfigurationException("Error parsing configuration file: ", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            myCurrentConfiguration = Json.fromJson(conf, Configuration.class );
        } catch (JsonProcessingException e) {
            throw new HttpConfigurationException("Error parsing configuration file, internal: ", e);
        }
    }


    /**
     * returns the current loaded configuration
     */
    public Configuration getCurrentConfiguration() {

        if(myCurrentConfiguration == null) {
            throw new HttpConfigurationException("No current cofiguration set!");
        }
        return myCurrentConfiguration;
    }

}
