package com.example.zhou.broadcastreceiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver2 extends BroadcastReceiver {
    static final String TAG="Tag";
    @Override
    public void onReceive(Context context, Intent intent) {
        //获取随Intent到达的数据
        String msg=intent.getStringExtra("msg");
        Log.i(TAG, "动态注册接收器，收到信息 》"+msg);
    }
}
