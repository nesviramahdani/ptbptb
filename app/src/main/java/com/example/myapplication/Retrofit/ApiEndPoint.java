package com.example.myapplication.Retrofit;

import com.example.myapplication.Model.MainModel;
import com.example.myapplication.Model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndPoint {
    @GET("index")
    Call<MainModel> getData();

    @FormUrlEncoded
    @POST("login")
    Call<User> loginRequest(@Field("email") String email,
                            @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<User> registerRequest(@Field("name") String name,
                                       @Field("email") String email,
                                       @Field("password") String password);

    @GET("show")
    Call<MainModel> getHistory();


}
