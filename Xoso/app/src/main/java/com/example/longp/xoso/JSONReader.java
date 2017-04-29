package com.example.longp.xoso;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/**
 * Created by longp on 4/29/2017.
 */

public class JSONReader  {
    public final String URL1 = "http://thanhhungqb.tk:8080/kqxsmn";
    public  String res_1 ;
    public String data1;
    public JSONReader() {
    }

    public void JsonData(OkHttpClient client , final String province){

        Request request1 = new Request.Builder()
                .url(URL1)
                .build();
        client.newCall(request1).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.v("BK-201 URL",response.body().toString());
                res_1 = response.body().string();
                parse(res_1,province);
            }
        });

    }
    private void parse(String response,String province) {
        //do something with response
        try {
            JSONObject JObject  = new JSONObject(response);
            //Log.d("json", JObject.toString());
            if(JObject.has(province)) {
                Log.d("province", province);
                JSONObject stats = JObject.optJSONObject(province);
                Iterator keys = stats.keys();
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    data1 =data1 + key + "\n";
                    Log.d("key", key);
                    JSONObject day = stats.getJSONObject(key);
                    Iterator keyvalues = day.keys();
                    while (keyvalues.hasNext()) {
                        String keyvalue = (String) keyvalues.next();
                        Log.d("keyvalue", keyvalue);
                        JSONArray kq = day.getJSONArray(keyvalue);
                        Log.d("kq", kq.toString());
                        data1 = data1 + "\n" +keyvalue + ":" +kq.toString();
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("json",e.toString());
        }
    }
    public String travekq ()
    {
        Log.d("data1",data1);
        return data1;
    }
}
