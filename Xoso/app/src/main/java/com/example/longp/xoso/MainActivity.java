package com.example.longp.xoso;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import okhttp3.OkHttpClient;


public class MainActivity  extends FragmentActivity  {
    public final String URL1 = "http://thanhhungqb.tk:8080/kqxsmn";
    public  String res_1 ;
    public JSONObject kq ;
    public Spinner sProvince;

    public Spinner sDay;
    public Button btnChoose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   //     OkHttpClient client = new OkHttpClient();
//        JSONReader test = new JSONReader();
       // test.JsonData(client,"CT");
        callFragment(new hcmFragment());
    }

    private void callFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.fmContent, fragment);
        transaction.commit();
    }
    public void onClickBtn(View v)
    {
        sProvince = (Spinner)findViewById(R.id.spinner3);
        switch (sProvince.getSelectedItem().toString()){
            case "AG" :
                break;
            case  "BD":
                break;
            case  "BL":
                break;
            case  "BP":
                break;
            case  "BTH":
                break;
            case  "CM":
                break;
            case  "CT":
                callFragment(new ctFragment());
                break;
            case  "HCM":
                callFragment(new hcmFragment());
                break;
        }
    }
}
