package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.ResourceBundle;

public class I18NManager {
    final static Logger log = Logger.getLogger(I18NManager.class.getName());


    //Let's declare the one and unique one instance
    private static I18NManager instance;

    //Now we can declare as many as variables we want, but with the condition that they has to be private
    //In our case we can declare the hashmap that contains the different languages that contains different words for each one
    private HashMap<String, ResourceBundle> languages;

    //Let's declare its private constructor
    private I18NManager(){
        languages = new HashMap<String, ResourceBundle>();
    }

    //Let's get the instance. If the instance is null, we declare one
    public static I18NManager getInstance(){
        if(instance == null) instance = new I18NManager();
        return instance;
    }

    //Let's declare the public non-static methods
    //In this case we are going to declare a method that add into the hashmap the values of the properties files
    public String getString (String filename, String key) throws Exception{
        //Let's see if the file exists
        ResourceBundle rbundle = languages.get(filename);

        if (rbundle ==null ) {
            log.info ("Vaig al sistema de fitxers");
            rbundle = ResourceBundle.getBundle(filename);
            languages.put(filename, rbundle);
        }
        else {
            log.info("Utilitzem el bundle que hi ha a cache!");
        }

        return rbundle.getString(key);
    }

}
