package com.example.zhou.broadcastreceiver_sample;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by zhou on 2016/12/2.
 */

public class SendBroadCastActivity extends Activity {
    public static final String TEST_BROADCAST = "com.example.broadcast";
    private TestBroadCastActivity testBroadCastActivity = new TestBroadCastActivity();
    //intentfilter动态注册广播,用来描述intent的各种属性
    private IntentFilter intentFilter = new IntentFilter();
    private Intent intent = new Intent();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciver);

        intentFilter.addAction("TEST_BROADCAST");
        registerReceiver(testBroadCastActivity, intentFilter);
        final Button sendButton = (Button) findViewById(R.id.bu_2);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setAction("TEST_BROADCAST");//当intent被触发时就会执行该行为
                intent.putExtra("toast", "发送广播成功！！");
                sendBroadcast(intent);

            }
        });
    }

}
