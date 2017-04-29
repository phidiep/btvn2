package com.example.longp.xoso;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import okhttp3.OkHttpClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class hcmFragment extends Fragment {
    public TextView text1 ;
    public hcmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcm, container, false);
        text1 = (TextView) view.findViewById(R.id.textView1);
        OkHttpClient client = new OkHttpClient();
        JSONReader test = new JSONReader();
        test.JsonData(client,"HCM");
      // text1.setText(test.travekq());
        return view;
    }
}
