package com.example.realtime;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main6Activity extends AppCompatActivity {
    String s;
    ListView ls;
    ArrayList<String> ar;
    private ArrayAdapter<String> adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        ls = (ListView) findViewById(R.id.anls);
        SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        s = sh.getString("userphone", "defaultValue");
        ar = new ArrayList<>();
        AQuery aq = new AQuery(this);
        String url = "http://localhost:3000/history?received_id=" + s;
        aq.ajax(url, JSONObject.class, this, "JsoncallBack");
        adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ar);
        ls.setAdapter(adp);


    }

    public void JsoncallBack(String url, JSONObject json) throws JSONException {
        JSONArray userArray = json.getJSONArray("msg");
        for (int i = 0; i < userArray.length(); i++) {
            JSONObject userDetail = userArray.getJSONObject(i);
            ar.add("YOU HAVE   " + userDetail.getString("Status") + " " + " $" + userDetail.getString("amount") + "to   " + " " + userDetail.getString("received_id") + " " + " Transaction ID" + " " + userDetail.getString("trans_id"));
            adp.notifyDataSetChanged();
        }
    }

}
