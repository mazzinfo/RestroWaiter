package org.mazz.restrowaiter.Util;

import org.mazz.restrowaiter.Builder.RetrofitApiBuilder;
import org.mazz.restrowaiter.Service.RestApiService;

public class RestApiUtil {

    private static final String BASE_URL = "http://192.168.1.3:8080/";

    public static RestApiService getServiceClass(){
        return RetrofitApiBuilder.getRetrofit(BASE_URL).create(RestApiService.class);
    }
}
