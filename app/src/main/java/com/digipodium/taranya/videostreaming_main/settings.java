package com.digipodium.taranya.videostreaming_main;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class settings extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button wifi_jump = findViewById(R.id.wifi_jump);
        Button hotspot_jump = findViewById(R.id.hotspot_jump);

        wifi_jump.setOnClickListener(this);
        hotspot_jump.setOnClickListener(this);


            }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.wifi_jump:
                startActivity(new Intent(settings.this, wifiActivity.class));
                finish();
                break;
            case R.id.hotspot_jump:
                startActivity(new Intent(settings.this, home_activity.class));
                break;


    }
}

}
