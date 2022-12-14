package com.example.realtime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONObject;

public class Main5Activity extends AppCompatActivity {
    String s;
    EditText phone;
    EditText amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        s = sh.getString("userphone", "defaultValue");
        phone = (EditText) findViewById(R.id.phone);
        amount = (EditText) findViewById(R.id.amount);

    }


    public void JsoncallBack(String url, JSONObject json) {

        if (json != null) {
            try {
                String msg = json.getString("msg");

                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                if (msg.equals("Your Account has Been Registered")) {

                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);
                }

            } catch (Exception ignored) {
            }
        }
    }

    public void register(View v) {

        AQuery aq = new AQuery(this);
        String url = "http://localhost:3000/trans?received_id=" + phone.getText() + "&sender_id=" + s + "&amount=" + amount.getText();
        aq.ajax(url, JSONObject.class, this, "JsoncallBack");

    }
}
