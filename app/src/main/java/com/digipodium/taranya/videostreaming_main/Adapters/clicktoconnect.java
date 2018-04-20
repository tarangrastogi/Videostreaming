package com.digipodium.taranya.videostreaming_main.Adapters;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.digipodium.taranya.videostreaming_main.R;

public class clicktoconnect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicktoconnect);

        final TextView name_wifi = findViewById(R.id.name_wifi);
        ImageView wifi_icon = findViewById(R.id.wifi_icon);
        EditText pass = findViewById(R.id.pass);
        Button btn_connect = findViewById(R.id.btn_connect);

        btn_connect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(true);
            }
        });
    }

























}
