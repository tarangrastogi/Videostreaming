package com.digipodium.taranya.videostreaming_main;


import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toolbar;


import java.util.List;

public class home_activity extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);
        Switch switch_wifi = findViewById(R.id.switch_wifion);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        switch_wifi.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener()


        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (!ApManager.isApOn(home_activity.this)) {
                        ApManager.configApState(getApplicationContext());

                    }
                } else {
                    if (ApManager.isApOn(home_activity.this)) {
                        ApManager.configApState(getApplicationContext());

                    }

                }

            }
        });

    }
}




