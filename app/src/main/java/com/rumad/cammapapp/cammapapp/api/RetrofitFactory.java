package com.rumad.cammapapp.cammapapp.api;

import retrofit2.Retrofit;

/**
 * Created by shreyashirday on 10/11/16.
 */
public class RetrofitFactory {

    private final static String BASE_URL = "http://localhost:3000/";

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofit;
    }

}