package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class I18NManagerTest {

    //Import log4j file and  use log4j
    final static Logger log = Logger.getLogger(I18NManagerTest.class.getName());

    //Let's instantiate the class I18NManager
    I18NManager i18n;

    @Before
    public void setUp(){
        i18n = I18NManager.getInstance();
    }

    @After
    public void tearDown(){
        i18n = null;
    }

    //Test the catalan file
    @Test
    public void testFileCatalan(){
        try {
            String datal1 = i18n.getString("ca", "l1");
            assertEquals("Hola", datal1);
            String datal2 = i18n.getString("ca", "l2");
            assertEquals("Adeu", datal2);
        }
        catch(Exception e){
            log.warn("The file doesn't exist!! : " +e.getMessage());
        }
    }

    //Test the catalan file
    @Test
    public void testFileSpanish(){
        try {
            String datal1 = i18n.getString("es", "l1");
            assertEquals("Hola", datal1);
            String datal2 = i18n.getString("es", "l2");
            assertEquals("Adios", datal2);
        }
        catch(Exception e){
            log.warn("The file doesn't exist!! : " +e.getMessage());
        }
    }

    //Test the english file
    @Test
    public void testFileEnglish(){
        try {
            String datal1 = i18n.getString("en", "l1");
            assertEquals("Hello", datal1);
            String datal2 = i18n.getString("en", "l2");
            assertEquals("Bye", datal2);
        }
        catch(Exception e){
            log.warn("The file doesn't exist!! : " +e.getMessage());
        }
    }
}
