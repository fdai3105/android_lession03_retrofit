package com.example.android_lession03_retrofit.utils;

import com.example.android_lession03_retrofit.retrofit.RetrofitClient;
import com.example.android_lession03_retrofit.service.SOService;

public class ApiUtils {
    public static final String BASE_URL = "https://api.stackexchange.com/2.2/";

    public static SOService getSOService() {
        return RetrofitClient.getRetrofit(BASE_URL).create(SOService.class);
    }
}
