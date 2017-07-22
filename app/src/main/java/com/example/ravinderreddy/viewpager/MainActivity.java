package com.example.ravinderreddy.viewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerAdapter  viewPagerAdapter;
    private static final String Root_url = "http://wptrafficanalyzer.in/p/demo1/";
      List<Model> stringList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.pager);
        apiCall();
        }

    private void apiCall() {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(Root_url).build();
        ApiServicecall apiServicecall = adapter.create(ApiServicecall.class);
        apiServicecall.getData(new Callback<JsonObject>() {
            @Override
            public void success(JsonObject jsonObject , Response response) {
                Log.d("response",jsonObject.toString());
                JsonObject jsonObject1=jsonObject.getAsJsonObject();
               JsonArray jsonArray= jsonObject1.get("countries").getAsJsonArray();
                for (int i = 0; i < jsonArray.size(); i++) {
                    JsonObject jsonObject2=jsonArray.get(i).getAsJsonObject();
                    String image=jsonObject2.get("flag").getAsString();
                    Model model=new Model();
                    model.setImage(image);
                    stringList.add(model);
                    
                }

                viewPagerAdapter = new ViewPagerAdapter(MainActivity.this, stringList);
                viewPager.setAdapter(viewPagerAdapter);


            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
