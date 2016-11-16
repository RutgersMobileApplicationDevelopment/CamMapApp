package com.rumad.cammapapp.cammapapp.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;


public interface CampMapService {

    @POST("register")
    Call<ResponseBody> register(@Field("username") String username, @Field("password") String password, @Field("email") String email);

}
