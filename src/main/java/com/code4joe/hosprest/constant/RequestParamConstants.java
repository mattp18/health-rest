package com.code4joe.hosprest.constant;

public class RequestParamConstants {

    /**
     * Constants to be used for external rest api call
     */
    public static final String SOURCE = "source";
    public static final String PERIOD = "period";
    public static final String SORT = "sort";
    public static final String SORT_DIR = "sort_dir";
    public static final String USER_HISTORIES = "user_histories";

    private RequestParamConstants() {
        throw new AssertionError("Non Instantiable");
    }
}
