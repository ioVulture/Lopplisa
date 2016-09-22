/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ioVulture
 */
public class PropertiesHandler {

    Properties prop = new Properties();
    InputStream input = null;
    public String getPropertyValue(String property) {
        
        try {
            input = new FileInputStream("config/lopplisa.properties");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertiesHandler.class.getName()).log(Level.SEVERE, "Kunde inte läsa in properties filen", ex);
        }
        try {
            prop.load(input);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesHandler.class.getName()).log(Level.SEVERE, "Kunde inte ladda in properties filen", ex);
        }
        return prop.getProperty(property);
        
        
    }
}
