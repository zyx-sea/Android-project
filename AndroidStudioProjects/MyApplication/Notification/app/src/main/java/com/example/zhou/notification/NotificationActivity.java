package com.example.zhou.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class NotificationActivity extends AppCompatActivity {
    Button bt_1;
    private NotificationManager nmanager;
    private Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        bt_1 = (Button) findViewById(R.id.notification_button);
        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();
            }
        });
    }

    private void sendNotification() {
        //获得notificationmanager
        nmanager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //创建Notification
        notification = new Notification(R.drawable.fileph, "收到文件", System.currentTimeMillis());
        //设置属性，这些属性会在展开状态栏后显示
        Intent intent = new Intent(this, ToastActivity.class);//转向其他Activity
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        notification.setLatestEventInfo(this, "接收文件", "文件已下载完成", pIntent);
        //将Notification发送Manager
        nmanager.notify(1,notification);
    }
}
