package com.example.zhou.broadcastreceiver;

/**
 * Created by zhou on 2016/12/2.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {
    static final String TAG="Tag";
    @Override
    public void onReceive(Context context, Intent intent) {
        //获取随Intent到达的数据
        String msg=intent.getStringExtra("msg");
        Log.i(TAG, "接收器收到信息 》"+msg);
    }
}

