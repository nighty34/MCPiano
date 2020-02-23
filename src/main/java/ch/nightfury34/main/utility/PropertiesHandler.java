package ch.nightfury34.main.utility;

import java.io.*;
import java.util.Properties;

public class PropertiesHandler {
    private static final String FILEPATH = "plugin/mcPiano/combos.properties"; //TODO: Switchable Properties files

    private static PropertiesHandler instance;

    private Properties properties;

    public PropertiesHandler() throws IOException{
    }

    public static PropertiesHandler getInstance(){
        if(instance == null){
            try{
                instance = new PropertiesHandler();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return instance;
    }

    public String getEntry(String filepath, String charackter) throws IOException{
        Reader reader = new FileReader(filepath);
        properties = new Properties();
        properties.load(reader);

        return properties.getProperty(charackter);
    }




}
