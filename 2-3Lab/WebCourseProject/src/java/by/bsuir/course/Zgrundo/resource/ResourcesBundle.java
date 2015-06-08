/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.Zgrundo.resource;

import java.util.ResourceBundle;

/**
 * This class is used to organaize work with property
 *
 * @author ko
 */
public class ResourcesBundle {

    private ResourceBundle bundle;
    /**
     * This parameter is used to work with property
     */
    public static final String CONNECTION_NUMBER = "CONNECTION_NUMBER";
    /**
     * This parameter is used to work with property
     */
    public static final String DRIVER = "DRIVER";
    /**
     * This parameter is used to work with property
     */
    public static final String DATABASE = "DATABASE";
    /**
     * This parameter is used to work with database property
     */
    public static final String dbProperties = "by.bsuir.course.Zgrundo.resource.database";

    public static final String pageProperties = "by.bsuir.course.Zgrundo.resource.page";
    public static final String TEST_PAGE_PATH = "TEST_PAGE_PATH";

    public static final String INDEX_PAGE_PATH = "INDEX_PAGE_PATH";
    public static final String DISH_PAGE_PATH = "DISH_PAGE_PATH";
    public static final String ONE_DISH_PAGE_PATH = "ONE_DISH_PAGE_PATH";
    public static final String FAVOURITE_PAGE_PATH = "FAVOURITE_PAGE_PATH";
    public static final String CABINET_PAGE_PATH = "CABINET_PAGE_PATH";
    public static final String INFO_PAGE_PATH = "INFO_PAGE_PATH";
    public static final String REGIST_PAGE_PATH = "REGIST_PAGE_PATH";

    /**
     * Constructor without parameters
     */
    public ResourcesBundle() {
        bundle = ResourceBundle.getBundle("by.bsuir.course.Zgrundo.resource."
                + "regrex");
    }

    /**
     * Constructor with parameters
     *
     * @param s - address of property
     */
    public ResourcesBundle(String s) {
        bundle = ResourceBundle.getBundle(s);
    }

    /**
     * This method is used to return information from property by key
     *
     * @param key - key witch help to find information in property
     * @return information from property by key
     */
    public String getValue(String key) {
        return bundle.getString(key);
    }

}
