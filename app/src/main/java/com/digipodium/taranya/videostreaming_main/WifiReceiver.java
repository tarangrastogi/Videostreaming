package com.digipodium.taranya.videostreaming_main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

import java.util.List;

/**
 * Created by lenovo on 4/10/2018.
 */

class WifiReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)) {
            WifiManager mWifiManager = null;
            List<ScanResult> mScanResults = mWifiManager.getScanResults();


        }




    }


}
