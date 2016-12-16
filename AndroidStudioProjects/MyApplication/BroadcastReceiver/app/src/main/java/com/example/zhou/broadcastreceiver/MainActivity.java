package com.example.zhou.broadcastreceiver;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
    static final String TAG="Tag";
    Button b1,b2,b3,b4;
    Random rand=new Random();
    MyBroadcastReceiver2 receiver2; //广播接收器

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.bc_bt01);
        b1.setOnClickListener(this);
        b2=(Button) findViewById(R.id.bc_bt02);
        b2.setOnClickListener(this);
        b3=(Button) findViewById(R.id.bc_bt03);
        b3.setOnClickListener(this);
        b4=(Button) findViewById(R.id.bc_bt04);
        b4.setOnClickListener(this);
    }
    @Override
    public void onClick(View arg0) {
        if(arg0.getId()==R.id.bc_bt01){
            //
            Intent intent =new Intent(".MyBroadcastReceiver");
            intent.putExtra("msg","广播信息 ： 随机数 "+rand.nextInt(100));
            //发出广播
            //匹配com.freshen.code.MyBroadcastReceiver动作的广播接收器将接受到该广播
            sendBroadcast(intent);
            Log.i(TAG, "广播已发出");
        }
        if(arg0.getId()==R.id.bc_bt02){
            //注册广播接收器
            receiver2=new MyBroadcastReceiver2();
            IntentFilter filter =new IntentFilter(".MyBroadcastReceiver2");
            registerReceiver(receiver2, filter);//执行注册
            Log.i(TAG, "广播接收器已注册");
        }else if(arg0.getId()==R.id.bc_bt03){
            //发送广播
            Intent intent=new Intent("com.freshen.code.MyBroadcastReceiver2");
            intent.putExtra("msg","广播信息 ： 随机数 "+rand.nextInt(100));
            //发出广播
            //匹配com.freshen.code.MyBroadcastReceiver动作的广播接收器将接受到该广播
            sendBroadcast(intent);
            Log.i(TAG, "广播已发出");
        }else if(arg0.getId()==R.id.bc_bt04){
            //解除广播接收器
            if(receiver2!=null){
                unregisterReceiver(receiver2);//取消注册
                receiver2=null;
            }
            Log.i(TAG, "执行解除注册操作");
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除广播接收器
        if(receiver2!=null)
            unregisterReceiver(receiver2);//取消注册
    }

}
