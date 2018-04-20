package com.digipodium.taranya.videostreaming_main;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import com.digipodium.taranya.videostreaming_main.Adapters.WifiListAdapter;

import java.util.ArrayList;
import java.util.List;


public class wifiActivity extends AppCompatActivity {

    private WifiManager mWifiManager;
    List<ScanResult> mWifiList;
    private WifiListAdapter mAdapter;
    private RecyclerView rv_showifi;
    private ProgressBar pb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Switch switch_wifion = findViewById(R.id.switch_wifion);
        pb = findViewById(R.id.pb_scan);
        pb.setVisibility(View.INVISIBLE);
        mWifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        TextView et_scan = findViewById(R.id.et_scan);
        mWifiList = new ArrayList<>();
        rv_showifi = findViewById(R.id.rv_showifi);
        final boolean enable = mWifiManager.isWifiEnabled();
        rv_showifi.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rv_showifi.setLayoutManager(mLayoutManager);

        if(enable){
            switch_wifion.setChecked(true);
            scan();
        }


        switch_wifion.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mWifiManager.setWifiEnabled(isChecked);
                    if(enable){
                        scan();
                    }
                }
            });
        et_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scan();
            }

        });

    }


    public void scan(){
        pb.setVisibility(View.VISIBLE);
        mWifiList.clear();
        mWifiList = mWifiManager.getScanResults();
        if(mWifiList != null){
            mAdapter = new WifiListAdapter(mWifiList);
            rv_showifi.setAdapter(mAdapter);
        }
        pb.setVisibility(View.INVISIBLE);
    }

}



