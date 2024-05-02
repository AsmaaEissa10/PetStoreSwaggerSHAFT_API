package apis;

import com.shaft.driver.SHAFT;

public class BaseApis {
    /**
     Variables
     **/
    private SHAFT.API api;

    /**
     Constructor
     **/
    public BaseApis (SHAFT.API api) {this.api = api;}

    /**
     Base URL
     **/
    public static String ApisBaseUrl = System.getProperty("baseUrl");

    /**
     Status Codes
     **/
    public static final int SUCCESS = 200;
}
