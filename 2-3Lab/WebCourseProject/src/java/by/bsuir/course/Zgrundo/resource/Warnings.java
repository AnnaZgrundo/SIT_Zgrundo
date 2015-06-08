/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.Zgrundo.resource;

import java.util.ResourceBundle;

/**
 * @author ko
 */
public class Warnings {
    private ResourceBundle bundle;
    
    public static final String USER_EXIST = "USER_EXIST";
    public static final String ERROR_PASS = "ERROR_PASS";
    public static final String FAV_EXIST = "FAV_EXIST";
    public static final String TRY_AGAIN = "TRY_AGAIN";
    public static final String WRONG_LOGIN = "WRONG_LOGIN";
    public static final String WRONG_PASSWORD = "WRONG_PASSWORD";
    
    
    
    /**
     * Constructor without parameters
     */
    public Warnings() {
        bundle = ResourceBundle.getBundle("by.bsuir.course.Zgrundo.resource."
                + "warnings");
    }
    
    /**
     * This method is used to return information from property by key
     * @param key - key witch help to find information in property
     * @return information from property by key
     */
    public String getValue(String key) {
        return bundle.getString(key);
    }
}
