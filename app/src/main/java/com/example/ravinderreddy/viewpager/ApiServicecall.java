package com.example.ravinderreddy.viewpager;

import com.google.gson.JsonObject;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Ravinder Reddy on 22-07-2017.
 */

public interface ApiServicecall {
   @GET("/first.php/countries")
   public void getData(Callback<JsonObject>  jsonObjectCallback);
}
