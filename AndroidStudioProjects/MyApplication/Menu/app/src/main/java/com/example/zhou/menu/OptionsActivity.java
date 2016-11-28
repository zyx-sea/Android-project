package com.example.zhou.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by zhou on 2016/11/18.
 */

public class OptionsActivity extends Activity {
    TextView textView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context);
        textView= (TextView) findViewById(R.id.textview);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        textView.append("创建菜单功能\n");
        menu.add(Menu.NONE,Menu.FIRST,Menu.FIRST,"新建").setIcon(android.R.drawable.ic_menu_add);
        menu.add(Menu.NONE,Menu.FIRST+1,Menu.FIRST+1,"保存").setIcon(android.R.drawable.ic_menu_save);
        menu.add(Menu.NONE,Menu.FIRST+2,Menu.FIRST+2,"删除").setIcon(android.R.drawable.ic_menu_delete);
        menu.add(Menu.NONE,Menu.FIRST+3,Menu.FIRST+3,"历史").setIcon(android.R.drawable.ic_menu_recent_history);
        menu.add(Menu.NONE,Menu.FIRST+4,Menu.FIRST+4,"信息").setIcon(android.R.drawable.ic_menu_info_details);
        menu.add(Menu.NONE,Menu.FIRST+5,Menu.FIRST+5,"帮助").setIcon(android.R.drawable.ic_menu_help);
        return true;
    }
    public boolean onMenuOpened(int featureId,Menu menu){
        textView.append("监听菜单打开\n");
        return super.onMenuOpened(featureId,menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        textView.append("监听选中菜单项打开"+item.getTitle()+"选中\n");
        return super.onOptionsItemSelected(item);
    }
    public  void onOptionsMenuClosed(Menu menu){
        textView.append("监听菜单关闭");
        super.onOptionsMenuClosed(menu);
    }
    public boolean onPreareOptionsMenu(Menu menu){
        textView.append("进行菜单调整");
        return super.onCreateOptionsMenu(menu);
    }
}
