package com.example.zhou.broadcastreceiver_sample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by zhou on 2016/12/2.
 */

public class TestBroadCastActivity extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent!=null){
            if (TextUtils.equals(intent.getAction(),SendBroadCastActivity.TEST_BROADCAST));
            String toaststring=intent.getStringExtra("toast");
            Toast.makeText(context,toaststring, Toast.LENGTH_SHORT).show();
        }
    }
}
