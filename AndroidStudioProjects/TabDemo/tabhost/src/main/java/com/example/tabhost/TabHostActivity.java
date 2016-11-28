package com.example.tabhost;

import android.app.TabActivity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

/**
 * Created by zhou on 2016/11/14.
 */

public class TabHostActivity extends TabActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        TabHost tabHost = getTabHost();

        TabSpec page1 = tabHost.newTabSpec("tab_1")
                .setIndicator("相对布局")
                .setContent(R.id.tab_1);
        tabHost.addTab(page1);

        TabSpec page2 = tabHost.newTabSpec("tab_2")
                .setIndicator("注册页面")
                .setContent(R.id.tab_2);
        tabHost.addTab(page2);

        TabSpec page3 = tabHost.newTabSpec("tab_3")
                .setIndicator("图片按钮")
                .setContent(R.id.tab_3);
        tabHost.addTab(page3);

    }
}
