package com.code4joe.hosprest.constant;

/**
 * This class holds all constants used by the operations available to the ADMIN.
 *
 * @author Matthew Puentes
 * @version 1.0
 * @since 1.0
 */
public class ControllerConstants {

    /**
     * Controller View Names.
     */
    public static final String INDEX_VIEW_NAME = "index";
    public static final String INDEX_URL_MAPPING = "/";

    private ControllerConstants() {
        throw new AssertionError("Non Instantiable");
    }
}
