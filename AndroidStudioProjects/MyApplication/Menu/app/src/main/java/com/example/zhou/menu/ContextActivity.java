package com.example.zhou.menu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ContextActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context);
        textView = (TextView) findViewById(R.id.textview);
        registerForContextMenu(textView);//为TextView控件注册ContextMenu
    }

    //响应ContextMenu菜单项单击
    public boolean onContextItemSelected(MenuItem item) {
        textView.setText(item.getTitle()+"选择执行");
        return super.onContextItemSelected(item);
    }
    //创建ContextMenu菜单
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,view,menuInfo);
        menu.setHeaderIcon(android.R.drawable.ic_menu_manage);
        menu.setHeaderTitle("请选择操作：");
        menu.add(Menu.NONE,Menu.FIRST,Menu.FIRST,"分享");
        menu.add(Menu.NONE,Menu.FIRST+1,Menu.FIRST+1,"删除");
        menu.add(Menu.NONE,Menu.FIRST+2,Menu.FIRST+2,"重命名");
    }
}
